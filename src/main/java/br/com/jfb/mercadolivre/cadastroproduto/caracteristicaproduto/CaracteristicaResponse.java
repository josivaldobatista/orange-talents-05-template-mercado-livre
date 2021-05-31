package br.com.jfb.mercadolivre.cadastroproduto.caracteristicaproduto;

import javax.validation.constraints.NotBlank;

public class CaracteristicaResponse {
  
  @NotBlank
  private String nome;

  @NotBlank
  private String descricao;

  @Deprecated
  public CaracteristicaResponse() {
  }

  public CaracteristicaResponse(Caracteristica entity) {
    nome = entity.getNome();
    descricao = entity.getDescricao();
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }
}
