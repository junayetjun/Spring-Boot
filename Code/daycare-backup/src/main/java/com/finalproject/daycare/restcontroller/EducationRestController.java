package com.finalproject.daycare.restcontroller;

import com.finalproject.daycare.dto.EducationDTO;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Education;
import com.finalproject.daycare.entity.User;
import com.finalproject.daycare.repository.IUserRepo;
import com.finalproject.daycare.service.CaregiverService;
import com.finalproject.daycare.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/education/")
public class EducationRestController {

    @Autowired
    private EducationService educationService;
    @Autowired
    private CaregiverService caregiverService;

    @Autowired
    private IUserRepo userRepo;

    @PostMapping("add")
    public ResponseEntity<Education> addEducation(@RequestBody Education education, Authentication authentication) {
        String email = authentication.getName();  // Logged-in user's email
        Education savedEducation = educationService.saveEducation(education, email);
        return ResponseEntity.ok(savedEducation);
    }

    @GetMapping("all")
    public ResponseEntity<List<EducationDTO>> getEducationsByJobSeeker(Authentication authentication) {
        // Get logged-in user email
        String email = authentication.getName();

        Optional<User> user =userRepo.findByEmail(email);
        Caregiver caregiver = caregiverService.getProfileByUserId(user.get().getId());


        List<EducationDTO> educations = educationService.getByCaregiverId(caregiver.getId());


        return ResponseEntity.ok(educations);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        educationService.delete(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
