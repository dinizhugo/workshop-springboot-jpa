package com.hugodiniz.course.repositories;

import com.hugodiniz.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, Long> {
}
