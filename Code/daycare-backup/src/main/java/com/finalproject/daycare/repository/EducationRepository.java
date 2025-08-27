package com.finalproject.daycare.repository;

import com.finalproject.daycare.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
   // List<Education> findByCareGiverId(Long careGiverId);
   // List<Education> findByCareGiverId(Long careGiverId);


    List<Education> findByCaregiverId(Long caregiverId);
}
