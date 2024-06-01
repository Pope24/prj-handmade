package com.repository;

import com.configuration.database.DBConnection;
import com.entity.Account;
import com.enums.ERole;
import com.migration.RoleMigration;
import com.repository.impl.ILoginRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginRepository implements ILoginRepository {
    private static final String SELECT_ALL_ACCOUNT = "select * from account;";
    @Override
    public List<Account> getAllAccount() {
        try(Connection con = DBConnection.getConnection(); PreparedStatement statement = con.prepareStatement(SELECT_ALL_ACCOUNT)) {
            List<Account> accounts = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                boolean isActive = resultSet.getInt("is_actived") == 1 ? true:false;
                ERole idRole = RoleMigration.numberConvertGender(resultSet.getInt("acc_role"));
                accounts.add(new Account(idUser, username, password, isActive, idRole));
            }
            con.close();
            return accounts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
