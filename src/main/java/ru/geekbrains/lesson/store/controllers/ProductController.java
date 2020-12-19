package ru.geekbrains.lesson.store.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lesson.store.entities.Category;
import ru.geekbrains.lesson.store.entities.Product;
import ru.geekbrains.lesson.store.exceptions.ResourceNotFoundException;
import ru.geekbrains.lesson.store.services.CategoryService;
import ru.geekbrains.lesson.store.services.ProductService;
import ru.geekbrains.lesson.store.utils.ProductFilter;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showAllProducts(
            Model model,
            @RequestParam (defaultValue = "1", name = "p") Integer page,
            @RequestParam (defaultValue = "0", name = "category_id") Long categoryId,
            @RequestParam Map<String,String> params
    ){
        page = (page < 1) ? 1 : page;
        ProductFilter productFilter = new ProductFilter(params);
        Page<Product> products = productService.findAll(productFilter.getSpecification(), page-1, 5);
        Optional<Category> category = categoryService.findById(categoryId);
        model.addAttribute("categoryTitle", category.isPresent() ?
                                                "Категория: " + category.get().getTitle() :
                                                "");
        model.addAttribute("products", products);
        model.addAttribute("filterDefinition", productFilter.getFilterDefinition());
        return "products";
    }

    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "product_add_form";
    }

    @PostMapping("/add")
    public String addProduct(
            @Valid @ModelAttribute Product product,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            return "product_add_form";
        }
        productService.addProduct(product);
        return  "redirect:/products";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Product getOneProductById(@PathVariable Long id){
        return productService.findById(id).orElseThrow( ()-> new ResourceNotFoundException(id));
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Product p = productService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id,"for edit"));
        model.addAttribute("product",p);
        return "product_edit_form";
    }

    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute Product product){
        productService.saveOrUpdate(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String deleteOneProductById(@PathVariable Long id){
        productService.deleteById(id);
        return "ok";
    }
}
