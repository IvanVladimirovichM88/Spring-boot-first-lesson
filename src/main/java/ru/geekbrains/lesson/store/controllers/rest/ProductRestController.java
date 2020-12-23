package ru.geekbrains.lesson.store.controllers.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.lesson.store.data.ProductData;
import ru.geekbrains.lesson.store.entities.Product;
import ru.geekbrains.lesson.store.facade.ProductFacade;
import ru.geekbrains.lesson.store.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product/api/v1")
public class ProductRestController {

    private ProductService productService;
    private ProductFacade productFacade;

    public ProductRestController(ProductService productService, ProductFacade productFacade) {
        this.productService = productService;
        this.productFacade = productFacade;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> productsToJson(){
        return productService.findAll();
    }

    @GetMapping(value = "/jsonData/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductData productDataToJson(
            @PathVariable Long id
    ){
        return productFacade.getProductById(id);
    }
}
