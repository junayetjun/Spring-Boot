package com.finalproject.daycare.service;

import com.finalproject.daycare.dto.EducationDTO;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Education;
import com.finalproject.daycare.repository.CaregiverRepository;
import com.finalproject.daycare.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private CaregiverRepository caregiverRepository;

    public List<EducationDTO> getByCaregiverId(Long careGiverId) {
        List<Education> educations = educationRepository.findByCaregiverId(careGiverId);
        return educations.stream()
                .map(EducationDTO::new)
                .collect(Collectors.toList());
    }

    public Education saveEducation(Education education, String email) {

        Caregiver caregiver = caregiverRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Caregiver not found"));

        education.setCaregiver(caregiver);

        return educationRepository.save(education);
    }

    public void delete(Long id) {
        educationRepository.deleteById(id);
    }

}
