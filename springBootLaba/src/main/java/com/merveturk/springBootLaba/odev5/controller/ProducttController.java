package com.merveturk.springBootLaba.odev5.controller;


import com.merveturk.springBootLaba.odev5.entity.Productt;
import com.merveturk.springBootLaba.odev5.service.ProducttService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/productt")
public class ProducttController {

    private final ProducttService productService;
    private RedirectAttributes redirectAttributes;

    public ProducttController(ProducttService productService) {

        this.productService = productService;
    }

    @PostMapping("/saveProductt")
    public ResponseEntity<String> saveProductt(@RequestParam String name , @RequestParam String category){
        productService.save(name,category );
        return ResponseEntity.status(HttpStatus.CREATED).body( " Isleminiz Basarili ");
    }



}
