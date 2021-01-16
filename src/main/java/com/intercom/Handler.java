package com.intercom;

import com.intercom.model.Customer;
import com.intercom.utility.FileHandler;
import com.intercom.utility.FileProcessor;
import org.json.JSONException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Handler {
    private final double distance;
    private final String filePath;

    /***
     * Constructor for initializing Handler object when only path to customers.txt is provided. By default distance is set as 100 km
     * @param filePath File path of customers.txt
     */
    Handler(String filePath) {
        this.filePath = filePath;
        this.distance = 100.0;
    }

    /***
     * Constructor for initializing Handler object when both path to customers.txt and distance is provided
     * @param filePath File path of customers.txt
     * @param distance Threshold distance for selecting customers
     *
     */
    Handler(String filePath, double distance) {
        this.filePath = filePath;
        this.distance = distance;
    }

    /***
     * Controls the flow of application
     */
    protected void runApplication() {

        String fileContents = null;
        try {
            fileContents = FileHandler.getFileContents(filePath);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file path provided is invalid");
        } catch (IOException ioException) {
            System.out.println("The application encountered an IO Exception");
        }
        try {
            Service service = new Service(FileProcessor.getCustomerList(fileContents));
            List<Customer> shortlistedCustomers = service.getCustomersByDistance(distance);
            shortlistedCustomers = service.sortCustomersById(shortlistedCustomers);
            System.out.format("%-20s%10s\n", "Name", "User ID");
            shortlistedCustomers.forEach(customer -> System.out.format("%-20s%10d\n", customer.getName(), customer.getUser_id()));
        } catch (JSONException jsonException) {
            System.out.println("Error parsing JSON data:" + jsonException.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println("Empty file");
        }

    }
}
