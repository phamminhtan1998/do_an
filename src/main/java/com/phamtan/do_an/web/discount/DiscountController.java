package com.phamtan.do_an.web.discount;

import com.phamtan.do_an.dao.entities.Discounts;
import com.phamtan.do_an.dao.entities.Order;
import com.phamtan.do_an.services.impl.BookDiscountServiceImpl;
import com.phamtan.do_an.services.impl.DiscountServiceImpl;
import com.phamtan.do_an.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/discounts")
public class DiscountController {
    /*
     *           ALL METHOD WITH DISCOUNTS  API
     *
     * */

    @Autowired
    private DiscountServiceImpl discountService ;

    @GetMapping
    public List<Discounts> getAll(){
        List<Discounts> discounts  = discountService.getAll();
        return discounts;
    }

    @GetMapping("{/id}")
    public Discounts getById(@PathVariable(name = "id") long id ){
        Discounts discounts = discountService.getById(id);
        return discounts;
    }
    @PostMapping
    public long add(Discounts discounts){
        long id  = discountService.save(discounts);
        return id;
    }
    @PatchMapping
    public long update(Discounts discounts){
        long id  = discountService.update(discounts);
        return id;
    }
    @DeleteMapping
    public long delete(long  id){
        long result  = discountService.delete(id);
        return result;
    }
}

