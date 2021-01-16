package com.intercom.utility;

import com.intercom.model.Customer;
import com.intercom.model.Location;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
    /***
     * Takes a string containing customer data, one per line, JSON formatted and returns a list of Customer objects after validation.
     * @param fileContent String of customer data in JSON, one per line
     * @return List of Customers objects
     */
    public static List<Customer> getCustomerList(String fileContent) {
        if (fileContent == null || fileContent.isEmpty())
            throw new RuntimeException("Empty or Null String");
        List<Customer> allCustomers = new ArrayList<>();
        String[] lines = fileContent.split("\\r?\\n");
        for (String line : lines) {
            JSONObject obj = new JSONObject(line);

            if (Validator.validate(obj)) {
                Customer customer = new Customer(obj.getInt("user_id"));
                customer.setName(obj.getString("name"));
                customer.setLocation(new Location(obj.getDouble("latitude"), obj.getDouble("longitude")));
                allCustomers.add(customer);
            }
        }
        return allCustomers;
    }
}

