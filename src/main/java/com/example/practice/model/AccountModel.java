package com.example.practice.model;

import lombok.Data;

@Data
public class AccountModel {
    private Long accountId;
    private String accountFirstName;
    private String accountMiddleName;
    private String accountLastName;
    private String accountEmail;


    public AccountModel(Long accountId, String accountFirstName, String accountMiddleName, String accountLastName, String accountEmail){
        this.accountId = accountId;
        this.accountFirstName = accountFirstName;
        this.accountMiddleName = accountMiddleName;
        this.accountLastName = accountLastName;
        this.accountEmail = accountEmail;
    }

    public AccountModel(){
    }

}
