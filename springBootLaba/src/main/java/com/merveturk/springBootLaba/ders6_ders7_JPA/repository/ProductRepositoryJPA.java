package com.merveturk.springBootLaba.ders6_ders7_JPA.repository;

import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.ProductJpa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepositoryJPA extends CrudRepository < ProductJpa, Long >  {

    List<ProductJpa> findAllByCategory(String category);



}
