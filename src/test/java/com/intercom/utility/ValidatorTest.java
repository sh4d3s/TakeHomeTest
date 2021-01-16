package com.intercom.utility;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTest {

    @Test
    void validate() {
        String invalidName = "Mr Malicious%00\u0000";
        String invalidLat = "+90.1";
        String invalidLong = "180";
        String validJSON = "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}";

        JSONObject object = new JSONObject(validJSON);
        assertEquals(true, Validator.validate(object), "JSON Validation failed for valid JSON data");

        object.put("latitude", invalidLat);
        assertEquals(false, Validator.validate(object), "JSON Validation failed for invalid latitude data");

        object.put("longitude", invalidLong);
        assertEquals(false, Validator.validate(object), "JSON Validation failed for invalid longitude data");

        object.put("name", invalidName);
        assertEquals(false, Validator.validate(object), "JSON Validation failed for invalid name data");

        object.put("user_id", 1111111111);
        assertEquals(false, Validator.validate(object), "JSON Validation failed for invalid user_id data");


    }
}