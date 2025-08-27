package com.finalproject.daycare.repository;

import com.finalproject.daycare.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISkillRepo extends JpaRepository<Skill, Long> {
     List<Skill> findByCaregiverId(Long caregiverId);
}
