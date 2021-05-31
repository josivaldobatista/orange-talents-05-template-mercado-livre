package br.com.jfb.mercadolivre.cadastroproduto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jfb.mercadolivre.cadastrocategoria.Categoria;
import br.com.jfb.mercadolivre.cadastrocategoria.CategoriaRepository;
import br.com.jfb.mercadolivre.cadastroproduto.caracteristicaproduto.CaracteristicaIguaisValidator;
import br.com.jfb.mercadolivre.cadastrousuario.Usuario;
import br.com.jfb.mercadolivre.cadastrousuario.UsuarioRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new CaracteristicaIguaisValidator());
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoResponse> cadastrar(@RequestBody @Valid ProdutoRequest request) {
		Categoria categoria = categoriaRepository.getOne(request.getCategoria_id());
		Usuario usuario = usuarioRepository.findByEmail("alex@gmail.com").get();
		Produto entity = request.toModel(categoria, usuario);
		produtoRepository.save(entity);
		return ResponseEntity.ok().body(new ProdutoResponse(entity));
	}
}
