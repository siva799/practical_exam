package com.tavant.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.account.models.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
