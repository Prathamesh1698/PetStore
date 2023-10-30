package validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = MobileValidator.class)

@Target(ElementType.FIELD)

@Retention(RetentionPolicy.RUNTIME)

public @interface Mobile {

    String message() default "Invalid mobile number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
