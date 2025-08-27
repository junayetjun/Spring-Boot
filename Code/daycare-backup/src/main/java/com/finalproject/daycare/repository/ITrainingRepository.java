package com.finalproject.daycare.repository;

import com.finalproject.daycare.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findByCaregiverId(Long caregiverId);
}
