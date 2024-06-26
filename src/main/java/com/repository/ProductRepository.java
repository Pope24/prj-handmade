package com.repository;

import com.configuration.database.DBConnection;
import com.dto.ProductDto;
import com.migration.ProductMigration;
import com.querySQL.ProductQuery;
import com.repository.impl.IProductRepository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                product.setImages(ProductMigration.getImageProductByIdProduct(id));
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductDto> getTopRelatedProduct(int type, int brand) {
        List<ProductDto> productDTOList = new ArrayList<>();
        try(Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(ProductQuery.GET_TOP_RELATED_PRODUCT)) {
            statement.setInt(1, type);
            statement.setInt(2, brand);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                productDTOList.add(ProductMigration.convertProductDto(resultSet));
            }
            return productDTOList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductDto> getProductFilter(String[] brands, String[] types, BigDecimal minPrice, BigDecimal maxPrice, int page) {
        List<ProductDto> productDTOList = new ArrayList<>();
        String query = ProductQuery.getQueryProductFilter(brands, types, minPrice, maxPrice, page);
        try(Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                productDTOList.add(ProductMigration.convertProductDto(resultSet));
            }
            return productDTOList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductDto> getProductSearch(String search, int page) {
        List<ProductDto> productDTOList = new ArrayList<>();
        try(Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(ProductQuery.GET_PRODUCT_SEARCH)) {
            statement.setString(1, "%" + search + "%");
            statement.setInt(2, page);
            statement.setInt(3, page);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                productDTOList.add(ProductMigration.convertProductDto(resultSet));
            }
            return productDTOList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countAmountProductFilter(String[] brands, String[] types, BigDecimal minPrice, BigDecimal maxPrice) {
        String query = ProductQuery.getQueryCountProductFilter(brands, types, minPrice, maxPrice);
        try(Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("total");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public int countAmountProductSearch(String search) {
        try(Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(ProductQuery.COUNT_PRODUCT_SEARCH)) {
            statement.setString(1, "%" + search + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("total");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    @Override
    public List<ProductDto> loadAllProducts() {
        List<ProductDto> productDTOList = new ArrayList<>();
        try(Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(ProductQuery.GET_ALL_PRODUCT)) {
            statement.setString(1, "%%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ProductDto product = ProductMigration.convertProductDto(resultSet);
                product.setImages(ProductMigration.getImageProductByIdProduct(product.getId()));
                productDTOList.add(product);
            }
            return productDTOList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
