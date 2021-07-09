package com.works.repostories.speciications;

import com.works.models.entities.models.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProductSpecifitaions {

    public static Specification<Product> getEmployeesByNameSpec(String name) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(Product.class.getName()), name);
        };
    }

}
