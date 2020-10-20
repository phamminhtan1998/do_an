package com.phamtan.do_an.services.impl;

import com.phamtan.do_an.dao.entities.Discounts;
import com.phamtan.do_an.dao.entities.Order;
import com.phamtan.do_an.dao.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl {

    @Autowired
    private OrderRepository orderRepository ;

    public List<Order> getAll(){
        List<Order> orders =  orderRepository.findAll();
        if(orders.size()>0&&orders!=null){
            return orders;
        }
        return null;
    }

    public Order getById(long id ){
        Order order = orderRepository.findById(id).get();
        if(order!=null){
            return order;
        }
        return null ;
    }
    public long save(Order order ){
        Order order1 = orderRepository.save(order);
        if(order1!=null){
            return order1.getId();
        }
        return 0 ;
    }
    public long update(Order order ){
        Order order1 = orderRepository.save(order);
        if(order1!=null){
            return order1.getId();
        }
        return 0 ;
    }
    public long delete(long id){
        orderRepository.deleteById(id);
        return  id;
    }
}
