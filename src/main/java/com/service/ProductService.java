package com.service;

import com.dto.ProductDto;
import com.extensions.PagingExtension;
import com.migration.ProductBrandMigration;
import com.migration.ProductTypeMigration;
import com.repository.ProductRepository;
import com.repository.impl.IProductRepository;
import com.service.impl.IProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProductService implements IProductService {
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public ProductDto getProductById(int id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<ProductDto> getTopRelatedProduct(String type, String brand) {
        int typeId = ProductTypeMigration.getIdProductTypeByName(type);
        int brandId = ProductBrandMigration.getIdProductBrandByName(brand);
        return productRepository.getTopRelatedProduct(typeId, brandId);
    }
}
