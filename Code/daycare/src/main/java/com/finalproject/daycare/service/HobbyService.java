package com.finalproject.daycare.service;

import com.finalproject.daycare.dto.HobbyDTO;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Hobby;
import com.finalproject.daycare.repository.CaregiverRepository;
import com.finalproject.daycare.repository.IHobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HobbyService {

    @Autowired
    private IHobbyRepository hobbyRepository;


    @Autowired
    private CaregiverRepository caregiverRepository;

    public List<HobbyDTO> getByCaregiverId(Long caregiverId) {
        List<Hobby> hobbies = hobbyRepository.findByCaregiverId(caregiverId);
        return hobbies.stream()
                .map(HobbyDTO::new)
                .collect(Collectors.toList());
    }

//    public Hobby save(Hobby hobby, String email) {
//        Caregiver caregiver = caregiverRepository.findByUserEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("Caregiver not found"));
//
//        hobby.setCaregiver(caregiver);
//        return hobbyRepository.save(hobby);
//    }

    public void delete(Long id) {
        hobbyRepository.deleteById(id);
    }
}
