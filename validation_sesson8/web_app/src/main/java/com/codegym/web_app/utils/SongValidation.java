package com.codegym.web_app.utils;

import com.codegym.web_app.model.SongForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongValidation implements Validator {
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
        SongForm songForm = (SongForm) target;
        if(!songForm.getName().matches("^[^\\s@;,.-=+…]{1,800}$")) {
            errors.rejectValue("name", "", "The song name cannot be empty and must not exceed 800 characters!");
        }
        if(!songForm.getArtist().matches("^[^\\s@;,.-=+…]{1,300}$")) {
            errors.rejectValue("artist", "", "The artist cannot be empty and must not exceed 300 characters!");
        }
        if(!songForm.getKindOfMusic().matches("^[^!@#\\$%\\^&\\*\\(\\)\\[\\]\\{\\};:'\"<>\\/?+=|\\\\]{1,1000}$")){
            errors.rejectValue("kindOfMusic","", "Kind of music cannot be empty and must not exceed 1000 characters! Commas allowed (',')");
        }
    }
}
