package br.com.jfb.mercadolivre.cadastrousuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.jfb.mercadolivre.shared.valiations.UniqueValueValid;

public class UsuarioDTO {

  @Email
  @NotBlank
  @UniqueValueValid(domainClass = Usuario.class, fieldName = "email", message = "E-mail deve ser único")
  private String email;

  @NotBlank
  @Length(min = 6)
  private String senha;

  @Deprecated
  public UsuarioDTO() {
  }

  public UsuarioDTO(Long id, @Email @NotBlank String email, @NotBlank @Size(min = 6) String senha) {
    this.email = email;
    this.senha = senha;
  }

  public UsuarioDTO(Usuario entity) {
    email = entity.getEmail();
    senha = entity.getSenha();
  }

  public Usuario toModel() {
    return new Usuario(email, senha);
  }

  public String getEmail() {
    return email;
  }

  public String getSenha() {
    return senha;
  }

}
