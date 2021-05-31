package br.com.jfb.mercadolivre.cadastroproduto.caracteristicaproduto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

public class CaracteristicaRequest {

  @NotBlank
  private String nome;

  @NotBlank
  private String descricao;

  @Deprecated
  public CaracteristicaRequest() {
  }

  public CaracteristicaRequest(@NotBlank String nome, @NotBlank String descricao) {
    this.nome = nome;
    this.descricao = descricao;
  }

  public Caracteristica toModel() {
    return new Caracteristica(nome, descricao);
  }

  public String getNome() {
    return this.nome;
  }

  public String getDescricao() {
    return this.descricao;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof CaracteristicaRequest)) {
      return false;
    }
    CaracteristicaRequest caracteristiaRequest = (CaracteristicaRequest) o;
    return Objects.equals(nome, caracteristiaRequest.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(nome);
  }

}
