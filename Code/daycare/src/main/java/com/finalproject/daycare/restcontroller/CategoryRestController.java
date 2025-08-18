package com.finalproject.daycare.restcontroller;

import com.finalproject.daycare.dto.CategoryResponseDTO;
import com.finalproject.daycare.entity.Category;
import com.finalproject.daycare.repository.ICategoryRepo;
import com.finalproject.daycare.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories/")
public class CategoryRestController {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ICategoryRepo categoryRepo;


    // Get all categories as DTOs
    @GetMapping("")
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryService.getAllCategoryDTOs();
    }


    // Get single country by ID (full entity)
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCountryById(@PathVariable int id) {
        return categoryRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Create new categories
    @PostMapping("")
    public ResponseEntity<Category> createCountry(@RequestBody Category category) {
        Category savedCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(savedCategory);
    }


    // Update existing category
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        Optional<Category> existingCategoryOpt = categoryService.getAllCategories()
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        if (existingCategoryOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Category existingCategory = existingCategoryOpt.get();
        existingCategory.setName(category.getName());
        // You can update divisions if needed, but usually divisions are managed separately

        Category updatedCategory = categoryService.saveCategory(existingCategory);
        return ResponseEntity.ok(updatedCategory);
    }

    // Delete country by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        Optional<Category> existingCategoryOpt = categoryService.getAllCategories()
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        if (existingCategoryOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        categoryService.saveCategory(existingCategoryOpt.get()); // you can remove this line if unnecessary
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
