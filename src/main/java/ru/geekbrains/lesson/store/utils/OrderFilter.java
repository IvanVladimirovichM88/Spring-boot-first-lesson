package ru.geekbrains.lesson.store.utils;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.lesson.store.entities.Order;
import ru.geekbrains.lesson.store.repositories.specifictions.OrderSpecification;

import java.util.Map;

public class OrderFilter {
    private Specification<Order> specification;
    private String filterDefinition;

    public OrderFilter(Map<String,String> params){
        StringBuilder filterDefinitionBuilder = new StringBuilder();
        specification = Specification.where(null);

        String filterCode = params.get("code");
        if(filterCode != null && !filterCode.isEmpty()){
            specification = specification.and(OrderSpecification.codeLike(filterCode));
            filterDefinitionBuilder.append("&code=").append(filterCode);
        }

        String filterCustomerName = params.get("name");
        if(filterCustomerName != null && !filterCustomerName.isEmpty()){
            specification = specification.and(OrderSpecification.customerNameEquals(filterCustomerName));
            filterDefinitionBuilder.append("&name=").append(filterCustomerName);
        }

        if (params.containsKey("min_price")&&!params.get("min_price").isEmpty()){
            Integer minPrice = Integer.parseInt(params.get("min_price"));
            specification=specification.and(OrderSpecification.priceGreaterOrEqualsThan(minPrice));
            filterDefinitionBuilder.append("&min_price=").append(minPrice);
        }

        if (params.containsKey("max_price")&&!params.get("max_price").isEmpty()){
            Integer maxPrice = Integer.parseInt(params.get("max_price"));
            specification=specification.and(OrderSpecification.priceLesserOrEqualsThan(maxPrice));
            filterDefinitionBuilder.append("&max_price=").append(maxPrice);
        }
        filterDefinition = filterDefinitionBuilder.toString();
    }

    public Specification<Order> getSpecification() {
        return specification;
    }

    public void setSpecification(Specification<Order> specification) {
        this.specification = specification;
    }

    public String getFilterDefinition() {
        return filterDefinition;
    }

    public void setFilterDefinition(String filterDefinition) {
        this.filterDefinition = filterDefinition;
    }
}
