package com.service.impl;

import com.dto.ProductDto;

import java.util.List;

public interface IProductService {
    ProductDto getProductById(int id);
    List<ProductDto> getTopRelatedProduct(String type, String brand);
}
