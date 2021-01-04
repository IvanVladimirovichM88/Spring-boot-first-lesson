package ru.geekbrains.lesson.store.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.lesson.store.entities.Category;
import ru.geekbrains.lesson.store.entities.Product;
import ru.geekbrains.lesson.store.services.CategoryService;
import ru.geekbrains.lesson.store.services.ProductService;
import ru.geekbrains.lesson.store.utils.ProductFilter;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;
    private ProductService productService;

    public CategoryController(CategoryService categoryService,ProductService productService){
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping
    public  String showAllCategory(
            Model model
    ){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "categories";
    }
    @GetMapping("/{id}")
    public String showAllProductsInCategory(
            @PathVariable Long id,
            Model model,
            @RequestParam(defaultValue = "1", name = "p") Integer page,
            @RequestParam Map<String,String> params
    ){
        params.put("category_id",id.toString());

        page = (page < 1) ? 1 : page;
        ProductFilter productFilter = new ProductFilter(params);
        Page<Product> products = productService.findAll(productFilter.getSpecification(),page-1,6);
        Optional<Category> category = categoryService.findById(id);

        model.addAttribute("categoryTitle", category.isPresent() ?
                                                    "Категория: " +category.get().getTitle() :
                                                    "");
        model.addAttribute("products", products);
        model.addAttribute("filterDefinition", productFilter.getFilterDefinition());
        model.addAttribute("categories", categoryService.findAll());
        return "all_products_in_category";
    }

}
