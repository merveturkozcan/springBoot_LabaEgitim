package com.merveturk.springBootLaba.ders6_SpringJPA.repository;

import com.merveturk.springBootLaba.ders6_SpringJPA.entity.OrderJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.entity.OrderProductJpa;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepositoryJpa extends CrudRepository<OrderProductJpa,Long > {
}
