package com.repository;

import com.configuration.database.DBConnection;
import com.dto.AccountDTO;
import com.entity.User;
import com.enums.EGender;
import com.migration.GenderMigration;
import com.querySQL.UserQuery;
import com.repository.impl.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public User getUserById(int id) {
        try (Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(UserQuery.SELECT_USER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                String fullName = resultSet.getString("full_name");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String identityCard = resultSet.getString("identity_card");
                String address = resultSet.getString("address");
                EGender gender = GenderMigration.numberConvertGender(resultSet.getInt("gender"));
                String avatar = resultSet.getString("avatar");
                return new User(idUser, fullName, phoneNumber, email, identityCard, address, gender, avatar);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        try (Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(UserQuery.SELECT_USER_BY_EMAIL)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                String fullName = resultSet.getString("full_name");
                String phoneNumber = resultSet.getString("phone_number");
                String emailUser = resultSet.getString("email");
                String identityCard = resultSet.getString("identity_card");
                String address = resultSet.getString("address");
                EGender gender = GenderMigration.numberConvertGender(resultSet.getInt("gender"));
                String avatar = resultSet.getString("avatar");
                return new User(idUser, fullName, phoneNumber, email, identityCard, address, gender, avatar);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public User getUserByPhoneNumber(String phone) {
        try (Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(UserQuery.SELECT_USER_BY_PHONE_NUMBER)) {
            statement.setString(1, phone);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                String fullName = resultSet.getString("full_name");
                String phoneNumber = resultSet.getString("phone_number");
                String emailUser = resultSet.getString("email");
                String identityCard = resultSet.getString("identity_card");
                String address = resultSet.getString("address");
                EGender gender = GenderMigration.numberConvertGender(resultSet.getInt("gender"));
                String avatar = resultSet.getString("avatar");
                return new User(idUser, fullName, phoneNumber, emailUser, identityCard, address, gender, avatar);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void updatePasswordByEmail(String password, String email) {
        try (Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(UserQuery.UPDATE_PASSWORD_ACCOUNT_BY_EMAIL)) {
            statement.setString(1, password);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User saveUser(User user) {
        try (Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(UserQuery.SAVE_NEW_USER, Statement.RETURN_GENERATED_KEYS)) {
            statement.setNString(1, user.getFullName());
            statement.setString(2, user.getPhoneNumber());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getIdentityCard());
            statement.setString(6, user.getAddress());
            statement.setInt(7, GenderMigration.genderConvertInt(user.gender));
            if (user.getAvatar().equals("") || user.getAvatar() == null) {
                statement.setString(8, null);
            } else {
                statement.setString(8, user.getAvatar());
            }
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                    System.out.println(user.getId());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void saveAccount(String username, String password, int idUser) {
        try (Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(UserQuery.SAVE_NEW_ACCOUNT)) {
            statement.setInt(1, idUser);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setInt(4, 1);
            statement.setInt(5, 2);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void inActiveAccount(int id) {
        try (Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(UserQuery.INACTIVE_ACCOUNT)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void activeAccount(int id) {
        try (Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(UserQuery.ACTIVE_ACCOUNT)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
