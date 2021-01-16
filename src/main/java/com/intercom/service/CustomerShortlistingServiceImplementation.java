package com.intercom.service;

import com.intercom.commons.Constants;
import com.intercom.model.Customer;
import com.intercom.model.Location;
import com.intercom.utility.DistanceHelper;

import java.util.ArrayList;
import java.util.List;

public class CustomerShortlistingServiceImplementation implements CustomerShortlistingService {
    private final List<Customer> allCustomers;
    private final Location office = new Location(Constants.OFFICE_LATITUDE, Constants.OFFICE_LONGITUDE);

    public CustomerShortlistingServiceImplementation(List<Customer> allCustomers) {
        this.allCustomers = allCustomers;
    }

    /***
     * Sorts a list of Customer objects by user_id in ascending order
     * @param customerList List of customer objects
     * @return Sorted list of customer objects
     */
    @Override
    public List<Customer> sortCustomersById(List<Customer> customerList) {

        customerList.sort((Customer c1, Customer c2) -> c1.getUser_id() - c2.getUser_id());
        return customerList;
    }

    /***
     * Creates a list of Customers withing a certain distance from office coordinates (53.339428, -6.257664)
     * @param distance Threshold distance in km
     * @return List of Customer objects within input distance
     */
    @Override
    public List<Customer> getCustomersByDistance(double distance) {
        List<Customer> shortlistedCustomers = new ArrayList<>();
        allCustomers.forEach((Customer c) -> {
            double d = DistanceHelper.getDistance(c.getLocation(), office);
            if (d < distance)
                shortlistedCustomers.add(c);
        });
        return shortlistedCustomers;
    }
}


