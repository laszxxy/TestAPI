package com.example.practice.controller;

import com.example.practice.model.AccountModel;
import com.example.practice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
//@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(path = "/getAll")
    public List<AccountModel> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping(path = "/id")
    public AccountModel findAccountById(@RequestParam(value = "accountId", required = true) long accountId) {
        return accountService.findAccountById(accountId);
    }

    @GetMapping(path = "/search")
    public List<AccountModel> searchAccounts(@RequestParam(value = "firstName", required = false) String firstName,
                                             @RequestParam(value = "middleName", required = false) String middleName,
                                             @RequestParam(value = "lastName", required = false) String lastName) {
        return accountService.searchAccount(firstName, middleName, lastName);
    }

    @PostMapping(path = "/create")
    public void addAccount(@RequestBody AccountModel accountModel) {
        accountService.createAccount(accountModel);
    }

    @PutMapping(path = "/update/{accountId}")
    public void updateAccount(@RequestBody AccountModel accountModel, @PathVariable long accountId) {
        accountService.updateAccount(accountModel, accountId);
    }

    @DeleteMapping(path = "/delete")
    public void deleteAccount(@RequestParam(value = "accountId") Long accountId) {
        accountService.removeAccount(accountId);
    }

    @GetMapping("/index")
    public ModelAndView viewIndex() {
        ModelAndView modelAndView = new ModelAndView("view/index");
        modelAndView.addObject("listAccounts", accountService.getAllAccounts());
        return modelAndView;
    }

    @GetMapping("/searchAccount")
    public ModelAndView viewAccounts(@RequestParam(value = "firstName", required = false) String firstName,
                                     @RequestParam(value = "middleName", required = false) String middleName,
                                     @RequestParam(value = "lastName", required = false) String lastName) {
        ModelAndView modelAndView = new ModelAndView("view/index");
        List<AccountModel> list = accountService.searchAccount(firstName, middleName, lastName);
        modelAndView.addObject("listAccounts", list != null ? list : accountService.getAllAccounts());
        return modelAndView;
    }



 /*   @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ModelAndView viewSearch(@RequestParam(value = "firstName", required = false) String firstName,
                                   @RequestParam(value = "middleName", required = false) String middleName,
                                   @RequestParam(value = "lastName", required = false) String lastName) {

        ModelAndView modelAndView = new ModelAndView("view/newAccount");
        List<AccountModel> listAccount = accountService.searchAccount(firstName, middleName, lastName);
        modelAndView.addObject("listAccounts", listAccount);
        return modelAndView;


    }*/
}