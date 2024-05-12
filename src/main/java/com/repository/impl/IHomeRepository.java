package com.repository.impl;

import com.dto.ProductDto;

import java.util.List;

public interface IHomeRepository {
    List<ProductDto> getTopLatestProduct();
    List<ProductDto> getTopBestSellerProduct();
    List<ProductDto> getTopAmountReviewProduct();
}
