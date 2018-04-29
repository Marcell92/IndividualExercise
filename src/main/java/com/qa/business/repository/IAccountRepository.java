package com.qa.business.repository;

import com.qa.persistence.domain.Account;

public interface IAccountRepository {
	
	String getallaccounts();

	String getAnAccount(Long id);

	String createAnAccount(String account);

	String updateAnAccount(Account account);

	String deleteAnAccount(Long id);

}
