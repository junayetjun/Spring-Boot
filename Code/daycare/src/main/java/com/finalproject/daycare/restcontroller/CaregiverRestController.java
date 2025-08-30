package com.finalproject.daycare.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Categories;
import com.finalproject.daycare.entity.User;
import com.finalproject.daycare.repository.CaregiverRepository;
import com.finalproject.daycare.repository.IUserRepo;
import com.finalproject.daycare.service.AuthService;
import com.finalproject.daycare.service.CaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/caregiver/")
public class CaregiverRestController {

    @Autowired
    private AuthService userService;

    @Autowired
    private CaregiverRepository caregiverRepository;

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private CaregiverService caregiverService;

    @PostMapping("")
    public ResponseEntity<Map<String, String>> registerCaregiver(
            @RequestPart(value = "user") String userJson,
            @RequestPart(value = "caregiver") String caregiverJson,
            @RequestParam(value = "photo") MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userJson, User.class);
        Caregiver caregiver = objectMapper.readValue(caregiverJson, Caregiver.class);

        try {
            userService.registerCaregiver(user, file, caregiver);
            Map<String, String> response = new HashMap<>();
            response.put("Message", "User Added Successfully ");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Message", "User Add Failed: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<Categories[]> getCategories() {
        return ResponseEntity.ok(Categories.values());
    }


    @GetMapping("all")
    public ResponseEntity<List<Caregiver>> getAllUsers() {
        List<Caregiver> caregiverList = caregiverService.getAll();
        return ResponseEntity.ok(caregiverList);
    }


    //for checking
    @GetMapping("/caregiver/profile")
    public ResponseEntity<Caregiver> getCaregiverProfile(Authentication authentication) {
        String email = authentication.getName(); // Or however you identify the logged-in caregiver
        Caregiver caregiver = caregiverService.getProfileByEmail(email); // Or appropriate lookup

        if (caregiver == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(caregiver);
    }


   @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        String email = authentication.getName();
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            Caregiver caregiver = caregiverService.getProfileByUserId(user.get().getId());
            return ResponseEntity.ok(caregiver);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

//     ✅ NEW: Get caregivers by category
    @GetMapping("/category/{category}")
    public ResponseEntity<?> getCaregiversByCategory(@PathVariable String category) {
        try {
            List<Caregiver> caregivers = caregiverService.getByCategory(category);
            return ResponseEntity.ok(caregivers);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Invalid category: " + category);
        }
    }
}
