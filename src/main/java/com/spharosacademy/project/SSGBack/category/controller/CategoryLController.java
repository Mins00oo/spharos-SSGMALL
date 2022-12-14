package com.spharosacademy.project.SSGBack.category.controller;

import com.spharosacademy.project.SSGBack.category.entity.CategoryL;
import com.spharosacademy.project.SSGBack.category.dto.input.RequestCategoryLDto;
import com.spharosacademy.project.SSGBack.category.service.CategoryLService;
import com.spharosacademy.project.SSGBack.category.dto.output.CategoryLDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CateL")
@RequiredArgsConstructor
@CrossOrigin
public class CategoryLController {

    private final CategoryLService categoryLService;


    @PostMapping("/add")
    public CategoryL addCategoryL(@RequestBody RequestCategoryLDto categoryLDto) {
        return categoryLService.addCategoryL(categoryLDto);
    }

    @GetMapping("/getAll")
    public List<CategoryL> getAll() {
        return categoryLService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryLById(@PathVariable Integer id) {
        categoryLService.deleteCategoryLById(id);
    }

    @GetMapping("/get/{id}")
    public CategoryLDto categoryL(@PathVariable Integer id) {
        return categoryLService.getCategoryLById(id);
    }

    @PutMapping("/edit")
    public CategoryL editCategoryLById(@RequestBody RequestCategoryLDto categoryLDto) {
        return categoryLService.editCategoryL(categoryLDto);
    }
}
