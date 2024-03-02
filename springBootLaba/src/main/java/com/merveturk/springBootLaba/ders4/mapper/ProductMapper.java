package com.merveturk.springBootLaba.ders4.mapper;

import com.merveturk.springBootLaba.ders4.dto.ProductDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductDTO> {

    @Override
    public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        ProductDTO productDTO = new ProductDTO();

        productDTO.setID(rs.getInt("ID"));
        productDTO.setNAME(rs.getString("NAME"));
        productDTO.setCATEGORY(rs.getString("CATEGORY"));
        productDTO.setDESCRIPTION(rs.getString("DESCRIPTION"));
        productDTO.setPHOTOURL(rs.getString("PHOTOURL"));
        productDTO.setPRICE(rs.getDouble("PRICE"));

        return productDTO;
    }
}
