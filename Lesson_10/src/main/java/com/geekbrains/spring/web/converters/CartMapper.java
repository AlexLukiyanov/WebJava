package com.geekbrains.spring.web.converters;

import com.geekbrains.spring.web.dto.CartDto;
import com.geekbrains.spring.web.entities.Cart;
import com.geekbrains.spring.web.entities.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.factory.Mappers;

public interface CartMapper {
    CartMapper MAPPER = Mappers.getMapper(CartMapper.class);

    Product toProduct(CartDto CartDto);

    @InheritInverseConfiguration
    CartDto cartDto(Cart cart);
}
