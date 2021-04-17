package com.example.delete1.rest;

import com.example.delete1.models.DayShort;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class MyDeserializer implements JsonDeserializer<DayShort>
{
    @Override
    public DayShort deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException
    {
        // Get the "content" element from the parsed JSON


       JsonElement content = je
                .getAsJsonObject().get("forecasts")
                .getAsJsonArray().get(0)
                .getAsJsonObject().get("parts")
                .getAsJsonObject().get("day_short");

        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer
        return new Gson().fromJson(content, DayShort.class);

    }
}
