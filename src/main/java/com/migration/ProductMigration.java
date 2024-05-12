package com.migration;

import com.DBConfig.DBConnection;
import com.dto.ProductDto;
import com.extensions.DateTimeExtension;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductMigration {
    public static ProductDto convertProductDto(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        BigDecimal price = resultSet.getBigDecimal("price");
        int amount = resultSet.getInt("amount");
        String desc = resultSet.getString("description");
        String type = ProductTypeMigration.getNameProductTypeById(resultSet.getInt("p_type"));
        String brand = ProductBrandMigration.getNameProductBrandById(resultSet.getInt("p_brand"));
        String nameSupply = resultSet.getString("full_name");
        String image = resultSet.getString("link_image");
        LocalDate createOn = DateTimeExtension.convertStringDateTimeToLocalDate(resultSet.getString("create_on"));
        return new ProductDto(id, name, price, amount, desc, type, brand, nameSupply, image, createOn);
    }
    public static List<ProductDto> getListProductByQuery(String query) {
        List<ProductDto> productDTOList = new ArrayList<>();
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
    public static List<ProductDto> getListProductBy2Param(String query, int param1, int param2) {
        List<ProductDto> productDTOList = new ArrayList<>();
        try(Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, param1);
            statement.setInt(2, param2);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                productDTOList.add(ProductMigration.convertProductDto(resultSet));
            }
            return productDTOList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<String> convertListImageProduct(ResultSet resultSet) throws SQLException {
        List<String> images = new ArrayList<>();
        while (resultSet.next()) {
            images.add(resultSet.getString("link_image"));
        }
        return images;
    }
}
