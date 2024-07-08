package no.kotlinRestApi.presentation.api.configuration

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .addSecurityItem(SecurityRequirement().addList("bearerAuth"))
            .components(Components().addSecuritySchemes("bearerAuth", apiSecurityScheme()))
            .info(
                Info().title("My API")
                    .description("Sample API")
                    .version("v1")
            )
    }

    @Bean
    fun apiSecurityScheme(): SecurityScheme {
        return SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("jwt")
            .`in`(SecurityScheme.In.HEADER)
            .name("Authorization")
    }


    @Bean
    fun defaultGroup(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("spring")
            .pathsToMatch("/**")
            .build()
    }
}