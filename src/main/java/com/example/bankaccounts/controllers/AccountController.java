package com.example.bankaccounts.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.AccountModel;
import com.example.demo.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService AccountService;

    @GetMapping()
    public ArrayList<AccountModel> getAccounts(){
        return AccountService.getAccounts();
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody AccountModel Account) {
        try
        {
            this.AccountService.update(Account);
        }
        catch(Exception e){
            return ResponseHandler.generateResponse("Cannot update", HttpStatus.BAD_REQUEST, Account);
        }
        return ResponseHandler.generateResponse("updated!", HttpStatus.OK, todo);
    }
    @PostMapping()
    public AccountModel saveAccount(@RequestBody AccountModel Account){
        return this.AccountService.saveAccount(Account);
    }




    @DeleteMapping( path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.AccountService.deleteAccount(id);
        if (ok){
            return "Se eliminó el Account con id " + id;
        }else{
            return "No pudo eliminar el Account con id" + id;
        }
    }

}