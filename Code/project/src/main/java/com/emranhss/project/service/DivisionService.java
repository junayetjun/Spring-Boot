package com.emranhss.project.service;

import com.emranhss.project.dto.DivisionResponseDTO;
import com.emranhss.project.entity.Division;
import com.emranhss.project.repository.IDivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {

    @Autowired
    private IDivisionRepo iDivisionRepo;


    private List<Division> getAllDivisions(){
        return iDivisionRepo.findAll();
    }

    public List<DivisionResponseDTO> getAllDivisionsDTOs(){
        return getAllDivisions().stream().map(div -> {
            DivisionResponseDTO dto = new DivisionResponseDTO();
            dto.setId(div.getId());
            dto.setName(div.getName());

            List<Integer> districtsIds =div.getDistricts().stream()
                    .map(d -> d.getId())
                    .toList();
            dto.setDistricts(districtsIds);

            return dto;
        }).toList();
    }


    public Division saveDivision(Division division){
        return  iDivisionRepo.save(division);
    }

}
