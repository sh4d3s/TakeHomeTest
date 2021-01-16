package com.intercom.utility;

import com.intercom.commons.Constants;
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

        if (!Pattern.matches(userIdPattern, String.valueOf(jsonObject.getInt(Constants.KEY_USER_ID))))
            return false;
        if (!Pattern.matches(namePattern, jsonObject.getString(Constants.KEY_NAME)))
            return false;
        if (!Pattern.matches(latPattern, jsonObject.getString(Constants.KEY_LATITUDE)))
            return false;
        if (!Pattern.matches(longPattern, jsonObject.getString(Constants.KEY_LONGITUDE)))
            return false;
        return true;

    }
}
