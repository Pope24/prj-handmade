package com.service.impl;

import com.dto.AccountDTO;
import com.entity.Account;

public interface ILoginService {
    AccountDTO getAccountByUserNameAndPassword(String username, String password);
    void updatePasswordByEmail(String password, String email);
}
