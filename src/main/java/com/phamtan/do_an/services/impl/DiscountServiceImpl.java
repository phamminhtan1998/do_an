package com.phamtan.do_an.services.impl;

import com.phamtan.do_an.dao.entities.Discounts;
import com.phamtan.do_an.dao.entities.Shipper;
import com.phamtan.do_an.dao.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl {
    @Autowired
    private DiscountRepository discountRepository ;

    public List<Discounts> getAll(){
        List<Discounts> discounts =  discountRepository.findAll();
        if(discounts.size()>0&&discounts!=null){
            return discounts;
        }
        return null;
    }

    public Discounts getById(long id ){
        Discounts discount = discountRepository.findById(id).get();
        if(discount!=null){
            return discount;
        }
        return null ;
    }
    public long save(Discounts discount ){
        Discounts discount1 = discountRepository.save(discount);
        if(discount1!=null){
            return discount1.getId();
        }
        return 0 ;
    }
    public long update(Discounts discount ){
        Discounts discount1 = discountRepository.save(discount);
        if(discount1!=null){
            return discount1.getId();
        }
        return 0 ;
    }
    public long delete(long id){
        discountRepository.deleteById(id);
        return  id;
    }
}
