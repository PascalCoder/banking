/**
 * 
 */
package com.pascalarvee.banking.domain;

import java.math.BigDecimal;
//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author PASCAL
 *
 */

public class Tester {

	public static void main(String[] args) {
		BankAccount ba1 = new CheckingAccount();
		BankAccount ba2 = new SavingsAccount();
		User user = new User();
		ba1.setUser(user);
		ba2.setUser(user);
		user.setFirstName("Pascal");
		user.setLastName("Arvee");
		LocalDate date = new LocalDate(1987, 1, 21);
		//user.setDateOfBirth(Date.valueOf((date).toString()));
		Set<BankAccount>accounts = new HashSet<>();
		accounts.add(ba1);
		accounts.add(ba2);
		//user.setBankAccounts(accounts);
		
		//System.out.println(accounts.get(1).getAccountType());
		for (BankAccount ba : accounts){
			System.out.println(ba.getUser().getLastName());
		}
		
		System.out.println(ba1.getUser().getFirstName());
		
		/*SecureRandom generatedId = new SecureRandom();
		System.out.println(generatedId.nextInt(99));*/
		System.out.println(ba1.getAccountNumber());
		System.out.println(ba1.getRoutingNumber());
		
		/*DateTime now = new DateTime();
		LocalDate today = new LocalDate();
		System.out.println(now);
		System.out.println(today);*/
		
		String stringDate1 = "01/21/1987";
		String stringDate = "1985-06-19";
		String reformattedDate = stringDate.replace('/', '-');
		//LocalDate date0 = new LocalDate(stringDate);
		//DateTimeFormatter dateFormatter = new DateTimeFormatter(null, null);
		//LocalDate date0 = dateFormatter.parseLocalDate(stringDate);
		//LocalDate date0 = new LocalDate(reformattedDate);
	    //System.out.println(date0);
	    
	    //DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy");
	    DateTimeFormatter fmt1 = DateTimeFormat.forPattern("yyyy-MM-dd");
	    //LocalDate date1 = fmt.parseLocalDate(stringDate);
	    LocalDate date2 = fmt1.parseLocalDate(stringDate);
	    //System.out.println(date1);
	    System.out.println(date2);
	    
	    java.sql.Date sqlDate = java.sql.Date.valueOf(date2.toString());
	    System.out.println(sqlDate);
	    LocalDate date3 = new LocalDate(sqlDate);
	    System.out.println(date3);
	    
	    java.time.LocalDate date4 = java.time.LocalDate.parse("1987-01-21");
	    System.out.println(date4);
	    
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date date5 = null;
	    try {
	    	date5 = format.parse("1987-01-21");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("java.util.Date: " + date5);
	    
	    LocalDateTime date6 = new LocalDateTime();
	    System.out.println("Joda date: " + date6.toString());
	    
	    java.time.LocalDateTime date7 = java.time.LocalDateTime.now();
	    System.out.println(date7);
	    
	    //String date8 = date7.toString().replace('T', ' ');
	    
	    java.time.LocalDateTime date9 = java.time.LocalDateTime.parse((java.time.LocalDateTime.now()).toString().substring(0,19), java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
	    System.out.println("Date9: " + date9.isBefore(date7));
	    
	    /*BigDecimal bd = new BigDecimal(20);
	    System.out.println(bd.add(new BigDecimal(100)));*/
	}

}
