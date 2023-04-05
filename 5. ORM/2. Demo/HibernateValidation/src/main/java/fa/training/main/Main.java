package fa.training.main;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import fa.training.entity.User;
import fa.training.entity.UserDetail;

public class Main {
	public static void main(String[] args) {
		// Create ValidatorFactory which returns validator
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		// It validates bean instances
		Validator validator = factory.getValidator();

		UserDetail userDetail = new UserDetail("Tran", "Phuong", "31/01/2000");
		User user = new User(null, "1", "abcgmail.com");

		// Validate bean
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		Set<ConstraintViolation<UserDetail>> constraintViolations2 = validator.validate(userDetail);

//		 Show errors
		System.out.println("---Validation User---");
		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<User> v1 : constraintViolations) {
				System.out.println(v1.getMessage());
			}
		} else {
			System.out.println("Valid Object");
		}
		
		System.out.println("\n---Validation UserDetail---");
		
		if (constraintViolations2.size() > 0) {
			for (ConstraintViolation<UserDetail> v2 : constraintViolations2) {
				System.out.println(v2.getMessage());
			}
		} else {
			System.out.println("Valid Object");
		}
	}
}
