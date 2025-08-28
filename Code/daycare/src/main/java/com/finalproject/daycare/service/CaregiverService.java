package com.finalproject.daycare.service;

import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Categories;
import com.finalproject.daycare.repository.CaregiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaregiverService {

    @Autowired
    private CaregiverRepository caregiverRepository;

    public List<Caregiver> getAll() {
        return caregiverRepository.findAll();
    }

    public Optional<Caregiver> getById(Long id) {
        return caregiverRepository.findById(id);
    }

    public Caregiver save(Caregiver caregiver) {
        return caregiverRepository.save(caregiver);
    }

    public void delete(Long id) {
        caregiverRepository.deleteById(id);
    }

//    public Caregiver getProfileByUserId(int userId) {
//        return caregiverRepository.findByUserId(userId)
//                .orElseThrow(() -> new RuntimeException("Caregiver not found"));
//    }

    // ✅ Updated method to use the correct repository call
    public List<Caregiver> getByCategory(String categoryName) {
        try {
            Categories category = Categories.valueOf(categoryName.toUpperCase());
            return caregiverRepository.findByCategoriesContaining(category);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid category: " + categoryName);
        }
    }

    //for practice
    // ✅ Get caregiver profile by email (used in controller for /profile)
    public Caregiver getProfileByEmail(String email) {
        return caregiverRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Caregiver not found for email: " + email));
    }
}
