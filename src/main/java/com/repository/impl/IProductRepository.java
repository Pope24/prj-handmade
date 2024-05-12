package com.repository.impl;

import com.dto.ProductDto;

import java.util.List;

public interface IProductRepository {
    ProductDto getProductById(int id);
    List<ProductDto> getTopRelatedProduct(int type, int brand);
}
