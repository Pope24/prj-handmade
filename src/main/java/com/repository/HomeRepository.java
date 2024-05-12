package com.repository;

import com.DBConfig.DBConnection;
import com.dto.ProductDto;
import com.extensions.DateTimeExtension;
import com.migration.ProductBrandMigration;
import com.migration.ProductMigration;
import com.migration.ProductTypeMigration;
import com.querySQL.ProductQuery;
import com.repository.impl.IHomeRepository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
