package com.merveturk.springBootLaba.odev4_jdbc.service;

import com.merveturk.springBootLaba.odev4_jdbc.dto.ProductDTO;
import com.merveturk.springBootLaba.odev4_jdbc.mapper.ProductMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final JdbcTemplate jdbcTemplate;
    public ProductService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<ProductDTO> getProductByCategory(String productCategory) {
        List<ProductDTO> query = jdbcTemplate.query("SELECT * FROM PRODUCTT p WHERE p.CATEGORY = ? ", new Object[]{productCategory}, new ProductMapper());
        return query;
        //.query olarak gelen metod içinden rowmapper olanı seçtim.

    }


}
