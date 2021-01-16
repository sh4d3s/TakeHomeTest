package com.intercom.utility;

import com.intercom.model.Customer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileProcessorTest {

    @Test
    void getCustomerList_NullAsInput_ThrowsRuntimeException() {
        assertThrows(RuntimeException.class, () -> FileProcessor.getCustomerList(null), "getCustomerList() did not throw exception on null parameter");

    }
    @Test
    void getCustomerList_BlankStringAsInput_ThrowsRuntimeException() {
        assertThrows(RuntimeException.class, () -> FileProcessor.getCustomerList(""), "getCustomerList() did not throw exception on blank string parameter");
    }
    @Test
    void getCustomerList_ReadJSONTextTXTAndCreateCustomerList_CustomerListOfSize3Created()throws IOException {

        String jsonTest = String.valueOf(java.nio.file.Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "jsonTest.txt"));
        String jsonData;
        jsonData = FileHelper.getFileContents(jsonTest);

        List<Customer> list = FileProcessor.getCustomerList(jsonData);
        assertEquals(3, list.size(), "JSON Data parse error");
    }
    @Test
    void getCustomerList_ReadInvalidDataAndCreateCustomerList_ThrowsJSONException()throws IOException {
        String invalidDataPath = String.valueOf(java.nio.file.Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "test.txt"));
        String invalidData;
        invalidData = FileHelper.getFileContents(invalidDataPath);
        String finalInvalidData = invalidData;
        assertThrows(org.json.JSONException.class, () -> FileProcessor.getCustomerList(finalInvalidData));
    }
}