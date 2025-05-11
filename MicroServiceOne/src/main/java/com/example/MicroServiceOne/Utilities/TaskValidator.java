package com.example.MicroServiceOne.Utilities;

import com.example.MicroServiceOne.Entities.Tasks;
import com.example.MicroServiceOne.Entities.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.Annotation;

public class TaskValidator implements Validator {


    public boolean supports(Class<?> clazz){
        return Tasks.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Tasks tasks = (Tasks) obj;
       // User users =(User) obj;
        String priority = tasks.getPriority();
        if(!"high".equals(priority) && !"low".equals(priority)){
            errors.rejectValue("Priority","Priority must be high or low !");
        }



    }
}
