package com.phamtan.do_an.dao.repositories;

import com.phamtan.do_an.dao.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
