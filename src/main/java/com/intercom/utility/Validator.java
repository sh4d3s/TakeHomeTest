package com.intercom.utility;

import org.json.JSONObject;

import java.util.regex.Pattern;

public class Validator {
    /***
     * Validates JSONObject of customer details against regex patterns
     * @param jsonObject JSON Object of customer details
     * @return Returns true if all the values are valid, else returns false.
     */
    public static boolean validate(JSONObject jsonObject) {
        String namePattern = "^[a-zA-Z .']{0,100}";
        String latPattern = "^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)";
        String longPattern = "^[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$";
        String userIdPattern = "^[0-9]{0,8}";

        if (!Pattern.matches(userIdPattern, String.valueOf(jsonObject.getInt("user_id"))))
            return false;
        if (!Pattern.matches(namePattern, jsonObject.getString("name")))
            return false;
        if (!Pattern.matches(latPattern, jsonObject.getString("latitude")))
            return false;
        if (!Pattern.matches(longPattern, jsonObject.getString("longitude")))
            return false;
        return true;

    }
}
