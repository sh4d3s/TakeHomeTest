package com.intercom.utility;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {


    String invalidName = "Mr Malicious%00\u0000";
    String invalidLat = "+90.1";
    String invalidLong = "181";
    String validJSON = "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}";
    JSONObject object = new JSONObject(validJSON);
    @Test
    void validate_TestValidJsonData_ReturnsTrue() {
        assertTrue(Validator.validate(object), "JSON Validation failed for valid JSON data");
    }
    @Test
    void validate_TestInvalidLatitude_ReturnsFalse() {
        object.put("latitude", invalidLat);
        assertFalse(Validator.validate(object), "JSON Validation failed for invalid latitude data");
    }
    @Test
    void validate_TestInvalidLongitude_ReturnsFalse() {
        object.put("longitude", invalidLong);
        assertFalse(Validator.validate(object), "JSON Validation failed for invalid longitude data");
    }
    @Test
    void validate_TestInvalidName_ReturnsFalse() {
        object.put("name", invalidName);
        assertFalse(Validator.validate(object), "JSON Validation failed for invalid name data");
    }
    @Test
    void validate_TestInvalidUserID_ReturnsFalse() {
        object.put("user_id", 1111111111);
        assertFalse(Validator.validate(object), "JSON Validation failed for invalid user_id data");

    }
}