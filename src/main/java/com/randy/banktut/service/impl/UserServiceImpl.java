package com.randy.banktut.service.impl;

import com.randy.banktut.dto.AccountInfo;
import com.randy.banktut.dto.BankResponse;
import com.randy.banktut.dto.UserRequest;
import com.randy.banktut.entity.User;
import com.randy.banktut.repository.UserRepository;
import com.randy.banktut.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public BankResponse createAccount(UserRequest userRequest) {

        /**
         * Creating an account - saving a new user into the db
         * check if already has an account
         */
        if (userRepository.existByEmail(userRequest.getEmail())) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
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

    User saveUser = userRepository.save(newUser);
    return BankResponse.builder()
            .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
            .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
            .accountInfo(AccountInfo.builder()
                    .accountBalance(saveUser.getAccountBalance())
                    .accountNumber(saveUser.getAccountNumber())
                    .accountName(saveUser.getFirstName() + " " + saveUser.getLastName() + " " + saveUser.getOtherName())
                    .build())
            .build();
    }
}
