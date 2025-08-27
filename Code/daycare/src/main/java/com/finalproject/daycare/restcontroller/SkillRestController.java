package com.finalproject.daycare.restcontroller;

import com.finalproject.daycare.dto.SkillDTO;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Skill;
import com.finalproject.daycare.entity.User;
import com.finalproject.daycare.repository.IUserRepo;
import com.finalproject.daycare.service.CaregiverService;
import com.finalproject.daycare.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill/")
public class SkillRestController {


    @Autowired
    private SkillService skillService;

    @Autowired
    private CaregiverService caregiverService;

    @Autowired
    private IUserRepo userRepo;


//    @PostMapping("add")
//    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill, Authentication authentication) {
//        String email = authentication.getName();
//        Skill savedSkill = skillService.save(skill, email);
//        return ResponseEntity.ok(savedSkill);
//    }


//    @GetMapping("all")
//    public ResponseEntity<List<SkillDTO>> getSkillsByCareGiver(Authentication authentication) {
//        String email = authentication.getName();
//
//        User user = userRepo.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//        Caregiver caregiver = caregiverService.getProfileByUserId(user.getId());
//
//        List<SkillDTO> skills = skillService.getByCareGiverId(caregiver.getId());
//
//        return ResponseEntity.ok(skills);
//    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
