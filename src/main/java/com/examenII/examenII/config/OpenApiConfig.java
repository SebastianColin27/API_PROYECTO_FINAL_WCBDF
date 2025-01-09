package com.examenII.examenII.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Configuration;

@Configuration

public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employees API")
                        .version("1.0")
                        .description("API para gestionar Employees con seguridad por roles"))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("basicAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic")));
    }
}
/*@OpenAPIDefinition(
        info=@Info(
                title="API de Employees",
                description="Esta api proporciona accersoa los recurisos de los empleados de abarrotes Don Sebas",
                version = "1.0.0",
                contact = @Contact(
                        name="Sebastian Colin",
                        email = "jcolinb1800@alumno.ipn.mx",
                        url = "http://localhost:8086/contacto"
                ),
                license = @License(),
                termsOfService = ""
        ),
       /* servers ={

                @Server(
                        description = "Servidor de producción",
                        url = "http://localhost:8080/api/v1/employees")
        },
        tags = {
                @Tag(
                        name = "Employees",
                        description = "Endpoints para los recursos del empleado"
                )
        }


)*/


