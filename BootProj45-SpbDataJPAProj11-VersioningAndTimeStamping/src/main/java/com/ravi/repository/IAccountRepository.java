package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Account;

public interface IAccountRepository extends JpaRepository<Account,Long> {

}
