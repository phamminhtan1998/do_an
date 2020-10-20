package com.phamtan.do_an.services.impl;

import com.phamtan.do_an.dao.entities.Shipper;
import com.phamtan.do_an.dao.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperServiceImpl {
/*
*
*           ALL THE METHOD WITH THE SHIPPER
*
* */

    @Autowired
    private ShipperRepository shipperRepository ;

    public List<Shipper> getAll(){
       List<Shipper> shippers =  shipperRepository.findAll();
       if(shippers.size()>0&&shippers!=null){
           return shippers;
       }
       return null;
    }

    public Shipper getById(long id ){
        Shipper shipper = shipperRepository.findById(id).get();
        if(shipper!=null){
            return shipper;
        }
        return null ;
    }
    public long save(Shipper shipper ){
        Shipper shipper1 = shipperRepository.save(shipper);
        if(shipper1!=null){
            return shipper1.getId();
        }
        return 0 ;
    }
    public long update(Shipper shipper ){
        Shipper shipper1 = shipperRepository.save(shipper);
        if(shipper1!=null){
            return shipper1.getId();
        }
        return 0 ;
    }
    public long delete(long id){
        shipperRepository.deleteById(id);
       return  id;
    }
}
