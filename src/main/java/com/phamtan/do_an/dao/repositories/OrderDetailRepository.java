package com.phamtan.do_an.dao.repositories;

import com.phamtan.do_an.dao.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository  extends JpaRepository<OrderDetail,Long> {
}
