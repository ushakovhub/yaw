package com.example.delete1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.delete1.models.DayShort;
import com.example.delete1.rest.ClientAPI;
import com.example.delete1.rest.MyDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private DayShort dayShort;
    private static final String LOG_TAG = "testApi";

    private TextView tv_temp, tv_temp_min,
            tv_wind_speed, tv_wind_dir;
    private ImageView iv_cloudness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_temp = findViewById(R.id.tv_temp);
        tv_temp_min = findViewById(R.id.tv_temp_min);
        tv_wind_speed = findViewById(R.id.tv_wind_speed);
        tv_wind_dir = findViewById(R.id.tv_wind_dir);
        iv_cloudness= findViewById(R.id.iv_cloudness);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .registerTypeAdapter(DayShort.class, new MyDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weather.yandex.ru/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ClientAPI api = retrofit.create(ClientAPI.class);
        Call<DayShort> call = api.test(45.02, 41.58, "ru_RU", 1, false, false, "8a1c58f5-831f-4000-b73f-a6ebfb7a5b3c");
        call.enqueue(new Callback<DayShort>() {
            @Override
            public void onResponse(Call<DayShort> call, Response<DayShort> response) {
                if (response.code() == 200) {
                    dayShort = response.body();
                    tv_temp.setText("t max\n\n" + dayShort.getTemp().toString() + (char)176 + "C");
                    tv_temp_min.setText("t max\n\n" + dayShort.getTemp_min().toString() + (char)176 + "C");
                    tv_wind_speed.setText("Скорость\n" + "ветра\n\n" + dayShort.getWind_speed().toString() + "м/с");

                    String wind_dir ="";
                    switch (dayShort.getWind_dir()){
                        case "nw": wind_dir = "северо-западное";
                        break;
                        case "n": wind_dir = "северное";
                            break;
                        case "ne": wind_dir = "северо-восточное";
                            break;
                        case "e": wind_dir = "восточное";
                            break;
                        case "se": wind_dir = "юго-восточное";
                            break;
                        case "s": wind_dir = "южное";
                            break;
                        case "sw": wind_dir = "юго-западное";
                            break;
                        case "w": wind_dir = "западное";
                            break;
                        case "с": wind_dir = "штиль";
                            break;
                    }
                    tv_wind_dir.setText("Направление\n" + "ветра\n\n" + wind_dir);

                    if (dayShort.getCloudness() == 0){
                        iv_cloudness.setImageDrawable(getDrawable(R.drawable.ic_sun));
                    }else if (dayShort.getPrec_type() > 0){
                        iv_cloudness.setImageDrawable(getDrawable(R.drawable.ic_raining));
                    }else {
                        iv_cloudness.setImageDrawable(getDrawable(R.drawable.ic_cloudy));
                    }

                    Log.d(LOG_TAG, dayShort.toString());
                } else {
                    Log.d(LOG_TAG, String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<DayShort> call, Throwable t) {
                Log.d(LOG_TAG, t.getMessage());
            }
        });

    }
}