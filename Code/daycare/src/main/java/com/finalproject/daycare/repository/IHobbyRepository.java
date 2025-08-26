package com.finalproject.daycare.repository;

import com.finalproject.daycare.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHobbyRepository extends JpaRepository<Hobby,Long> {
    List<Hobby> findByCaregiverId(Long caregiverId);
}

