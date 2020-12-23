package ru.geekbrains.lesson.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.lesson.store.entities.Category;
import ru.geekbrains.lesson.store.services.CategoryService;
import ru.geekbrains.lesson.store.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public  String showAllCategory(
            Model model
    ){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "categories";
    }
}
