package com.example.apiproject;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    List<Country> Data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=findViewById(R.id.bt);


        listView = findViewById(R.id.listView);
        ArrayAdapter<Country> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, Data);
        listView.setAdapter(adapter);

        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<CountryResponse> call = apiService.getCountries();
  bt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          call.enqueue(new Callback<CountryResponse>() {
              @Override
              public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                  if (response.isSuccessful()) {
                      CountryResponse currencyresponse = response.body();
                      for(Country c : currencyresponse.getCountries())
                      {
                          Data.add(c);

                      }

                      adapter.notifyDataSetChanged();



                  } else {
                      // Handle the error
                      Log.e("API Error", "Error: " + response.code());
                  }
              }

              @Override
              public void onFailure(Call<CountryResponse> call, Throwable t) {
                  // Handle the failure
                  Log.e("API Failure", "Error: " + t.getMessage());
              }
          });
      }
  });
    }
}
