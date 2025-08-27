package com.finalproject.daycare.service;

import com.finalproject.daycare.dto.SkillDTO;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Skill;
import com.finalproject.daycare.repository.CaregiverRepository;
import com.finalproject.daycare.repository.ISkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    @Autowired
    private ISkillRepo skillRepo;

    @Autowired
    private CaregiverRepository caregiverRepository;


    public List<SkillDTO> getByCareGiverId(Long careGiverId) {
        List<Skill> skills = skillRepo.findByCaregiverId(careGiverId);
        return skills.stream()
                .map(SkillDTO::new)
                .collect(Collectors.toList());
    }

//    public Skill save(Skill skill, String email) {
//        Caregiver caregiver = caregiverRepository.findByUserEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("Care Giver not found"));
//
//        skill.setCaregiver(caregiver);
//        return skillRepo.save(skill);
//    }

    public void delete(Long id) {
        skillRepo.deleteById(id);
    }
}
