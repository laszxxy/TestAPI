package com.example.practice.service;

import com.example.practice.model.AccountModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<AccountModel> getAllAccounts();
    AccountModel createAccount(AccountModel accountModel);
    AccountModel updateAccount(AccountModel accountModel, long accountId);
    String removeAccount(Long id);
    AccountModel findAccountById(long accountId);
    List<AccountModel> searchByFirstName(String firstName);
    List<AccountModel> searchByMiddleName(String middleName);
    List<AccountModel> searchByLastName(String lastName);

    List<AccountModel> searchAccount(String firstName, String middleName, String lastName);
}
