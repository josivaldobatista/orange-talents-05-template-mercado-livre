package br.com.jfb.mercadolivre.cadastrocategoria;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
  private CategoriaRepository repository;

  @PostMapping
  @Transactional
	public ResponseEntity<CategoriaResponse> cadastrar(@RequestBody @Valid CategoriaRequest request) {
		Categoria entity = request.toModel(repository);
		entity = repository.save(entity);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(entity.getId()).toUri();

		return ResponseEntity.created(uri).body(new CategoriaResponse(entity));
	}
}
