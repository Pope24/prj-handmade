package com.service;

import com.dto.ProductDto;
import com.repository.HomeRepository;
import com.repository.impl.IHomeRepository;
import com.service.impl.IHomeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeService implements IHomeService {
    private IHomeRepository homeRepository = new HomeRepository();

    @Override
    public Map<String, List<ProductDto>> getAllProductListForHomePage() {
        Map<String, List<ProductDto>> result = new HashMap<>();
        result.put("latestProduct", getTopLatestProduct());
        result.put("bestSellerProduct", getTopBestSellerProduct());
        result.put("topReviewProduct", getTopAmountReviewProduct());
        return result;
    }

    @Override
    public List<ProductDto> getTopLatestProduct() {
        return homeRepository.getTopLatestProduct();
    }

    @Override
    public List<ProductDto> getTopBestSellerProduct() {
        return homeRepository.getTopBestSellerProduct();
    }

    @Override
    public List<ProductDto> getTopAmountReviewProduct() {
        return homeRepository.getTopAmountReviewProduct();
    }

}
