package com.finalproject.daycare.repository;

import com.finalproject.daycare.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Long> {

    List<Experience> findByCaregiverId(Long caregiverId);

}
