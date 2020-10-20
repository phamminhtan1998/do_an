package com.phamtan.do_an.services.impl;

import com.phamtan.do_an.dao.entities.Order;
import com.phamtan.do_an.dao.entities.Review;
import com.phamtan.do_an.dao.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl {
    @Autowired
    private ReviewRepository reviewRepository ;

    public List<Review> getAll(){
        List<Review> reviews =  reviewRepository.findAll();
        if(reviews.size()>0&&reviews!=null){
            return reviews;
        }
        return null;
    }

    public Review getById(long id ){
        Review review = reviewRepository.findById(id).get();
        if(review!=null){
            return review;
        }
        return null ;
    }
    public long save(Review review ){
        Review review1 = reviewRepository.save(review);
        if(review1!=null){
            return review1.getId();
        }
        return 0 ;
    }
    public long update(Review review ){
        Review review1 = reviewRepository.save(review);
        if(review1!=null){
            return review1.getId();
        }
        return 0 ;
    }
    public long delete(long id){
        reviewRepository.deleteById(id);
        return  id;
    }
}