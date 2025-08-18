package com.finalproject.daycare.service;

import com.finalproject.daycare.dto.CategoryResponseDTO;
import com.finalproject.daycare.entity.Category;
import com.finalproject.daycare.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepo categoryRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public List<CategoryResponseDTO> getAllCategoryDTOs() {
        return getAllCategories().stream().map(c -> {
            CategoryResponseDTO dto = new CategoryResponseDTO();
            dto.setId(c.getId());
            dto.setName(c.getName());

//            List<Integer> divisionIds = c.getDivisions().stream()
//                    .map(d -> d.getId())
//                    .toList();


            return dto;
        }).toList();
    }


    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    public void deleteById(int id) {
        categoryRepo.deleteById(id);
    }

}
