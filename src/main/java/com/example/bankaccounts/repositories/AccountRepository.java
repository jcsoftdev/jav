

package com.example.bankaccounts.repositories;

import java.util.ArrayList;

import com.example.bankaccounts.models.AccountModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountModel, Long> {
    public abstract ArrayList<AccountModel> findByPrioridad(Integer prioridad);

}