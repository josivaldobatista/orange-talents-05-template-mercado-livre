package br.com.jfb.mercadolivre.cadastrousuario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioRepository repository;
  
  @PostMapping
  @Transactional
  public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioDTO dto) {
    Usuario entity = dto.toModel();
    repository.save(entity);
    return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioDTO(entity));
  }
}
