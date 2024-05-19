package com.service;

import com.configuration.opencv.AlgCompareImage;
import com.dto.ProductDto;
import com.extensions.NumberExtension;
import com.extensions.PagingExtension;
import com.repository.ProductRepository;
import com.repository.impl.IProductRepository;
import com.service.impl.ICategoryService;
import com.validation.PagingValidation;

import javax.servlet.http.Part;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public Map<String, ?> getProductSearchByImage(String image) throws IOException {
        Map<String, Object> imageSearchProducts = new HashMap<>();
        List<ProductDto> resultProductsSearch = new ArrayList<>();
        List<ProductDto> products= productRepository.loadAllProducts();
        for (ProductDto product: products) {
            for (String img: product.getImages()) {
                if (AlgCompareImage.compareTwoImage(image, img)) {
                    resultProductsSearch.add(product);
                    break;
                }
            }
        }
        imageSearchProducts.put("products", resultProductsSearch);
        imageSearchProducts.put("totalPage", 3);
        imageSearchProducts.put("currentPage", 1);
        imageSearchProducts.put("valueSearch", "");
        return imageSearchProducts;
    }
}
