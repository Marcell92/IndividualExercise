package com.qa.business.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;



@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements IAccountRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}
	
	@Override
	public String getallaccounts() {
		Query query = manager.createQuery("SELECT m FROM Account m");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();

		return util.getJSONforObject(accounts);
	}
	
	@Override
	public String getAnAccount(Long id) {
		
		Account anAccount = findAccount(id);

		if (anAccount != null) {

			return util.getJSONforObject(anAccount);
		}

		else {

			return "{\"message\":\"account not found\"}";
		}
	}
	
	@Override
	@Transactional(REQUIRED)
	public String createAnAccount(String account) {
		Account newAccount = util.getObjectForJSON(account, Account.class);

		manager.persist(newAccount);

		return "{\"message\":\"account added\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateAnAccount(Account account) {
		
		if (account != null) {

			manager.merge(account);

			return "{\"message\": \"the account has been updated\"}";
		}
		return "{\"message\": \"the account can't be updated\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String deleteAnAccount(Long id) {
		

		Account accountTodelete = findAccount(id);
		manager.remove(accountTodelete);
		return "{\"message\":\"account was deleted\"}";
		
	}
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
