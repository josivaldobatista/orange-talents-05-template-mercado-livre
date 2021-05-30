package br.com.jfb.mercadolivre.cadastrousuario;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;
  private String senha;

  @NotNull
  private LocalDateTime instanteCriacao = LocalDateTime.now();

  @Deprecated
  public Usuario() {
  }

  public Usuario(String email, String senha) {
    this.email = email;
    this.senha = new BCryptPasswordEncoder().encode(senha);
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getSenha() {
    return senha;
  }

  public LocalDateTime getInstanteCriacao() {
    return instanteCriacao;
  }

  @Override
  public String getPassword() {
    return senha;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  

}
