package com.merveturk.springBootLaba.ders6_SpringJPA.service;


import com.merveturk.springBootLaba.ders6_SpringJPA.dto.ProductSaveRequestDtoJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.entity.ProductJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.repository.ProductRepositoryJPA;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceJPA {

    private final ProductRepositoryJPA productRepositoryJPA;

    public ProductServiceJPA(ProductRepositoryJPA productRepositoryJPA) {
        this.productRepositoryJPA = productRepositoryJPA;
    }

    public void save(ProductSaveRequestDtoJpa productSaveRequestDtoJpa) {

        ProductJpa productJPA = new ProductJpa();
        productJPA.setCategory(productSaveRequestDtoJpa.getCategory());
        productJPA.setProductName(productSaveRequestDtoJpa.getName());
        productRepositoryJPA.save(productJPA);

    }


}
