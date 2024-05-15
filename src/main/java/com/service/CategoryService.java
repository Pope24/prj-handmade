package com.service;

import com.extensions.NumberExtension;
import com.extensions.PagingExtension;
import com.migration.ProductTypeMigration;
import com.repository.ProductRepository;
import com.repository.impl.IProductRepository;
import com.service.impl.ICategoryService;
import com.validation.PagingValidation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CategoryService implements ICategoryService {
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public Map<String, Object> getInformationProductSearch(String search, String page) {
        Map<String, Object> searchingProduct = new HashMap<>();
        int pageChecked = PagingValidation.checkPageAndReturn1IfNotTrue(page);
        int totalRow = productRepository.countAmountProductSearch(search);
        searchingProduct.put("products", productRepository.getProductSearch(search, pageChecked));
        searchingProduct.put("totalPage", PagingExtension.getEndPage(totalRow));
        searchingProduct.put("currentPage", page);
        searchingProduct.put("valueSearch", search);
        return searchingProduct;
    }

    @Override
    public Map<String, Object> getProductFilter(String[] brands, String[] types, String minPrice, String maxPrice, String page, String queryURL) {
        Map<String, Object> filterProducts = new HashMap<>();
        BigDecimal minPriceDec = NumberExtension.convertStringToMoney(minPrice);
        BigDecimal maxPriceDec = NumberExtension.convertStringToMoney(maxPrice);
        int pageChecked = PagingValidation.checkPageAndReturn1IfNotTrue(page);
        int totalRow = productRepository.countAmountProductFilter(brands, types, minPriceDec, maxPriceDec);
        filterProducts.put("products", productRepository.getProductFilter(brands, types, minPriceDec, maxPriceDec, pageChecked));
        filterProducts.put("totalPage", PagingExtension.getEndPage(totalRow));
        filterProducts.put("currentPage", pageChecked);
        filterProducts.put("valueBrands", brands);
        filterProducts.put("valueTypes", types);
        filterProducts.put("minPrice", minPriceDec);
        filterProducts.put("maxPrice", maxPriceDec);
        filterProducts.put("queryURL", queryURL);
        return filterProducts;
    }
}
