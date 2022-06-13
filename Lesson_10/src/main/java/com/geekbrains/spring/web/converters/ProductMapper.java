package com.geekbrains.spring.web.converters;

import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.entities.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.factory.Mappers;

public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDto productDto);

    @InheritInverseConfiguration
    ProductDto productDto(Product product);
}
