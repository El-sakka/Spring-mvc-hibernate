package com.sakkawy.Dao;

import java.util.List;

import com.sakkawy.Entity.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    // need to inject the session factory 
    @Autowired
    private SessionFactory sessionFactory;


    public CustomerDAOImpl(){}

    @Override
    public List<Customer> getCustomers() {
        
        // get the current hibernate session 
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query 
        Query<Customer> theQurey = currentSession.createQuery("from Customer",Customer.class);

        // execute qurey and get result list 
        List<Customer> customers = theQurey.getResultList();
        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        // get current hibernate session 
        Session currentSession = sessionFactory.getCurrentSession();
        // save/update the customer ... finally 
        currentSession.saveOrUpdate(theCustomer);   
    }

    @Override
    public Customer getCustomer(int theId) {
        // get current hibernate session 
        Session currentSession = sessionFactory.getCurrentSession();
        // now retriece/read from database using the primary key 
        Customer customer = currentSession.get(Customer.class, theId);

        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {
        // get current hibernate session 
        Session currentSession = sessionFactory.getCurrentSession();
        // now delete object with primary key 
        Query theQuery = currentSession.createQuery("delete from Customer where id=:theCustomerId");
        theQuery.setParameter("theCustomerId", theId);
        
        theQuery.executeUpdate();
    }


    
}
