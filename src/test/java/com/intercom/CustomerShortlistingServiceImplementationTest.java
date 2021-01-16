package com.intercom;

import com.intercom.model.Customer;
import com.intercom.service.CustomerShortlistingServiceImplementation;
import com.intercom.utility.FileProcessor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerShortlistingServiceImplementationTest {

    final String jsonData = "" +
            "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}\n" +
            "{\"latitude\": \"51.92893\", \"user_id\": 1, \"name\": \"Alice Cahill\", \"longitude\": \"-10.27699\"}\n" +
            "{\"latitude\": \"51.8856167\", \"user_id\": 2, \"name\": \"Ian McArdle\", \"longitude\": \"-10.4240951\"}";
    List<Customer> list = FileProcessor.getCustomerList(jsonData);
    final CustomerShortlistingServiceImplementation customerShortlistingServiceImplementationTest = new CustomerShortlistingServiceImplementation(list);


    @Test
    void getCustomersByDistance() {
        assertEquals(0, customerShortlistingServiceImplementationTest.getCustomersByDistance(10).size(), "Incorrect Result for getCustomerByDistance");
        assertEquals(1, customerShortlistingServiceImplementationTest.getCustomersByDistance(50).size(), "Incorrect Result for getCustomerByDistance");
        assertEquals(2, customerShortlistingServiceImplementationTest.getCustomersByDistance(315).size(), "Incorrect Result for getCustomerByDistance");
    }

    @Test
    void sortCustomersById() {

        list = customerShortlistingServiceImplementationTest.sortCustomersById(list);
        assertEquals(1, list.get(0).getUser_id(), "Sort module is not working");
        assertEquals(12, list.get(2).getUser_id(), "Sort module is not working");

    }

}