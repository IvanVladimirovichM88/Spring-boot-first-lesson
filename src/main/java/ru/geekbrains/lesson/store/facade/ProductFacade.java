package ru.geekbrains.lesson.store.facade;

import org.springframework.stereotype.Service;
import ru.geekbrains.lesson.store.data.ProductData;
import ru.geekbrains.lesson.store.entities.Product;
import ru.geekbrains.lesson.store.populators.ProductPopulator;
import ru.geekbrains.lesson.store.repositories.ProductDataRepository;
import ru.geekbrains.lesson.store.services.ProductService;

import java.util.List;

@Service
public class ProductFacade {

    private ProductPopulator productPopulator;
    private ProductService productService;
    private ProductDataRepository productDataRepository;

    public ProductFacade(ProductPopulator productPopulator, ProductService productService, ProductDataRepository productDataRepository) {
        this.productPopulator = productPopulator;
        this.productService = productService;
        this.productDataRepository = productDataRepository;
    }

    public ProductData getProductById(Long id){
        Product product = productService.findById(id).get();
        return new ProductData(product);
    }

    public List<ProductData> getAllProductData(){
        return productPopulator.convertAll(productService.findAll());
    }
    public List<ProductData> getAllProductDataFromRepository(){
        return productDataRepository.findAllProductData();
    }
}
