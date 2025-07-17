package com.emranhss.project.restcontroller;

import com.emranhss.project.dto.DivisionResponseDTO;
import com.emranhss.project.entity.Division;
import com.emranhss.project.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/division/")
public class DivisionRestController {

    @Autowired
    private DivisionService divisionService;


    @GetMapping("")
    public ResponseEntity<List<DivisionResponseDTO>> getDivisions(){
        List<DivisionResponseDTO> dtoList = divisionService.getAllDivisionsDTOs();
        return ResponseEntity.ok(dtoList);
    }


    public ResponseEntity<Division> createDivision(@RequestBody Division division){
        Division saved = divisionService.saveDivision(division);
        return ResponseEntity.ok(saved);
    }

}
