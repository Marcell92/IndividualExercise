package com.qa.business.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepo implements IAccountRepository {
	
	private JSONUtil util = new JSONUtil();

	private Map<Long, Account> AccountMap;

	public Map<Long, Account> getAccountMap() {
		return AccountMap;
	}

	public void setMovieMap(Map<Long, Account> AccountMap) {
		AccountMap = AccountMap;
	}

	private Long id = 1L;

	public AccountMapRepo() {

		this.AccountMap = new HashMap<Long, Account>();

	}

	@Override
	public String getallaccounts() {

	}

	@Override
	public String getAnAccount(Long id) {

	}

	@Override
	public String createAnAccount(String account) {

	}

	@Override
	public String updateAnAccount(Account account) {

	}

	@Override
	public String deleteAnAccount(Long id) {

	}

}
