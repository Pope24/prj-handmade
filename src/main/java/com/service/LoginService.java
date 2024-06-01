package com.service;

import com.dto.AccountDTO;
import com.entity.Account;
import com.repository.LoginRepository;
import com.repository.UserRepository;
import com.repository.impl.ILoginRepository;
import com.repository.impl.IUserRepository;
import com.service.impl.ILoginService;

import java.util.List;

public class LoginService implements ILoginService {
    private ILoginRepository loginRepository = new LoginRepository();
    private IUserRepository userRepository = new UserRepository();
    @Override
    public AccountDTO getAccountByUserNameAndPassword(String username, String password) {
        List<Account> accountList = loginRepository.getAllAccount();
        for (Account account: accountList) {
            if (account.getUsername().trim().equals(username) && account.getPassword().trim().equals(password)) {
                return new AccountDTO(account.getId(), account.getUsername(),account.isActive(), account.getRole().ordinal());
            }
        }
        return null;
    }

    @Override
    public void updatePasswordByEmail(String password, String email) {
        userRepository.updatePasswordByEmail(password, email);
    }
}
