package com.service.impl;

import com.dto.ProductDto;

import java.util.List;
import java.util.Map;

public interface IHomeService {
    Map<String, List<ProductDto>> getAllProductListForHomePage();
    List<ProductDto> getTopLatestProduct();
    List<ProductDto> getTopBestSellerProduct();
    List<ProductDto> getTopAmountReviewProduct();
}
