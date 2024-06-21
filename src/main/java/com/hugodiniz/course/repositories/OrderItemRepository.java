package com.hugodiniz.course.repositories;

import com.hugodiniz.course.entities.OrderItem;
import com.hugodiniz.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
