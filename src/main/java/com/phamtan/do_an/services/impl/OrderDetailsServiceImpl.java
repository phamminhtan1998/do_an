package com.phamtan.do_an.services.impl;

import com.phamtan.do_an.dao.entities.Book_Discount;
import com.phamtan.do_an.dao.entities.OrderDetail;
import com.phamtan.do_an.dao.repositories.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl {
    @Autowired
    private OrderDetailRepository orderDetailRepository ;

    public List<OrderDetail> getAll(){
        List<OrderDetail> orderDetails  =  orderDetailRepository.findAll();
        if(orderDetails.size()>0&&orderDetails!=null){
            return orderDetails;
        }
        return null;
    }

    public OrderDetail getById(long id ){
        OrderDetail orderDetail = orderDetailRepository.findById(id).get();
        if(orderDetail!=null){
            return orderDetail;
        }
        return null ;
    }
    public long save(OrderDetail orderDetail ){
        OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);
        if(orderDetail1!=null){
            return orderDetail1.getId();
        }
        return 0 ;
    }
    public long update(OrderDetail orderDetail ){
        OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);
        if(orderDetail1!=null){
            return orderDetail1.getId();
        }
        return 0 ;
    }
    public long delete(long id){
        orderDetailRepository.deleteById(id);
        return  id;
    }
}
