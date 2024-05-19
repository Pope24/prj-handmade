package com.repository;

import com.dto.ProductDto;
import com.migration.ProductMigration;
import com.querySQL.ProductQuery;
import com.repository.impl.IHomeRepository;

import java.util.List;

public class HomeRepository implements IHomeRepository {

    @Override
    public List<ProductDto> getTopLatestProduct() {
        return ProductMigration.getListProductByQuery(ProductQuery.GET_TOP_LATEST_PRODUCT);
    }

    @Override
    public List<ProductDto> getTopBestSellerProduct() {
        return ProductMigration.getListProductByQuery(ProductQuery.GET_TOP_BEST_SELLER_PRODUCT);
    }

    @Override
    public List<ProductDto> getTopAmountReviewProduct() {
        return ProductMigration.getListProductByQuery(ProductQuery.GET_TOP_REVIEW_PRODUCT);
    }
}
