package com.qa.repositoryTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.business.repository.AccountMapRepo;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepoTest {
	
	private AccountMapRepo repo = new AccountMapRepo();
	private Account Joe = new Account("Joe", "Bill", "1234");
	private Account Tom = new Account("Tom", "Bane", "1234");
	private JSONUtil util = new JSONUtil();

	String account = util.getJSONforObject(Joe);
	String account1 = util.getJSONforObject(Tom);

	@Test
	public void testCreateAndDeleteAnAccount() {

		repo.createAnAccount(account);
		assertEquals(repo.getAccountMap().size(), 1);

		repo.deleteAnAccount(1L);
		assertEquals(repo.getAccountMap().size(), 0);

		repo.deleteAnAccount(2L);
		assertEquals(repo.deleteAnAccount(2L), "{\"message\":\"movie can't be deleted\"}");

	}

	@Test
	public void testgetAnAccount() {

		repo.createAnAccount(account);
		repo.getAnAccount(1L);
		assertEquals(repo.getAnAccount(1L), account);
	}

	@Test
	public void testupdateAMovie() {

		repo.updateAnAccount(Joe);
		assertEquals(repo.updateAnAccount(Joe), "{\"message\": \"the movie has been updated\"}");
	}


}
