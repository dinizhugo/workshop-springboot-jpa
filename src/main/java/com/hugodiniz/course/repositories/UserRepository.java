package com.hugodiniz.course.repositories;

import com.hugodiniz.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
