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
        List<String> alsoKnownAs = new ArrayList<>();
        String placeOfOrigin;
        String description;
        String image;
        List<String> ingredients = new ArrayList<>();

        try {
            JSONObject jsonObj = new JSONObject(json);
            mainName = jsonObj.getJSONObject("name").get("mainName").toString();

            JSONArray alsoKnownAsArray = jsonObj.getJSONObject("name").getJSONArray("alsoKnownAs");
            for (int i=0; i<alsoKnownAsArray.length(); i++){
                String subname = alsoKnownAsArray.getString(i);
                alsoKnownAs.add(subname);
            }

            placeOfOrigin = jsonObj.get("placeOfOrigin").toString();
            description = jsonObj.get("description").toString();
            image = jsonObj.get("image").toString();

            JSONArray ingredientsArray = jsonObj.getJSONArray("ingredients");
            for (int i=0; i<ingredientsArray.length(); i++){
                String ingredient = ingredientsArray.getString(i);
                ingredients.add(ingredient);
            }

            return new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
