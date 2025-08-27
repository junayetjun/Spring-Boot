package com.finalproject.daycare.service;

import com.finalproject.daycare.dto.TrainingDTO;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Training;
import com.finalproject.daycare.repository.CaregiverRepository;
import com.finalproject.daycare.repository.ITrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingService {

    @Autowired
    private ITrainingRepository trainingRepository;

    @Autowired
    private CaregiverRepository caregiverRepository;


    public List<TrainingDTO> getByCareGiverId(Long careGiverId) {
        List<Training> trainings = trainingRepository.findByCaregiverId(careGiverId);

        return trainings.stream()
                .map(TrainingDTO::new)
                .collect(Collectors.toList());
    }


    public Training save(Training training, String email) {

        Caregiver caregiver = caregiverRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("CareGiver not found"));
        training.setCaregiver(caregiver);
        return trainingRepository.save(training);
    }

    public void delete(Long id) {
        trainingRepository.deleteById(id);
    }
}
