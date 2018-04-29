package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.AccountDBRepository;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountService implements IAccountService {

	@Inject
	private AccountDBRepository repo;

	@Inject
	private JSONUtil util;

	@Override
	public String getallaccounts() {

		return repo.getallaccounts();

	}

	@Override
	public String getAnAccount(Long id) {

		return repo.getAnAccount(id);
	}

	@Override
	public String createAnAccount(String account) {

		return repo.createAnAccount(account);

	}

	@Override
	public String updateAnAccount(String account) {

		Account accountA = util.getObjectForJSON(account, Account.class);

		return repo.updateAnAccount(accountA);

	}

	@Override
	public String deleteAnAccount(Long id) {

		return repo.deleteAnAccount(id);

	}

}
