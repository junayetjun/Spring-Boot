package com.finalproject.daycare.restcontroller;

import com.finalproject.daycare.dto.ReferenceDTO;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Reference;
import com.finalproject.daycare.entity.User;
import com.finalproject.daycare.repository.IUserRepo;
import com.finalproject.daycare.service.CaregiverService;
import com.finalproject.daycare.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reference/")
public class ReferenceRestController {

    @Autowired
    private ReferenceService referenceService;

    @Autowired
    private CaregiverService caregiverService;

    @Autowired
    private IUserRepo userRepo;

//    @PostMapping("add")
//    public ResponseEntity<Reference> addReference(@RequestBody Reference reference, Authentication authentication) {
//        String email = authentication.getName();
//        Reference savedReference = referenceService.save(reference, email);
//        return ResponseEntity.ok(savedReference);
//    }

//    @GetMapping("all")
//    public ResponseEntity<List<ReferenceDTO>> getReferencesByCaregiver(Authentication authentication) {
//        String email = authentication.getName();
//
//        User user = userRepo.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//        Caregiver caregiver = caregiverService.getProfileByUserId(user.getId());
//
//        List<ReferenceDTO> references = referenceService.getByCaregiverId(caregiver.getId());
//
//        return ResponseEntity.ok(references);
//    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteReference(@PathVariable Long id) {
        referenceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
