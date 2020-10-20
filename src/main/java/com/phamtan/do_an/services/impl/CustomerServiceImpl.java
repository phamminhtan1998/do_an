package com.phamtan.do_an.services.impl;

import com.phamtan.do_an.dao.entities.Customer;
import com.phamtan.do_an.dao.entities.Review;
import com.phamtan.do_an.dao.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {
    @Autowired
    private CustomerRepository customerRepository ;

    public List<Customer> getAll(){
        List<Customer> customers =  customerRepository.findAll();
        if(customers.size()>0&&customers!=null){
            return customers;
        }
        return null;
    }

    public Customer getById(long id ){
        Customer customer = customerRepository.findById(id).get();
        if(customer!=null){
            return customer;
        }
        return null ;
    }
    public long save(Customer customer ){
        Customer customer1 = customerRepository.save(customer);
        if(customer1!=null){
            return customer1.getId();
        }
        return 0 ;
    }
    public long update(Customer customer ){
        Customer customer1 = customerRepository.save(customer);
        if(customer1!=null){
            return customer1.getId();
        }
        return 0 ;
    }
    public long delete(long id){
        customerRepository.deleteById(id);
        return  id;
    }
}