package com.finalproject.daycare.restcontroller;

import com.finalproject.daycare.dto.LanguageDTO;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Language;
import com.finalproject.daycare.entity.User;
import com.finalproject.daycare.repository.IUserRepo;
import com.finalproject.daycare.service.CaregiverService;
import com.finalproject.daycare.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language/")
public class LanguageRestController {

    @Autowired
    private LanguageService languageService;

    @Autowired
    private CaregiverService caregiverService;

    @Autowired
    private IUserRepo userRepo;

    @PostMapping("add")
    public ResponseEntity<Language> addLanguage(@RequestBody Language language, Authentication authentication) {
        String email = authentication.getName();
        Language savedLanguage = languageService.save(language, email);
        return ResponseEntity.ok(savedLanguage);
    }

    @GetMapping("all")
    public ResponseEntity<List<LanguageDTO>> getLanguagesByCaregiver(Authentication authentication) {
        String email = authentication.getName();

        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        Caregiver caregiver = caregiverService.getProfileByUserId(user.getId());

        List<LanguageDTO> languages = languageService.getByCaregiverId(caregiver.getId());

        return ResponseEntity.ok(languages);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long id) {
        languageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
