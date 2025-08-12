package com.finalproject.daycare.service;

import com.finalproject.daycare.entity.Caregiver;
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

    public Caregiver getProfileByUserId(int userId) {
        return caregiverRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Job Seeker not found"));
    }
}
