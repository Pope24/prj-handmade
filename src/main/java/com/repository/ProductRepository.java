package com.repository;

import com.DBConfig.DBConnection;
import com.dto.ProductDto;
import com.migration.ProductMigration;
import com.querySQL.ProductQuery;
import com.repository.impl.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductRepository implements IProductRepository {
    @Override
    public ProductDto getProductById(int id) {
        ProductDto product = null;
        try(Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(ProductQuery.GET_PRODUCT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                product =  ProductMigration.convertProductDto(resultSet);
                product.setImages(getImageProductByIdProduct(id));
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductDto> getTopRelatedProduct(int type, int brand) {
        return ProductMigration.getListProductBy2Param(ProductQuery.GET_TOP_RELATED_PRODUCT, type, brand);
    }

    public List<String> getImageProductByIdProduct(int id) {
        try(Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(ProductQuery.GET_IMAGE_PRODUCT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return ProductMigration.convertListImageProduct(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
