package com.example.practice.service.implementation;

import com.example.practice.model.AccountModel;
import com.example.practice.repository.AccountRepository;
import com.example.practice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<AccountModel> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @Override
    public AccountModel createAccount(AccountModel accountModel) {
        return accountRepository.addAccount(accountModel);
    }

    @Override
    public AccountModel updateAccount(AccountModel accountModel, long accountId) {
        return accountRepository.updateAccount(accountModel, accountId);
    }

    @Override
    public String removeAccount(Long id) {
        return accountRepository.deleteAccount(id);
    }

    @Override
    public AccountModel findAccountById(long accountId) {
        return accountRepository.findAccountById(accountId);
    }

    @Override
    public List<AccountModel> searchByFirstName(String firstName) {
        return accountRepository.searchByFirstName(firstName);
    }

    @Override
    public List<AccountModel> searchByMiddleName(String middleName) {
        return accountRepository.searchByMiddleName(middleName);
    }

    @Override
    public List<AccountModel> searchByLastName(String lastName) {
        return accountRepository.searchByLastName(lastName);
    }

    @Override
    public List<AccountModel> searchAccount(String firstName, String middleName, String lastName) {
        if(firstName != null && !firstName.isEmpty()){
            return accountRepository.searchByFirstName(firstName);
        } else if(middleName != null && !middleName.isEmpty()){
            return accountRepository.searchByMiddleName(middleName);
        } else if(lastName != null && !lastName.isEmpty()){
            return accountRepository.searchByLastName((lastName));
        }else{
            return null;
        }
    }
}
