package com.finalproject.daycare.repository;

import com.finalproject.daycare.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILanguageRepository extends JpaRepository<Language, Long> {
    List<Language> findByCaregiverId(Long caregiverId);
}
