/**
 * 
 */
package com.pascalarvee.banking.controller;

/*import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;*/
import java.util.List;

import javax.validation.Valid;

import org.joda.time.DateTimeZone;
/*import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pascalarvee.banking.domain.Address;
import com.pascalarvee.banking.domain.Gender;
import com.pascalarvee.banking.domain.User;
import com.pascalarvee.banking.service.UserService;

/**
 * @author PASCAL
 *
 */

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	public static final DateTimeZone jodaTzUTC = DateTimeZone.forID("UTC");
	
	@RequestMapping("/register")
	public String register(Model model){
		
		User user = new User();
		Address address = new Address();
		user.setAddress(address);
		
		user.setGender(Gender.MALE.toString());
		
		model.addAttribute("user", user);
		model.addAttribute("genders", Gender.values());
		
		return "registrationPage";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPost(@Valid @ModelAttribute("user")User user, BindingResult bindingResult, 
								Model model, Errors errors, @RequestParam("dob")String dateOfBirth){
		
		System.out.println("*********************************************************************");
		System.out.println("Date of Birth: " + dateOfBirth);
		System.out.println("*********************************************************************");
		//DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		//LocalDate date = fmt.parseLocalDate(dateOfBirth);
		java.time.LocalDate date = java.time.LocalDate.parse(dateOfBirth, java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date date = null;
		try {
			date = format.parse(dateOfBirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		user.setDateOfBirth(date);
		
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.getErrorCount() + " " + bindingResult.getObjectName() + " " + bindingResult.getModel());
			System.out.println("There are some issues!");
			
			//user.setGender(Gender.MALE.toString());
			
			model.addAttribute("user", user);
			model.addAttribute("genders", Gender.values());
			
			return "registrationPage";
		}
		
		if(!(user.getPassword().equals(user.getPasswordConfirm()))){
			errors.rejectValue("password", "nomatch.password");
			//model.addAttribute("passwordError", "The passwords do not match!");
			
			//user.setGender(Gender.MALE.toString());
			
			model.addAttribute("user", user);
			model.addAttribute("genders", Gender.values());
			
			return "registrationPage";
		}
		
		List<User>users = userService.getAllUsers();
		
		for(User u : users){
			if(u.getEmail().equals(user.getEmail())){
				model.addAttribute("emailMsg", "Email already exists!");
				System.out.println("There are some issues here (email)!");
				
				user.setGender(Gender.MALE.toString());
				
				model.addAttribute("user", user);
				model.addAttribute("genders", Gender.values());
				
				return "registrationPage";
			}
			if(u.getUsername().equals(user.getUsername())){
				model.addAttribute("userMsg", "User already exists!");
				System.out.println("There are some issues here (username)!");
				
				user.setGender(Gender.MALE.toString());
				
				model.addAttribute("user", user);
				model.addAttribute("genders", Gender.values());
				
				return "registrationPage";
			}
		}
		
		user.setEnabled(true);
		userService.addUser(user);
		
		model.addAttribute("user", user);
		
		return "registrationSuccess";
	}
	
	public void getGenders(Model model){
		model.addAttribute("genders", Gender.values());
	}

}
