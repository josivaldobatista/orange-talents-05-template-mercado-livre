package br.com.jfb.mercadolivre.cadastroproduto.caracteristicaproduto;

import java.util.Set;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.jfb.mercadolivre.cadastroproduto.ProdutoRequest;

public class CaracteristicaIguaisValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return ProdutoRequest.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    if (errors.hasErrors()) {
      return;
    }

    ProdutoRequest request = (ProdutoRequest) target;
    Set<String> nomesIguais = request.caracteristicaIguais();
    if (!nomesIguais.isEmpty()) {
      errors.rejectValue("listaCaracteristicas", null, "Já possui uma caracteristica igual informada." + nomesIguais);
    }

  }
}
