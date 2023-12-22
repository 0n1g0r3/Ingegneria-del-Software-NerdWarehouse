package com.example.NerdWarehouse.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Carlo Alessio"
                ),
                description = "OpenApi documentation for Spring Security",
                title = "OpenAPi NerdWarehouse",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "local IT",
                        url = "http://localhost:8010"
                )

        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "Jwt auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT"
)

public class OpenApiConfig { // mette "in sicurezza" la documentazione di Swagger

}
