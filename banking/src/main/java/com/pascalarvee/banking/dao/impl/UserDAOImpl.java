/**
 * 
 */
package com.pascalarvee.banking.dao.impl;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pascalarvee.banking.dao.UserDAO;
import com.pascalarvee.banking.domain.Address;
import com.pascalarvee.banking.domain.Authorities;
import com.pascalarvee.banking.domain.BankAccount;
import com.pascalarvee.banking.domain.CheckingAccount;
//import com.pascalarvee.banking.domain.Transaction;
import com.pascalarvee.banking.domain.User;
import com.pascalarvee.banking.domain.Users;

/**
 * @author PASCAL
 *
 */

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.pascalarvee.banking.dao.UserDAO#getUserByCredentials(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUserByCredentials(String username, String password) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where username=? and password=?");
		
		query.setString(0, username);
		query.setString(1, password);
		
		/*List<User> users = getAllUsers();
		
		User user = new User();
		for(User u : users){
			if(u.getUsername().equals(username) && u.getPassword().equals(password)){
				user = u;
				break;
			}
			if(user == null){
				System.out.println("Please verify your credentials!");
			}
		} */
		
		User user = (User)query.uniqueResult();
		
		return user;
	}

	/* (non-Javadoc)
	 * @see com.pascalarvee.banking.dao.UserDAO#getUserByID(java.lang.String)
	 */
	@Override
	public User getUserByID(String userId) {
		
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class, userId);
		session.flush();
		
		if(user == null){
			List<User> users = getAllUsers();
		
			for(User u : users){
				if(u.getUserId().equals(userId)){
					user = u;
					break;
				}
			}
		}
		
		return user;
	}

	/* (non-Javadoc)
	 * @see com.pascalarvee.banking.dao.UserDAO#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		
		session.flush();
		
		if(users.size() == 0){
			users = new ArrayList<>();
			/**User 1**/
			/*User user1 = new User();
			user1.setUserId("1");
			user1.setFirstName("Pascal");
			user1.setMiddleName("Bouadi");
			user1.setLastName("Arvee");
			
			Address add1 = new Address();
			add1.setAddressId("1");
			add1.setAddressLine1("756 Rue Center Court");
			add1.setAddressLine2("Apt. B");
			add1.setCity("Cincinnati");
			add1.setCountry("United States");
			add1.setState("Ohio");
			add1.setUser(user1);
			add1.setZipCode("45245");
			
			user1.setAddress(add1);
			user1.setEmail("pbaconqueror7@yahoo.com");
			user1.setDateOfBirth(new LocalDate(1987, 1, 21));
			user1.setPhoneNumber("513-767-5570");
			
			user1.setUsername("parvee");
			user1.setPassword("1234");
			
			BankAccount ba1 = new CheckingAccount();
			ba1.setAccountId("1");
			ba1.setAccountNumber("1");
			ba1.setRoutingNumber("1");
			//ba1.setAccountType("Checking");
			ba1.setBalance(new BigDecimal("10000"));
			ba1.setDateOpened(new LocalDate(2008, 10, 21));
			ba1.setUser(user1);
			
			List<BankAccount> banks1 = new ArrayList<>();
			banks1.add(ba1);*/
			
			//user1.setBankAccounts(banks1);
			
			
			/**User 2**/
			User user2 = new User();
			user2.setUserId("2");
			user2.setFirstName("James");
			user2.setMiddleName("David");
			user2.setLastName("Milner");
			
			Address add2 = new Address();
			add2.setAddressId("2");
			add2.setAddressLine1("88 Clough Pike");
			add2.setAddressLine2("Apt. 1");
			add2.setCity("Cincinnati");
			add2.setCountry("United States");
			add2.setState("Ohio");
			add2.setUser(user2);
			add2.setZipCode("45245");
			
			user2.setAddress(add2);
			user2.setEmail("james.milner@gmail.com");
			//user2.setDateOfBirth(new Date(1984, 5, 12));
			user2.setPhoneNumber("513-556-5570");
			
			user2.setUsername("jmilner");
			user2.setPassword("1234");
			
			BankAccount ba2 = new CheckingAccount();
			ba2.setAccountId("2");
			ba2.setAccountNumber("2");
			ba2.setRoutingNumber("2");
			//ba1.setAccountType("Checking");
			ba2.setBalance(new BigDecimal("10000"));
			//ba2.setDateOpened(new LocalDate(2008, 10, 21));
			ba2.setUser(user2);
			
			Set<BankAccount> banks2 = new HashSet<>();
			banks2.add(ba2);
			
			//user2.setBankAccounts(banks2);
			
			//List<User> users = new ArrayList<>();
			//users.add(user1);
			users.add(user2);
		}
		
		return users;
	}

	/* (non-Javadoc)
	 * @see com.pascalarvee.banking.dao.UserDAO#addUser(com.pascalarvee.banking.domain.User)
	 */
	@Override
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		
		BankAccount bankAccount = new CheckingAccount();
		bankAccount.setAccountNumber(createAccountNumber());
		bankAccount.setRoutingNumber(createRoutingNumber());
		bankAccount.setDateOpened(LocalDateTime.parse((LocalDateTime.now()).toString().substring(0,19), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
		String accountLastDigits = bankAccount.getAccountNumber().substring(8);
		bankAccount.setAccountDescription("Banksys " + bankAccount.getAccountType() + " - " + accountLastDigits);
		session.saveOrUpdate(bankAccount);
		
		Set<BankAccount> bankAccounts = new HashSet<>();
		bankAccounts.add(bankAccount);
		user.setBankAccounts(new ArrayList<>(bankAccounts));
		user.getAddress().setUser(user);
		
		session.saveOrUpdate(user);
		session.saveOrUpdate(user.getAddress());
		
		Users new_user = new Users();
		new_user.setUsername(user.getUsername());
		new_user.setPassword(user.getPassword());
		new_user.setEnabled(true);
		new_user.setUserId(user.getUserId());
		
		Authorities authority = new Authorities();
		authority.setUsername(user.getUsername());
		authority.setAuthority("ROLE_USER");
		
		session.saveOrUpdate(new_user);
		session.saveOrUpdate(authority);
		
		bankAccount.setUser(user);
		session.saveOrUpdate(bankAccount);
		session.saveOrUpdate(user);
		
		session.flush();

	}

	/* (non-Javadoc)
	 * @see com.pascalarvee.banking.dao.UserDAO#desactivateUser(com.pascalarvee.banking.domain.User)
	 */
	@Override
	public void desactivateUser(String userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class, userId);
		user.setEnabled(false);
		
		/*Set<BankAccount>bankAccounts = user.getBankAccounts();
		Set<Transaction>transactions = user.getTransactions();
		Set<User>recipients = user.getRecipients();
		Set<BankAccount> receivingAccounts = user.getReceivingAccounts();
		
		for(Transaction transaction : transactions){
			session.delete(transaction);
		}
		for(BankAccount bankAccount : bankAccounts){
			session.delete(bankAccount);
		}
		for(BankAccount bankAccount : receivingAccounts){
			session.delete(bankAccount);
		}
		for(User user1 : recipients){
			session.delete(user1);
		}*/
		
		//user.setBankAccounts(null);
		
		//session.delete(user);
		session.flush();

	}

	@Override
	public User getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where username=?");
		
		query.setString(0, username);
				
		return (User)query.uniqueResult();
	}
	
	public static String createAccountNumber() {

		String firstDigits = "765";
		SecureRandom generatedId = new SecureRandom();
		String secondDigits = "" + generatedId.nextInt(999);
		String thirdDigits = "" + generatedId.nextInt(999);
		
		if(Integer.parseInt(secondDigits) <= 9){
			secondDigits = "00" + secondDigits;
		}else if(Integer.parseInt(secondDigits) > 9 && Integer.parseInt(secondDigits) <= 99){
			secondDigits = "0" + secondDigits;
		}
		
		if(Integer.parseInt(thirdDigits) <= 9){
			thirdDigits = "00" + thirdDigits;
		}else if(Integer.parseInt(thirdDigits) > 9 && Integer.parseInt(thirdDigits) <= 99){
			thirdDigits = "0" + thirdDigits;
		}

		String accoutNumber = firstDigits + " " + secondDigits + " " + thirdDigits;

		return accoutNumber;
	}

	public static String createRoutingNumber() {

		String area = "044";
		SecureRandom generatedId = new SecureRandom();
		String secondDigits = "" + generatedId.nextInt(999);
		String thirdDigits = "" + generatedId.nextInt(999);
		
		if(Integer.parseInt(secondDigits) <= 9){
			secondDigits = "00" + secondDigits;
		}else if(Integer.parseInt(secondDigits) > 9 && Integer.parseInt(secondDigits) <= 99){
			secondDigits = "0" + secondDigits;
		}
		
		if(Integer.parseInt(thirdDigits) <= 9){
			secondDigits = "00" + secondDigits;
		}else if(Integer.parseInt(thirdDigits) > 9 && Integer.parseInt(thirdDigits) <= 99){
			secondDigits = "0" + secondDigits;
		}

		String routing = area + " " + secondDigits + " " + thirdDigits;

		return routing;
	}

	@Override
	public void updateUserProfile(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		session.flush();
		
	}

	@Override
	public List<User> getUsersByFirstName(String firstName) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where firstName=?");
		query.setString(0, firstName);
		
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		
		session.flush();
		
		return users;
	}

	@Override
	public List<User> getUsersByLastName(String lastName) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where lastName=?");
		query.setString(0, lastName);
		
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		
		session.flush();
		
		return users;
	}

}
