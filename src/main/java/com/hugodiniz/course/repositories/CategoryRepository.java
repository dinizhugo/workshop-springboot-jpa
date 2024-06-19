package com.hugodiniz.course.repositories;

import com.hugodiniz.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
