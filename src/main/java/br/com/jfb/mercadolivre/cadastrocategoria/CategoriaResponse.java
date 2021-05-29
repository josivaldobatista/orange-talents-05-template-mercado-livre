package br.com.jfb.mercadolivre.cadastrocategoria;

public class CategoriaResponse {

  private Long id;
  private String name;
  private Categoria categoriaMae;

  public CategoriaResponse(Categoria entity) {
    id = entity.getId();
    name = entity.getNome();
    categoriaMae = entity.getCategoriaMae();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Categoria getCategoriaMae() {
    return categoriaMae;
  }
}
