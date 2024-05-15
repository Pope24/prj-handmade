package com.repository.impl;

import com.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

public interface IProductRepository {
    ProductDto getProductById(int id);
    List<ProductDto> getTopRelatedProduct(int type, int brand);
    List<ProductDto> getProductFilter(String[] brands, String[] types, BigDecimal minPrice, BigDecimal maxPrice, int page);
    List<ProductDto> getProductSearch(String search, int page);
    int countAmountProductFilter(String[] brands, String[] types, BigDecimal minPrice, BigDecimal maxPrice);
    int countAmountProductSearch(String search);
}
