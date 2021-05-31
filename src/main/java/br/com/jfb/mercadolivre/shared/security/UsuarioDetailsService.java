package br.com.jfb.mercadolivre.shared.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.jfb.mercadolivre.cadastrousuario.Usuario;
import br.com.jfb.mercadolivre.cadastrousuario.UsuarioRepository;

@Component
public class UsuarioDetailsService implements UserDetailsService {

  @Autowired
  private UsuarioRepository repository;

  private static Logger logger = LoggerFactory.getLogger(UsuarioDetailsService.class);

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Usuario usuario = repository.findByEmail(username).get();
    if (usuario == null) {
      logger.error("Usuario não encontrado " + username);
      throw new UsernameNotFoundException("E-mail não encontrado");
    }
    logger.info("Usuario encontrado " + username);
    return usuario;
  }

}
