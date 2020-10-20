package com.phamtan.do_an.web.review;

import com.phamtan.do_an.dao.entities.Review;
import com.phamtan.do_an.dao.entities.Shipper;
import com.phamtan.do_an.services.impl.ReviewServiceImpl;
import com.phamtan.do_an.services.impl.ShipperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reviews")

public class ReviewController {
    /*
     *           ALL METHOD WITH REVIEWS  API
     *
     * */

    @Autowired
    private ReviewServiceImpl reviewService ;

    @GetMapping
    public List<Review> getAll(){
        List<Review> reviews  = reviewService.getAll();
        return reviews;
    }

    @GetMapping("{/id}")
    public Review getById(@PathVariable(name = "id") long id ){
        Review review = reviewService.getById(id);
        return review;
    }
    @PostMapping()
    public long add(Review review){
        long id  = reviewService.save(review);
        return id;
    }
    @PatchMapping
    public long update(Review review){
        long id  = reviewService.update(review);
        return id;
    }
    @DeleteMapping
    public long delete(long  id){
        long result  = reviewService.delete(id);
        return result;
    }
}