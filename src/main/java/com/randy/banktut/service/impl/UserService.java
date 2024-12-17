package com.randy.banktut.service.impl;

import com.randy.banktut.dto.AccountInfo;
import com.randy.banktut.dto.BankResponse;
import com.randy.banktut.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
}
