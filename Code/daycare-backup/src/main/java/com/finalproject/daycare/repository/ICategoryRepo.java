package com.finalproject.daycare.repository;

import com.finalproject.daycare.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends JpaRepository<Category, Integer> {
}

