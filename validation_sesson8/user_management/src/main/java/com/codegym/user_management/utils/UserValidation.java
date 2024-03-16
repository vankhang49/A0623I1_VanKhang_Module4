package com.codegym.user_management.utils;

import com.codegym.user_management.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidation implements Validator {
    @Override
    public Errors validateObject(Object target) {
        return Validator.super.validateObject(target);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(!user.getFirstname().matches("^[a-zA-Z]{5,45}$")) {
            errors.rejectValue("firstName", "", "The firstname cannot be less than 5 and cannot be larger than 45 characters");
        }
        if(!user.getFirstname().matches("^[a-zA-Z]{5,45}$")) {
            errors.rejectValue("lastName", "", "The lastname cannot be less than 5 and cannot be larger than 45 characters");
        }
        if(!user.getPhoneNumber().matches("^\\d{10}$")){
            errors.rejectValue("phoneNumber","", "Please enter a 10-digit number!");
        }
        if(!user.getEmail().matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$")){
            errors.rejectValue("email","", "Please enter the correct email format!, ex: abc123@gmail.com");
        }
    }
}
