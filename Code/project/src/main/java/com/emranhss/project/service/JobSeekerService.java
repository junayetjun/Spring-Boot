package com.emranhss.project.service;

import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.repository.IJobSeekerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerService {


    @Autowired
    private IJobSeekerRepo iJobSeekerRepo;


    public List<JobSeeker> getAll(){
       return iJobSeekerRepo.findAll();
    }

    public Optional<JobSeeker> getById(Long id){
        return iJobSeekerRepo.findById(id);
    }

    public JobSeeker save(JobSeeker jobSeeker){
        return iJobSeekerRepo.save(jobSeeker);
    }

    public void delete(Long id){
        iJobSeekerRepo.deleteById(id);
    }

}
