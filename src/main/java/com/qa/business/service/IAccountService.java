package com.qa.business.service;

import com.qa.persistence.domain.Account;

public interface IAccountService {

	String getallaccounts();

	String getAnAccount(Long id);

	String createAnAccount(String account);

	String updateAnAccount(String account);

	String deleteAnAccount(Long id);

}
