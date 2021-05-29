package br.com.jfb.mercadolivre.cadastrocategoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import br.com.jfb.mercadolivre.shared.valiations.UniqueValueValid;

public class CategoriaRequest {

  @NotBlank
  @UniqueValueValid(domainClass = Categoria.class, fieldName = "nome", message = "Categoria deve ser único")
  private String nome;

  @Positive
  private Long categoriaMaeId;

  @Deprecated
  public CategoriaRequest() {
  }

  public String getNome() {
    return nome;
  }

  public void setCategoriaMaeId(Long categoriaMaeId) {
    this.categoriaMaeId = categoriaMaeId;
  }

  public Categoria toModel(CategoriaRepository repository) {
    Categoria categoria = new Categoria(nome);
    if (categoriaMaeId != null) {
      Categoria categoriaMae = repository.findById(categoriaMaeId).get();
      categoria.setCategoriaMae(categoriaMae);
    }
    return categoria;
  }

}
