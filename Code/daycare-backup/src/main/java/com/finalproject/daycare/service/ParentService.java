package com.finalproject.daycare.service;

import com.finalproject.daycare.entity.Caregiver;
import com.finalproject.daycare.entity.Parent;
import com.finalproject.daycare.jwt.JwtService;
import com.finalproject.daycare.repository.IParentRepository;
import com.finalproject.daycare.repository.ITokenRepository;
import com.finalproject.daycare.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {

    @Autowired
    private IParentRepository parentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private ITokenRepository tokenRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CaregiverService caregiverService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;


    @Value("src/main/resources/static/images")
    private String uploadDir;

    public Optional<Parent> getById(Long id) {
        return parentRepository.findById(id);
    }

    public List<Parent> getAll() {
        return parentRepository.findAll();
    }

    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }

    public void delete(Long id) {
        parentRepository.deleteById(id);
    }

    public Parent getProfileByUserId(int userId) {
        return parentRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));
    }
}
