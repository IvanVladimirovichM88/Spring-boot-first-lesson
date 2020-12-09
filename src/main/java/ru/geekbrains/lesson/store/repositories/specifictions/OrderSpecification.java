package ru.geekbrains.lesson.store.repositories.specifictions;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.lesson.store.entities.Order;

public class OrderSpecification {
    public static Specification<Order> priceGreaterOrEqualsThan(int minPrice){
        return (Specification<Order>)(root, criteriaQuery, criteriaBuilder)->
                criteriaBuilder.greaterThanOrEqualTo(root.get("currentPrice"),minPrice);
    }

    public static Specification<Order> priceLesserOrEqualsThan(int maxPrice){
        return (Specification<Order>)(root, criteriaQuery, criteriaBuilder)->
                criteriaBuilder.lessThanOrEqualTo(root.get("currentPrice"),maxPrice);
    }

    public static Specification<Order> codeLike(String codePart){
        return (Specification<Order>)(root, criteriaQuery, criteriaBuilder)->
                criteriaBuilder.like(root.get("code"), String.format("%%%s", codePart));
    }

    public static Specification<Order> customerNameEquals(String name){
        return (Specification<Order>)(root, criteriaQuery, criteriaBuilder)->
                criteriaBuilder.equal(root.join("customer").get("name"), name);
    }
}
