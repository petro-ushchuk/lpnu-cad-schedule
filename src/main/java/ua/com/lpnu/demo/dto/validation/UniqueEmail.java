package ua.com.lpnu.demo.dto.validation;

import ua.com.lpnu.demo.dto.validation.UniqueEmail.UniqueEmailValidator;
import ua.com.lpnu.demo.service.UserService;
import lombok.RequiredArgsConstructor;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {

  String message() default "{email.not.unique}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  @RequiredArgsConstructor
  class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
      return !userService.isUserExistsWithEmail(email);
    }
  }

}
