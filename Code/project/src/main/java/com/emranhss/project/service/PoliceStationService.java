package com.emranhss.project.service;


import com.emranhss.project.entity.PoliceStation;
import com.emranhss.project.repository.IPoliceStationeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliceStationService {

    @Autowired
private IPoliceStationeRepo iPoliceStationeRepo;


    public void saveOrUpdate(PoliceStation ps){
        iPoliceStationeRepo.save(ps);
    }

    public List<PoliceStation> findAll(){
        return iPoliceStationeRepo.findAll();
    }

    public Optional<PoliceStation> findById(Integer id){
        return iPoliceStationeRepo.findById(id);
    }

    public void deleteBYId(Integer id){
        iPoliceStationeRepo.deleteById(id);
    }



}
