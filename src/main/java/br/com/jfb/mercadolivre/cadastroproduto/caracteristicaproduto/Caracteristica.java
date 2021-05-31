package br.com.jfb.mercadolivre.cadastroproduto.caracteristicaproduto;

import java.util.Objects;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Caracteristica {

  @NotBlank
  private String nome;

  @NotBlank
  private String descricao;

  @Deprecated
  public Caracteristica() {
  }

  public Caracteristica(@NotBlank String nome, @NotBlank String descricao) {
    this.nome = nome;
    this.descricao = descricao;
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
    if (!(o instanceof Caracteristica)) {
      return false;
    }
    Caracteristica caracteristica = (Caracteristica) o;
    return Objects.equals(nome, caracteristica.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(nome);
  }

}
