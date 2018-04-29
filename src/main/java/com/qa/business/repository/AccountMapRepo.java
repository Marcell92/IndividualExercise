package com.qa.business.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;


@ApplicationScoped
@Alternative
public class AccountMapRepo implements IAccountRepository {
	
	private JSONUtil util = new JSONUtil();

	private Map<Long, Account> AccountMap;

	public Map<Long, Account> getAccountMap() {
		return AccountMap;
	}

	public void setMovieMap(Map<Long, Account> AccountMap) {
		this.AccountMap = AccountMap;
	}

	private Long id = 1L;

	public AccountMapRepo() {

		this.AccountMap = new HashMap<Long, Account>();

	}

	@Override
	public String getallaccounts() {
		
		return util.getJSONforObject(AccountMap.values());

	}

	@Override
	public String getAnAccount(Long id) {
		
		return util.getJSONforObject(AccountMap.get(id));


	}

	@Override
	public String createAnAccount(String account) {
		
		Account newAccount = util.getObjectForJSON(account, Account.class);

		if (getAnAccount(newAccount.getId()) != null) {

			AccountMap.put(id, newAccount);

			id++;
			return util.getJSONforObject(newAccount);
		} else {
			return "{\"message\": \"the account already exists\"}";
		}

	}

	@Override
	public String updateAnAccount(Account account) {
		
		
		if(account != null) {
			AccountMap.replace(account.getId(), account);
			
			return "{\"message\": \"the account has been updated\"}";
		}
		
		return "{\"message\": \"the account could not be updated\"}";

	}

	@Override
	public String deleteAnAccount(Long id) {
		
		Account newAccount = util.getObjectForJSON(getAnAccount(id), Account.class);

		if (newAccount != null) {

			AccountMap.remove(id);
			return "{\"message\":\"account deleted\"}";
		}
		
		return "{\"message\":\"account can't be deleted\"}";

	}

}
