package com.emranhss.project.service;

import com.emranhss.project.entity.User;
import com.emranhss.project.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepo iUserRepo;

    @Autowired
    private EmailService emailService;

    public void saveOrUpdate(User user){
        iUserRepo.save(user);
    }

    public List<User> findAll(){
        return  iUserRepo.findAll();
    }

    public User findById(int id){
        return iUserRepo.findById(id).get();
    }

    public void delete(User user){
        iUserRepo.delete(user);
    }

}
