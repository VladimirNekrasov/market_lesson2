package com.geekbrains.springbootproject.utils;

import com.geekbrains.springbootproject.entities.Product;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

@Getter
public class ProductFilter {
    private Specification<Product> spec;
    private String filterDefinition;


}
