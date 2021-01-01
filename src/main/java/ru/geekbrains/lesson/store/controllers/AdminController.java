package ru.geekbrains.lesson.store.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lesson.store.entities.Category;
import ru.geekbrains.lesson.store.entities.Order;
import ru.geekbrains.lesson.store.entities.Product;
import ru.geekbrains.lesson.store.exceptions.ResourceNotFoundException;
import ru.geekbrains.lesson.store.services.CategoryService;
import ru.geekbrains.lesson.store.services.OrderService;
import ru.geekbrains.lesson.store.services.ProductService;
import ru.geekbrains.lesson.store.utils.OrderFilter;
import ru.geekbrains.lesson.store.utils.ProductFilter;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@Secured({"ROLE_ADMIN","ROLE_SUPER_ADMIN", "ROLE_MANAGER"})
@RequestMapping("/admin")
public class AdminController {

    private ProductService productService;
    private OrderService orderService;
    private CategoryService categoryService;

    public AdminController(
            ProductService productService,
            OrderService orderService,
            CategoryService categoryService
    ) {
        this.productService = productService;
        this.orderService = orderService;
        this.categoryService = categoryService;
    }


    @GetMapping("/products")
    public String showAllProducts(Model model,
                                  @RequestParam(defaultValue = "1",name = "p") Integer page,
                                  @RequestParam Map<String,String> params
    ){
        page = (page < 1) ? 1 : page;
        ProductFilter productFilter = new ProductFilter(params);
        Page<Product> products = productService.findAll(productFilter.getSpecification(),page-1,5);
        model.addAttribute("products",products);
        model.addAttribute("filterDefinition",productFilter.getFilterDefinition());

        return "products";
    }

    @GetMapping("/products/add")
    @Secured({"ROLE_ADMIN","ROLE_SUPER_ADMIN"})
    public String addProduct(
            Model model
    ){
        model.addAttribute("product",new Product());
        return "product_add_form";
    }

    @PostMapping("/products/add")
    @Secured({"ROLE_ADMIN","ROLE_SUPER_ADMIN"})
    public String addProduct(
            @Valid @ModelAttribute Product product,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            return"product_add_form";
        }
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    @Secured({"ROLE_ADMIN","ROLE_SUPER_ADMIN"})
    public String showEditProductForm(
            @PathVariable Long id,
            Model model
    ){
        Product product = productService.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
        model.addAttribute("product", product);
        return "product_edit_form";
    }

    @PostMapping("/products/edit")
    @Secured({"ROLE_ADMIN","ROLE_SUPER_ADMIN"})
    public String showEditProductForm(
            @ModelAttribute Product product
    ){
        productService.saveOrUpdate(product);
        return"redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    @Secured({"ROLE_ADMIN","ROLE_SUPER_ADMIN"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String deleteOneById(
            @PathVariable Long id
    ){
        productService.deleteById(id);
        return "ok";
    }

    @GetMapping("/orders")
    public String orders(
            @RequestParam Map<String,String> params,
            @RequestParam (defaultValue = "1",name = "p") Integer page,
            Model model
    ){
        page = (page < 1) ? 1 : page;
        OrderFilter orderFilter = new OrderFilter(params);
        Page<Order> orders = orderService.findAll(orderFilter.getSpecification(), page-1, 3);
        model.addAttribute("orders",orders);
        model.addAttribute("filterDefinition", orderFilter.getFilterDefinition());
        return "orders";
    }

    @GetMapping("/orders/remove/{id}")
    @Secured({"ROLE_ADMIN","ROLE_SUPER_ADMIN"})
    public String remove(
            @PathVariable("id") Long id
    ){
        orderService.remove(id);
        return "redirect:/orders";
    }

    @GetMapping("/category")

    public  String showAllCategory(
            Model model
    ){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "categories";
    }

    @GetMapping("/category/edit/{id}")
    @Secured({"ROLE_ADMIN","ROLE_SUPER_ADMIN"})
    public String showEditCategoryForm(
            @PathVariable Long id,
            Model model
    ){
        Category category = categoryService.findById(id)
                                .orElseThrow(()->new ResourceNotFoundException("category", id));
        model.addAttribute("category", category);
        return "category_edit_form";
    }

    @PostMapping("/category/edit")
    @Secured({"ROLE_ADMIN","ROLE_SUPER_ADMIN"})
    public String showEditCategoryForm(
            @ModelAttribute Category category
    ){
        categoryService.saveOrUpdate(category);
        return"redirect:/products";
    }
}
