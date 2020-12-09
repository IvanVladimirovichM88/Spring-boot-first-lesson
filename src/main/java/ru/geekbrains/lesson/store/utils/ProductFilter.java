package ru.geekbrains.lesson.store.utils;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.lesson.store.entities.Product;
import ru.geekbrains.lesson.store.repositories.specifictions.ProductSpecification;

import java.util.Map;

public class ProductFilter {
    private Specification<Product> specification;
    private String filterDefinition;

    public ProductFilter(Map<String, String> params) {
        StringBuilder filterDefinitionBuilder = new StringBuilder();
        specification = Specification.where(null);

        String filterTitle = params.get("title");
        if (filterTitle != null && !filterTitle.isEmpty()){
            specification = specification.and(ProductSpecification.titleLike(filterTitle));
            filterDefinitionBuilder.append("&title=").append(filterTitle);
        }

        if(params.containsKey("min_price")&&!params.get("min_price").isEmpty()){
            Integer minPrice = Integer.parseInt(params.get("min_price"));
            specification = specification.and(ProductSpecification.priceGreaterOrEqualsThan(minPrice));
            filterDefinitionBuilder.append("&min_price=").append(minPrice);
        }

        if(params.containsKey("max_price")&&!params.get("max_price").isEmpty()){
            Integer maxPrice = Integer.parseInt(params.get("max_price"));
            specification = specification.and(ProductSpecification.priceLesserOrEqualsThan(maxPrice));
            filterDefinitionBuilder.append("&max_price=").append(maxPrice);
        }
        filterDefinition = filterDefinitionBuilder.toString();
    }

    public Specification<Product> getSpecification() {
        return specification;
    }

    public void setSpecification(Specification<Product> specification) {
        this.specification = specification;
    }

    public String getFilterDefinition() {
        return filterDefinition;
    }

    public void setFilterDefinition(String filterDefinition) {
        this.filterDefinition = filterDefinition;
    }
}
