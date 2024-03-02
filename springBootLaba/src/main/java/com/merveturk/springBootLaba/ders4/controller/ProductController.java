package com.merveturk.springBootLaba.ders4.controller;

import com.merveturk.springBootLaba.ders4.dto.ProductDTO;
import com.merveturk.springBootLaba.ders4.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/saveProduct")
    public void saveProduct() {
        productService.save();

    }
    @GetMapping("/getProductByCategory")
    public List<ProductDTO> getProductByCategory(@RequestParam String productCategory) {
        return productService.getProductByCategory(productCategory);
    }


}
