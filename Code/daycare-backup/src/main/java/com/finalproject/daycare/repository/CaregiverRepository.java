package com.finalproject.daycare.repository;

import com.finalproject.daycare.entity.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Long> {

    Optional<Caregiver> findByUserId(int userId);

    @Query("SELECT js FROM Caregiver js WHERE js.user.email = :email")
    Optional<Caregiver> findByUserEmail(@Param("email") String email);

    @Query("SELECT j FROM Caregiver j LEFT JOIN FETCH j.educations WHERE j.id = :id")
    Optional<Caregiver> findByIdWithEducations(@Param("id") Long id);
}
