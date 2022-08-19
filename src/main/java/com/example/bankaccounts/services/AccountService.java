package com.example.bankaccounts.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.bankaccounts.models.AccountModel;
import com.example.bankaccounts.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository AccountRepository;
    
    public ArrayList<AccountModel>getAccounts(){
        return (ArrayList<AccountModel>) AccountRepository.findAll();
    }

    public AccountModel saveAccount(AccountModel Account){
        return AccountRepository.save(Account);
    }

    public Optional<AccountModel>getById(Long id){
        return AccountRepository.findById(id);
    }


    public ArrayList<AccountModel> getByPrioridad(Integer prioridad) {
        return AccountRepository.findByPrioridad(prioridad);
    }

    public boolean deleteAccount(Long id) {
        try{
            AccountRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}