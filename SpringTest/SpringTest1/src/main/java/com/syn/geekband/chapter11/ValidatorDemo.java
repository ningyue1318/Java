package com.syn.geekband.chapter11;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.context.MessageSource;
import org.springframework.validation.*;

import java.util.Locale;

import static com.syn.geekband.chapter11.ErrorsMessageDemo.createMessageSource;

public class ValidatorDemo {
    public static void main(String[] args) {
        Validator validator = new UserValidator();

        User user =new User();
        System.out.println("user对象是否被 UserValidator 校验"+validator.supports(user.getClass()));
        Errors errors = new BeanPropertyBindingResult(user,"user");

        validator.validate(user,errors);

        MessageSource messageSource = createMessageSource();

        for(ObjectError error:errors.getAllErrors()){
            String message = messageSource.getMessage(error.getCode(),error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }

    }

    static class UserValidator implements Validator {


        @Override
        public boolean supports(Class<?> clazz) {
            return User.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            User user = (User)target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id","id.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","name.required");
            String userName = user.getName();
        }
    }
}
