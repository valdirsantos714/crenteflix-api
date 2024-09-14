package com.valdirsantos714.crenteflix.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("CrenteFlix API")
                        .description("CrenteFlix é uma API que permite a autenticação de usuários e oferece funcionalidades para cadastrar, atualizar, deletar e buscar filmes e séries.")
                        .contact(new Contact()
                                .name("Valdir Santos")
                                .email("valdirsantost40@gmail.com")));

    }
}