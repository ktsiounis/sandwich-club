package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        String mainName;
        List<String> alsoKnownAs = null;
        String placeOfOrigin;
        String description;
        String image;
        List<String> ingredients = null;

        try {
            JSONObject jsonObj = new JSONObject(json);
            mainName = jsonObj.getJSONObject("name").get("mainName").toString();
            //alsoKnownAs = jsonObj.getJSONObject("name").getJSONArray("alsoKnownAs");
            placeOfOrigin = jsonObj.get("placeOfOrigin").toString();
            description = jsonObj.get("description").toString();
            image = jsonObj.get("image").toString();
            //alsoKnownAs = jsonObj.getJSONObject("ingredients");
            return new Sandwich(mainName,null,placeOfOrigin,description,image,null);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
