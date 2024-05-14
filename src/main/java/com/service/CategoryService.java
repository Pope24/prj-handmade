package com.service;

import com.extensions.PagingExtension;
import com.repository.ProductRepository;
import com.repository.impl.IProductRepository;
import com.service.impl.ICategoryService;

import java.util.HashMap;
import java.util.Map;

public class CategoryService implements ICategoryService {
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public Map<String, Object> getInformationProductSearch(String search, int page) {
        Map<String, Object> searchingProduct = new HashMap<>();
        int totalRow = productRepository.countAmountProductSearch(search);
        searchingProduct.put("products", productRepository.getProductSearch(search, page));
        searchingProduct.put("totalPage", PagingExtension.getEndPage(totalRow));
        searchingProduct.put("currentPage", page);
        searchingProduct.put("valueSearch", search);
        return searchingProduct;
    }
}
