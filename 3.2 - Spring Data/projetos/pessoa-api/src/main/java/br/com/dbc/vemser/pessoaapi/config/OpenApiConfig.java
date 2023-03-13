package br.com.dbc.vemser.pessoaapi.config;

//import io.swagger.v3.oas.models.Components; not used in this example
//import io.swagger.v3.oas.models.security.SecurityScheme; same as above
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .info(new Info().title("Pessoa API")
                        .description("Pessoa API documentação")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName)
                );
    }
}
