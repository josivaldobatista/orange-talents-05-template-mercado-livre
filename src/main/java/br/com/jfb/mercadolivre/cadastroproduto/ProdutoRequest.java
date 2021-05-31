package br.com.jfb.mercadolivre.cadastroproduto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.jfb.mercadolivre.cadastrocategoria.Categoria;
import br.com.jfb.mercadolivre.cadastroproduto.caracteristicaproduto.Caracteristica;
import br.com.jfb.mercadolivre.cadastroproduto.caracteristicaproduto.CaracteristicaRequest;
import br.com.jfb.mercadolivre.cadastrousuario.Usuario;

public class ProdutoRequest {

	@NotBlank
	private String nome;

	@NotNull
	@Positive
	private BigDecimal valor;

	@NotNull
	@Positive
	private int quantidade;

	@NotBlank
	private String descricao;

	@NotNull
	private Long categoria_id;

	private Long usuario_id;

	@NotNull
	@Size(min = 3)
	private List<CaracteristicaRequest> listaCaracteristicas= new ArrayList<>();

	@Deprecated
	public ProdutoRequest() {
	}

	public ProdutoRequest(@NotBlank String nome, @NotNull @Positive BigDecimal valor, @NotNull @Positive int quantidade,
			@NotBlank String descricao, Long categoria_id, Long usuario_id,
			List<CaracteristicaRequest> listaCaracteristicas) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.categoria_id = categoria_id;
		this.usuario_id = usuario_id;
		this.listaCaracteristicas = listaCaracteristicas;
	}

	public Produto toModel(Categoria categoria, Usuario usuario) {
		Set<Caracteristica> setCaracteristica = listaCaracteristicas
			.stream()
			.map(CaracteristicaRequest::toModel).collect(Collectors.toSet());
			return new Produto(nome, valor, quantidade, descricao, categoria, usuario, setCaracteristica);
	}

	public Set<String> caracteristicaIguais() {
    HashSet<String> nomesIguais = new HashSet<>();
    HashSet<String> resultados = new HashSet<>();

    for (CaracteristicaRequest caracteristica : listaCaracteristicas) {
      String nome = caracteristica.getNome();

      if (!nomesIguais.add(nome)) {
        resultados.add(nome);
      }
    }
    return resultados;
  }

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getCategoria_id() {
		return categoria_id;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public List<CaracteristicaRequest> getListaCaracteristicas() {
		return listaCaracteristicas;
	}

}
