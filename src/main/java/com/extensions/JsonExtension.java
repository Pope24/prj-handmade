package com.extensions;

import com.google.gson.Gson;
public class JsonExtension {
    private static final Gson gson = new Gson();

    public static float[] jsonToFloatArray(String json) {
        try {
            return gson.fromJson(json, float[].class);
        } catch (Exception e) {
            e.printStackTrace();
            return new float[0];
        }
    }
    public static String floatArrayToJson(float[] array) {
        try {
            return gson.toJson(array);
        } catch (Exception e) {
            e.printStackTrace();
            return "[]";
        }
    }
}
