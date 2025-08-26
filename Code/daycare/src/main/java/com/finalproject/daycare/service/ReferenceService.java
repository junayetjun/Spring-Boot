package com.finalproject.daycare.service;

import com.finalproject.daycare.dto.ReferenceDTO;
import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Reference;
import com.finalproject.daycare.repository.CaregiverRepository;
import com.finalproject.daycare.repository.IReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReferenceService {

    @Autowired
    private IReferenceRepository referenceRepository;

    @Autowired
    private CaregiverRepository caregiverRepository;

    public List<ReferenceDTO> getByCaregiverId(Long caregiverId) {
        List<Reference> references = referenceRepository.findByCaregiverId(caregiverId);
        return references.stream()
                .map(ReferenceDTO::new)
                .collect(Collectors.toList());
    }

    public Reference save(Reference reference, String email) {
        Caregiver caregiver = caregiverRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Caregiver not found"));

        reference.setCaregiver(caregiver);
        return referenceRepository.save(reference);
    }

    public void delete(Long id) {
        referenceRepository.deleteById(id);
    }

}
