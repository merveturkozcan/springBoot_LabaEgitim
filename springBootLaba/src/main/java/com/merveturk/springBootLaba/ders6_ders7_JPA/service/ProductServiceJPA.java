package com.merveturk.springBootLaba.ders6_ders7_JPA.service;


import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.ProductSaveRequestDtoJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.ProductJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.repository.ProductRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceJPA {

    private final ProductRepositoryJPA productRepositoryJPA;

    public ProductServiceJPA(ProductRepositoryJPA productRepositoryJPA) {
        this.productRepositoryJPA = productRepositoryJPA;
    }
    public void save(ProductSaveRequestDtoJpa productSaveRequestDtoJpa) {
        ProductJpa productJPA = new ProductJpa();
        productJPA.setCategory(productSaveRequestDtoJpa.getCategory());
        productJPA.setName(productSaveRequestDtoJpa.getName());
        productRepositoryJPA.save(productJPA);
    }

    public ProductJpa findProductById (Long id){
        return productRepositoryJPA.findById(id).get();
    }

    public void delete(Long productId) {
        ProductJpa productJpa = productRepositoryJPA.findById(productId).get();
        productRepositoryJPA.delete(productJpa);
    }


}
