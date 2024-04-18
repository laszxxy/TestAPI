package com.example.practice.repository;

import com.example.practice.model.AccountModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Repository
public class AccountRepository {
    private List<AccountModel> accountModels = new LinkedList<AccountModel>(Arrays.asList(
            new AccountModel(1l, "Mark", "Allen", "Gullon", "markallengullon@gmail.com"),
            new AccountModel(2l, "Mark", "John", "Dulay", "markjohn@gmail.com"),
            new AccountModel(3l, "Lara", "Jane", "Salcedo", "larajane@gmail.com"))
    );



    public AccountModel addAccount(AccountModel accountModel){
       AccountModel createAccount = new AccountModel();
       createAccount.setAccountId(accountModel.getAccountId());
       createAccount.setAccountFirstName(accountModel.getAccountFirstName());
       createAccount.setAccountMiddleName(accountModel.getAccountMiddleName());
       createAccount.setAccountLastName(accountModel.getAccountLastName());
       createAccount.setAccountEmail(accountModel.getAccountEmail());

       accountModels.add(createAccount);

       return createAccount;
    }


    public List<AccountModel> getAllAccounts(){
        return accountModels;
    }

    public AccountModel findAccountById(long accountId){
        for(int i = 0; i < accountModels.size(); i++){
            if(accountModels.get(i).getAccountId() == accountId ){
                return accountModels.get(i);
            }
        }

        return null;
    }

    public List<AccountModel> searchByFirstName(String firstName){
        List<AccountModel> matchingAccount = new ArrayList<>();
        for(AccountModel account : accountModels){
            if(account.getAccountFirstName().equalsIgnoreCase(firstName)){
                matchingAccount.add(account);
            }
        }
        return matchingAccount;
    }

    public List<AccountModel> searchByMiddleName(String middleName){
        List<AccountModel> matchingAccount = new ArrayList<>();
        for(AccountModel account : accountModels){
            if(account.getAccountMiddleName().equalsIgnoreCase(middleName)){
                matchingAccount.add(account);
            }
        }
        return matchingAccount;
    }

    public List<AccountModel> searchByLastName(String lastName){
        List<AccountModel> matchingAccount = new ArrayList<>();
        for(AccountModel account : accountModels){
            if(account.getAccountLastName().equalsIgnoreCase(lastName)){
                matchingAccount.add(account);
            }
        }
        return matchingAccount;
    }

    public AccountModel updateAccount(AccountModel accountModel, long id){
        int i = 0;
        for(AccountModel accountModel1: accountModels){
            if(accountModel1.getAccountId().equals(id)){
                return accountModels.set(i,accountModel);
            }
            i++;
        }
        return null;
    }

    public String deleteAccount(Long id){
        accountModels.removeIf(x -> x.getAccountId() == (id));
        return null;
    }


}
