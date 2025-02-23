package br.com.jfb.mercadolivre.shared.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  @Autowired
  private Environment env;

  private static final String[] PUBLIC = { "/oauth/token", "/produtos/{id:[0-9]+}", "/h2-console/**" };

  private static final String[] USUARIOS = { "/usuarios" };

  @Autowired
  private TokenStore tokenStore;

  // Verifica se o token é valido
  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.tokenStore(tokenStore);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    // Libera o H2
    if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
      http.headers().frameOptions().disable();
    }

    http.authorizeRequests()
        .antMatchers(PUBLIC).permitAll()
        .antMatchers(HttpMethod.POST, USUARIOS).permitAll()
        .anyRequest().authenticated();
  }
  
}
