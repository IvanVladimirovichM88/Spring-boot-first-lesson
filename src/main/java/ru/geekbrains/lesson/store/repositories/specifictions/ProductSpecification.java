package ru.geekbrains.lesson.store.repositories.specifictions;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.lesson.store.entities.Product;

public class ProductSpecification {
    public static Specification<Product> priceGreaterOrEqualsThan(int minPrice){
        return (Specification<Product>)(root,criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"),minPrice);
    }

    public static   Specification<Product> priceLesserOrEqualsThan(int maxPrice){
        return (Specification<Product>) (root,criteriaQuery,criteriaBuilder)->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"),maxPrice);
    }

    public static Specification<Product> titleLike(String titlePart){
        return (Specification<Product>) (root,criteriaQuery,criteriaBuilder)->
                criteriaBuilder.like(root.get("title"),String.format("%%%s%%",titlePart));
    }

    public static Specification<Product> categoryIdEqualsThan(Long categoryId){
        return (Specification<Product>) (root,criteriaQuary,criteriaBuilder)->
                criteriaBuilder.equal(root.join("category").get("id"),categoryId);
    }

}
