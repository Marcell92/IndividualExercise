package com.qa.repositoryTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.repository.AccountDBRepository;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AccountDbTests {

	@InjectMocks
	private AccountDBRepository accountrepo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;
	
	@Mock
	private Account movie;
	
	@Inject
	private JSONUtil util;

	private static final String mockList = "[{\"firstName\":\"Marcell\",\"lastName\":\"Illes\",\"accountNo\":\"1234\"}]";
	private static final String mockObject = "{\"firstName\":\"Marcell\",\"lastName\":\"Illes\",\"accountNo\":\"1234\"}";
	private static final Account mockAccount = new Account ("Marcell", "Illes", "1234");
	
	@Before
	public void pre() {

		accountrepo.setManager(manager);
		util = new JSONUtil();
		accountrepo.setUtil(util);
	}

	@Test
	public void testgetallaccounts() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("Marcell", "Illes", "1234"));
		Mockito.when(query.getResultList()).thenReturn(accounts);
		assertEquals(mockList, accountrepo.getallaccounts());
	}
	
	@Test
	public void testcreateAnAccount() {
		Mockito.when(manager.find(Mockito.eq(Account.class), Mockito.anyString())).thenReturn(null); //works without mockito.when
		String expectedAnswer = accountrepo.createAnAccount(mockObject);
		String actual = "{\"message\":\"account added\"}";
		assertEquals(expectedAnswer, actual);
	}
	
	
	@Test
	public void testupdateAnAccount() {
		String expectedAnswer = accountrepo.updateAnAccount(mockAccount);
		String actual = "{\"message\": \"the account has been updated\"}";
		assertEquals(expectedAnswer, actual);
	}
	
	@Test
	public void testupdateAnAccountFail() {
		String expectedAnswer = accountrepo.updateAnAccount(null);
		String actual = "{\"message\": \"the account can't be updated\"}";
		assertEquals(expectedAnswer, actual);
	}
	
	@Test
	public void testdeleteAnAccount() {
		String expectedAnswer = accountrepo.deleteAnAccount(1L);
		String actual = "{\"message\":\"account was deleted\"}";
		assertEquals(expectedAnswer, actual);
	}
	
	@Test
	public void testgetAnAccount() {
		Mockito.when(manager.find(Mockito.eq(Account.class), Mockito.anyLong())).thenReturn(util.getObjectForJSON(mockObject, Account.class));
		String expectedAnswer = accountrepo.getAnAccount(1L);
		String actual = mockObject;
		assertEquals(expectedAnswer, actual);
	}


}
