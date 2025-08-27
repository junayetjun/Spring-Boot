package com.finalproject.daycare.service;

import com.finalproject.daycare.dto.LanguageDTO;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Language;
import com.finalproject.daycare.repository.CaregiverRepository;
import com.finalproject.daycare.repository.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {

    @Autowired
    private ILanguageRepository languageRepository;

    @Autowired
    private CaregiverRepository caregiverRepository;

    public List<LanguageDTO> getByCaregiverId(Long caregiverId) {
        List<Language> languages = languageRepository.findByCaregiverId(caregiverId);
        return languages.stream()
                .map(LanguageDTO::new)
                .collect(Collectors.toList());
    }

//    public Language save(Language language, String email) {
//        Caregiver caregiver = caregiverRepository.findByUserEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("Caregiver not found"));
//
//        language.setCaregiver(caregiver);
//        return languageRepository.save(language);
//    }

    public void delete(Long id) {
        languageRepository.deleteById(id);
    }
}
