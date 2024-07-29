package com.valdirsantos714.crenteflix.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(req -> req.requestMatchers(HttpMethod.POST,"/auth/register").permitAll())
                .authorizeHttpRequests(req -> req.requestMatchers(HttpMethod.POST,"/auth/login").permitAll())
                .authorizeHttpRequests(req ->req.requestMatchers(HttpMethod.GET, "/conteudo/all").permitAll())
                .authorizeHttpRequests(req -> req.anyRequest().authenticated()) //E que as outras requisições tem que estar autenticado
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) //Diz pra ele filtrar primeiro usando o meu filtro que vai gerar a autorização para o usuário
                .build();
    }

    @Bean
    public AuthenticationManager authentication(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
