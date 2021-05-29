package br.com.jfb.mercadolivre.cadastrousuario;

import java.time.LocalDateTime;

public class UsuarioResponse {

  private Long id;
  private String email;
  private LocalDateTime instanteCriacao;

  public UsuarioResponse(Usuario usuario) {
    id = usuario.getId();
    email = usuario.getEmail();
    instanteCriacao = usuario.getInstanteCriacao();
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public LocalDateTime getInstanteCriacao() {
    return instanteCriacao;
  }

}
