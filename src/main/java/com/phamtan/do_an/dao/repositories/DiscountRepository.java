package com.phamtan.do_an.dao.repositories;

import com.phamtan.do_an.dao.entities.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discounts,Long> {
}
