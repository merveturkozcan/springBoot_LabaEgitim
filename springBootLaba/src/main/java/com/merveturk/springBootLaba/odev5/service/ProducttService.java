package com.merveturk.springBootLaba.odev5.service;

import com.merveturk.springBootLaba.odev5.entity.Productt;
import com.merveturk.springBootLaba.odev5.repository.ProducttRepository;
import org.springframework.stereotype.Service;

@Service
public class ProducttService {

    private final ProducttRepository productRepository;

    public ProducttService(ProducttRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save (String name , String category){
         productRepository.save(name,category );

    }
}
