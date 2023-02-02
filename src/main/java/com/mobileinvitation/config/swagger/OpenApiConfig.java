package com.mobileinvitation.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(title = "API 명세서",
        description = "API 명세서",
        version = "v1",
//        contact = @Contact(name = "", email = ""),
        license = @License(name = "Apache 2.0",
            url = "http://www.apache.org/licenses/LICENSE-2.0.html")
    ),
    servers = {
        @Server(url = "http://localhost:8080/", description = "local")
        // dev 등등 필요시 추가
    }
)
@Configuration
public class OpenApiConfig {

  @Bean
  public GroupedOpenApi infoOpenApi() {
    String[] paths = {"/**"};
    return GroupedOpenApi.builder().group("rest Controller API").pathsToMatch(paths)
        .build();
  }

}
