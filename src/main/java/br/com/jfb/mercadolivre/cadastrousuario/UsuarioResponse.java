package br.com.jfb.mercadolivre.cadastrousuario;

public class UsuarioResponse {

  private Long id;
  private String email;

  public UsuarioResponse(Usuario usuario) {
    id = usuario.getId();
    email = usuario.getEmail();
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

}
