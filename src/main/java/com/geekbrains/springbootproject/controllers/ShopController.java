package com.geekbrains.springbootproject.controllers;

import com.geekbrains.springbootproject.entities.Product;
import com.geekbrains.springbootproject.repositories.specifications.ProductSpecs;
import com.geekbrains.springbootproject.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/shop")
public class ShopController {
    private static final int INITIAL_PAGE = 0;
    private static final int PAGE_SIZE = 5;

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String shopPage(Model model,
                           @RequestParam(value = "page") Optional<Integer> page,
                           @RequestParam(value = "word", required = false) Optional<String> word,
                           @RequestParam(value = "min", required = false) Optional<Double> min,
                           @RequestParam(value = "max", required = false) Optional<Double> max
    ) {
        final int currentPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Specification<Product> spec = Specification.where(null);
        StringBuilder filters = new StringBuilder();
        if (word.isPresent() && !word.get().isBlank()) {
            spec = spec.and(ProductSpecs.titleContains(word.get()));
            filters.append("&word=" + word.get());
        }
        if (min.isPresent()) {
            spec = spec.and(ProductSpecs.priceGreaterThanOrEq(min.get()));
            filters.append("&min=" + min);
        };
        if (max.isPresent()) {
            spec = spec.and(ProductSpecs.priceLesserThanOrEq(max.get()));
            filters.append("&max=" + max);
        }

        Page<Product> products = productsService.getProductsWithPagingAndFiltering(currentPage, PAGE_SIZE, spec);

        model.addAttribute("products", products.getContent());
        model.addAttribute("page", currentPage);
        model.addAttribute("totalPage", products.getTotalPages());

        model.addAttribute("filters", filters.toString());

        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("word", word);
        return "shop-page";
    }

    @GetMapping("/product_info/{id}")
    public String productPage(Model model, @PathVariable(value = "id") Long id) {
        Product product = productsService.findById(id);
        model.addAttribute("product", product);
        return "product-page";
    }
}
