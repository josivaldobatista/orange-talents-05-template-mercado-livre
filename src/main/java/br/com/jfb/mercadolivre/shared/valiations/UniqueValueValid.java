package br.com.jfb.mercadolivre.shared.valiations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { UniqueValueValidator.class })
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValueValid {
  String message() default "{valor.unico.generico}";

  Class<?>[] groups() default {}; // <- Aplica a validação a um grupo específico (ex. ADMIN, USUARIO)

  Class<? extends Payload>[] payload() default {}; // Mandar informação a mais no payload (pra dentro da validação)

  String fieldName();
  Class<?> domainClass();

}