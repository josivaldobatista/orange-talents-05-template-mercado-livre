package br.com.jfb.mercadolivre.cadastroproduto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.jfb.mercadolivre.cadastrocategoria.Categoria;
import br.com.jfb.mercadolivre.cadastroproduto.caracteristicaproduto.Caracteristica;
import br.com.jfb.mercadolivre.cadastrousuario.Usuario;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	private String nome;

	@NotNull
	@Positive
	private BigDecimal valor;

	@NotNull
	@Positive
	private int quantidade;

	@NotBlank
	@Size(max = 1000)
	private String descricao;

	@NotNull
	private LocalDateTime instanteCriacao = LocalDateTime.now();

	@NotNull
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@NotNull
	@ElementCollection
	private Set<Caracteristica> caracteristicas = new HashSet<>();

	@Deprecated
	public Produto() {
	}

	public Produto(@NotBlank String nome, @Positive BigDecimal valor, @Positive int quantidade,
			@NotBlank @Positive String descricao, Categoria categoria, Usuario usuario,
			Set<Caracteristica> listaCaracteristicas) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.categoria = categoria;
		this.usuario = usuario;
		this.caracteristicas = listaCaracteristicas;
	}

	public <T, D> List<T> mapperParaList(Collection<D> originalCollectionObject, Function<D, T> funcaoMap) {
		return originalCollectionObject.stream().map(funcaoMap).collect(Collectors.toList());
}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Produto)) {
			return false;
		}
		Produto produto = (Produto) o;
		return id == produto.id && Objects.equals(nome, produto.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

}
