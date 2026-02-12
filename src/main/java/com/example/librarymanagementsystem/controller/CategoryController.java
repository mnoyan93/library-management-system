package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Category;
import com.example.librarymanagementsystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public String category(ModelMap modelMap) {
        List<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        return "category";
    }

    @GetMapping("/category/delete")
    public String deleteCategory(@RequestParam("id") int id) {
        categoryRepository.deleteById(id);
        return "redirect:/category";
    }

    @GetMapping("/addCategory")
    public String addCategoryForm() {
        return "addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategorySubmit(@RequestParam String name,
                                    @RequestParam String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);

        categoryRepository.save(category);
        return "redirect:/category";
    }
}
