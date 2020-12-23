package ru.geekbrains.lesson.store.populators;

import org.springframework.stereotype.Service;
import ru.geekbrains.lesson.store.data.ProductData;
import ru.geekbrains.lesson.store.entities.Product;

@Service
public class ProductPopulator implements Populator<Product, ProductData> {
    @Override
    public ProductData populate(Product product, ProductData productData) {
        if (product == null || productData == null)
            return null;
        productData.setId(product.getId());
        productData.setTitle(product.getTitle());
        productData.setCategoryName(product.getCategory().getTitle());
        productData.setPrice(product.getPrice());
        productData.setCreateDate(product.getCreateDate());
        productData.setModifyDate(product.getModifyDate());
        return productData;
    }

    @Override
    public ProductData populate(Product product) {
        return populate(product, new ProductData());
    }
}
