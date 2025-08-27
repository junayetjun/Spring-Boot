package com.finalproject.daycare.restcontroller;

import com.finalproject.daycare.dto.TrainingDTO;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Training;
import com.finalproject.daycare.entity.User;
import com.finalproject.daycare.repository.IUserRepo;
import com.finalproject.daycare.service.CaregiverService;
import com.finalproject.daycare.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training/")
public class TrainingRestController {

    @Autowired
    private CaregiverService caregiverService;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private IUserRepo userRepo;


    @PostMapping("add")
    public ResponseEntity<Training> addTraining(@RequestBody Training training, Authentication authentication) {
        String email = authentication.getName();  // Logged-in user's email
        Training savedTraining = trainingService.save(training, email);
        return ResponseEntity.ok(savedTraining);
    }

    @GetMapping("all")
    public ResponseEntity<List<TrainingDTO>> getTrainingsByJobSeeker(Authentication authentication) {
        String email = authentication.getName();

        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        Caregiver caregiver = caregiverService.getProfileByUserId(user.getId());

        List<TrainingDTO> trainings = trainingService.getByCareGiverId(caregiver.getId());

        return ResponseEntity.ok(trainings);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long id) {
        trainingService.delete(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }

}
