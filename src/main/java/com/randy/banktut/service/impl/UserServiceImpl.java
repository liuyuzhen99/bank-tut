package com.randy.banktut.service.impl;

import com.randy.banktut.dto.BankResponse;
import com.randy.banktut.dto.UserRequest;
import com.randy.banktut.entity.User;
import com.randy.banktut.utils.AccountUtils;

import java.math.BigDecimal;

public class UserServiceImpl implements UserService{
    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        /**
         * Creating an account - saving a new user into the db
         * check if already has an account
         */
        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                .status("ACTIVE")
                .build();


    }
}
