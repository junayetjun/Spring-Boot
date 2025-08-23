package com.finalproject.daycare.repository;

import com.finalproject.daycare.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChildRepository extends JpaRepository<Child, Long> {
    List<Child> findByParentId(Long parentId);
}
