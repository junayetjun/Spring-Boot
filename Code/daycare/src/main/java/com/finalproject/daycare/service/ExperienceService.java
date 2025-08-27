package com.finalproject.daycare.service;

import com.finalproject.daycare.dto.ExperienceDTO;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Experience;
import com.finalproject.daycare.repository.CaregiverRepository;
import com.finalproject.daycare.repository.IExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceService {

    @Autowired
    private IExperienceRepository experienceRepository;

    @Autowired
    private CaregiverRepository caregiverRepository;


    public List<ExperienceDTO> getByCaregiverId(Long caregiverId) {
        List<Experience> experiences = experienceRepository.findByCaregiverId(caregiverId);

        return experiences.stream()
                .map(ExperienceDTO::new)
                .collect(Collectors.toList());
    }


//    public Experience save(Experience experience, String email) {
//        Caregiver caregiver = caregiverRepository.findByUserEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("Caregiver not found"));
//        experience.setCaregiver(caregiver);
//        return experienceRepository.save(experience);
//    }

    public void delete(Long id) {
        experienceRepository.deleteById(id);
    }


}
