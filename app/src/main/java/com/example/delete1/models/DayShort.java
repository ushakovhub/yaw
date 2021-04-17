package com.example.delete1.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


//https://www.jsonschema2pojo.org/
//https://yandex.ru/dev/weather/doc/dg/concepts/forecast-test.html
public class DayShort {
    @SerializedName("_source")
    @Expose
    private String _source;
    @SerializedName("temp")
    @Expose
    private Integer temp;
    @SerializedName("temp_min")
    @Expose
    private Integer temp_min;
    @SerializedName("wind_speed")
    @Expose
    private Integer wind_speed;
    @SerializedName("wind_gust")
    @Expose
    private Double wind_gust;
    @SerializedName("wind_dir")
    @Expose
    private String wind_dir;
    @SerializedName("pressure_mm")
    @Expose
    private Integer pressure_mm;
    @SerializedName("pressure_pa")
    @Expose
    private Integer pressure_pa;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("soil_temp")
    @Expose
    private Integer soil_temp;
    @SerializedName("soil_moisture")
    @Expose
    private Double soil_moisture;
    @SerializedName("prec_mm")
    @Expose
    private Double prec_mm;
    @SerializedName("prec_prob")
    @Expose
    private Integer prec_prob;
    @SerializedName("prec_period")
    @Expose
    private Integer prec_period;
    @SerializedName("cloudness")
    @Expose
    private Integer cloudness;
    @SerializedName("prec_type")
    @Expose
    private Integer prec_type;
    @SerializedName("prec_strength")
    @Expose
    private Double prec_strength;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("uv_index")
    @Expose
    private Integer uv_index;
    @SerializedName("feels_like")
    @Expose
    private Integer feels_like;
    @SerializedName("daytime")
    @Expose
    private String daytime;
    @SerializedName("polar")
    @Expose
    private Boolean polar;


    public Integer getTemp() {
        return temp;
    }

    public Integer getTemp_min() {
        return temp_min;
    }

    public Integer getWind_speed() {
        return wind_speed;
    }


    public String getWind_dir() {
        return wind_dir;
    }


    public Integer getCloudness() {
        return cloudness;
    }

    public Integer getPrec_type() {
        return prec_type;
    }


    @Override
    public String   toString() {
        return "DayShort{" +
                "_source='" + _source + '\'' +
                ", temp=" + temp +
                ", temp_min=" + temp_min +
                ", wind_speed=" + wind_speed +
                ", wind_gust=" + wind_gust +
                ", wind_dir='" + wind_dir + '\'' +
                ", pressure_mm=" + pressure_mm +
                ", pressure_pa=" + pressure_pa +
                ", humidity=" + humidity +
                ", soil_temp=" + soil_temp +
                ", soil_moisture=" + soil_moisture +
                ", prec_mm=" + prec_mm +
                ", prec_prob=" + prec_prob +
                ", prec_period=" + prec_period +
                ", cloudness=" + cloudness +
                ", prec_type=" + prec_type +
                ", prec_strength=" + prec_strength +
                ", icon='" + icon + '\'' +
                ", condition='" + condition + '\'' +
                ", uv_index=" + uv_index +
                ", feels_like=" + feels_like +
                ", daytime='" + daytime + '\'' +
                ", polar=" + polar +
                '}';
    }
}
