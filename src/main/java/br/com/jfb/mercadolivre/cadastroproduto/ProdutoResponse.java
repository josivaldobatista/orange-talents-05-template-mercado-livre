package br.com.jfb.mercadolivre.cadastroproduto;

import java.math.BigDecimal;
import java.util.List;

import br.com.jfb.mercadolivre.cadastrocategoria.CategoriaResponse;
import br.com.jfb.mercadolivre.cadastroproduto.caracteristicaproduto.CaracteristicaResponse;
import br.com.jfb.mercadolivre.cadastrousuario.UsuarioResponse;

public class ProdutoResponse {

  private Long id;
  private String nome;
  private BigDecimal valor;
  private Integer quantidade;
  private String descricao;
  private CategoriaResponse categoria;
  private UsuarioResponse usuario;
  private List<CaracteristicaResponse> caracteristicas;

  public ProdutoResponse(Produto entity) {
    id = entity.getId();
    nome = entity.getNome();
    valor = entity.getValor();
    quantidade = entity.getQuantidade();
    descricao = entity.getDescricao();
    categoria = new CategoriaResponse(entity.getCategoria());
    usuario = new UsuarioResponse(entity.getUsuario());
    caracteristicas = entity.mapperParaList(entity.getCaracteristicas(), CaracteristicaResponse::new);
  }

  public Long getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public BigDecimal getValor() {
    return this.valor;
  }

  public Integer getQuantidade() {
    return this.quantidade;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public CategoriaResponse getCategoria() {
    return this.categoria;
  }

  public UsuarioResponse getUsuario() {
    return usuario;
  }

  public List<CaracteristicaResponse> getCaracteristicas() {
    return caracteristicas;
  }

}
