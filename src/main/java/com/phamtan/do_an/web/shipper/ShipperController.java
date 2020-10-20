package com.phamtan.do_an.web.shipper;

import com.phamtan.do_an.dao.entities.Customer;
import com.phamtan.do_an.dao.entities.Shipper;
import com.phamtan.do_an.services.impl.CustomerServiceImpl;
import com.phamtan.do_an.services.impl.ShipperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shippers")
public class ShipperController {
    /*
     *           ALL METHOD WITH SHIPPER  API
     *
     * */

    @Autowired
    private ShipperServiceImpl shipperService ;

    @GetMapping
    public List<Shipper> getAll(){
        List<Shipper> shippers  = shipperService.getAll();
        return shippers;
    }

    @GetMapping("/{id}")
    public Shipper getById(@PathVariable(name = "id")  long id ){
        Shipper shipper = shipperService.getById(id);
        return shipper;
    }
    @PostMapping
    public long add(Shipper shipper){
        long id  = shipperService.save(shipper);
        return id;
    }
    @PatchMapping
    public long update(Shipper shipper){
        long id  = shipperService.update(shipper);
        return id;
    }
    @DeleteMapping
    public long delete(long  id){
        long result  = shipperService.delete(id);
        return result;
    }
}

