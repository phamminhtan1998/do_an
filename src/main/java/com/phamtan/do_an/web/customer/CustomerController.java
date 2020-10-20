package com.phamtan.do_an.web.customer;

import com.phamtan.do_an.dao.entities.Customer;
import com.phamtan.do_an.services.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
/*
*           ALL METHOD WITH CUSTOMER  API
*
* */

    @Autowired
    private CustomerServiceImpl customerService ;

    @GetMapping
    public List<Customer> getAll(){
        List<Customer> customers  = customerService.getAll();
        return customers;
    }

    @GetMapping("{/id}")
    public Customer getById(@PathVariable(name = "id") long id ){
        Customer customer = customerService.getById(id);
        return customer;
    }
    @PostMapping
    public long add(Customer customer){
        long id  = customerService.save(customer);
        return id;
    }
    @PatchMapping
    public long updateCustomer(Customer customer){
        long id  = customerService.update(customer);
        return id;
    }
    @DeleteMapping
    public long delete(long  id){
        long result  = customerService.delete(id);
        return result;
    }
}
