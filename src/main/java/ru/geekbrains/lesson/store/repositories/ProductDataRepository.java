package ru.geekbrains.lesson.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.lesson.store.data.ProductData;
import ru.geekbrains.lesson.store.entities.Product;

import java.util.List;

public interface ProductDataRepository  extends JpaRepository<Product,Long> {

    @Query("SELECT new ru.geekbrains.lesson.store.data.ProductData(p) FROM Product p ")
    List<ProductData> findAllProductData();
}
