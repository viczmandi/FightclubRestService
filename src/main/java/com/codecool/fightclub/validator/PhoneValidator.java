package com.codecool.fightclub.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
	public void initialize(Phone paramA) {
	}

	public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
		if(phoneNo == null){
			return false;
		}
        if (phoneNo.matches("^\\+36\\d{9}")) return true;
        //return false if nothing matches the input
        else return false;
	}
}
