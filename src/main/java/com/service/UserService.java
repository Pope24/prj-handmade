package com.service;

import com.entity.User;
import com.repository.UserRepository;
import com.repository.impl.IUserRepository;
import com.service.impl.IUserService;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();
    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }
}
