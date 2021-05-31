package br.com.jfb.mercadolivre.shared.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import br.com.jfb.mercadolivre.cadastrousuario.Usuario;
import br.com.jfb.mercadolivre.cadastrousuario.UsuarioRepository;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

  @Autowired
  private UsuarioRepository repository;

  /**
   * Esse método vai entrar no ciclo de vida do token e na hora de geralo vai
   * acrescentar os objetos que eu passar.
   */
  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
    Usuario usuario = repository.findByEmail(authentication.getName()).get();
    Map<String, Object> map = new HashMap<>();
    map.put("instanteCriacao", usuario.getInstanteCriacao());

    DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
    token.setAdditionalInformation(map);
    return accessToken;
  }

}