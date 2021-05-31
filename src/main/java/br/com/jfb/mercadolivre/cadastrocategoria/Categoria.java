package br.com.jfb.mercadolivre.cadastrocategoria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.com.jfb.mercadolivre.cadastroproduto.Produto;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String nome;

  @ManyToOne
  private Categoria categoriaMae;
  
  @OneToMany(mappedBy = "categoria")
  private List<Produto> produtos = new ArrayList<>();

  @Deprecated
  public Categoria() {
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public Categoria getCategoriaMae() {
    return categoriaMae;
  }

  public void setCategoriaMae(Categoria categoriaMae) {
    this.categoriaMae = categoriaMae;
  }

  public Categoria(@NotBlank String nome) {
    this.nome = nome;
  }

}