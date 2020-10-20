package com.phamtan.do_an.web.order;

import com.phamtan.do_an.dao.entities.Order;
import com.phamtan.do_an.dao.entities.Review;
import com.phamtan.do_an.services.impl.OrderServiceImpl;
import com.phamtan.do_an.services.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    /*
 *           ALL METHOD WITH ORDER  API
 *
 * */

    @Autowired
    private OrderServiceImpl orderService ;

    @GetMapping
    public List<Order> getAll(){
        List<Order> orders  = orderService.getAll();
        return orders;
    }

    @GetMapping("{/id")
    public Order getById(@PathVariable(name = "id") long id ){
        Order order = orderService.getById(id);
        return order;
    }
    @PostMapping
    public long add(Order order){
        long id  = orderService.save(order);
        return id;
    }
    @PatchMapping
    public long update(Order order){
        long id  = orderService.update(order);
        return id;
    }
    @DeleteMapping
    public long delete(long  id){
        long result  = orderService.delete(id);
        return result;
    }
}
