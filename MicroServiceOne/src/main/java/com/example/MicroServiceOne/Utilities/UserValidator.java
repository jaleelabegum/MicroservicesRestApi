package com.example.MicroServiceOne.Utilities;

import com.example.MicroServiceOne.Entities.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User users =(User) obj;
        if (users.getName() == null || users.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty", "Name is required");
        }

        if (users.getAge() < 18) {
            errors.rejectValue("age", "age.tooYoung", "Age must be at least 18");
        }

        if (users.getEmail() == null || !users.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) {
            errors.rejectValue("email", "email.invalid", "Email format is invalid");
        }


    }
}
