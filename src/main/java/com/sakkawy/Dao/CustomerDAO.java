package com.sakkawy.Dao;

import java.util.List;
import com.sakkawy.Entity.Customer;

public interface CustomerDAO {
    
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
