package com.finalproject.daycare.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalproject.daycare.entity.Parent;
import com.finalproject.daycare.entity.User;
import com.finalproject.daycare.repository.IUserRepo;
import com.finalproject.daycare.service.AuthService;
import com.finalproject.daycare.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/parent/")
public class ParentRestController {

    @Autowired
    private AuthService authService;

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private ParentService parentService;


    @PostMapping("")
    public ResponseEntity<Map<String, String>> registerParent(
            @RequestPart(value = "user") String userJson,
            @RequestPart(value = "parent") String parentJson,
            @RequestParam(value = "photo") MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userJson, User.class);
        Parent parent = objectMapper.readValue(parentJson, Parent.class);

        try {
            authService.registerParent(user, file, parent);
            Map<String, String> response = new HashMap<>();
            response.put("Message", "User Added Successfully ");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Message", "User Add Faild " + e);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
