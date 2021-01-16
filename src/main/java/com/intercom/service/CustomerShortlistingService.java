package com.intercom.service;

import com.intercom.model.Customer;

import java.util.List;

public interface CustomerShortlistingService {
    List<Customer> sortCustomersById(List<Customer> customerList);

    List<Customer> getCustomersByDistance(double distance);
}
