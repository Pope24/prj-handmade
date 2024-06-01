package com.repository.impl;

import com.dto.AccountDTO;
import com.entity.User;

import java.util.List;

public interface IUserRepository {
    User getUserById(int id);
    User getUserByEmail(String email);
    User getUserByPhoneNumber(String phone);
    void updatePasswordByEmail(String password, String email);
    User saveUser(User user);
    void saveAccount(String username, String password, int idUser);
    void inActiveAccount(int id);
    void activeAccount(int id);
}
