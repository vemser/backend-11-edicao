package br.com.dbc.vemser.pessoaapi.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Hidden
@RestController
public class OpenApiController {

    // @Operation(hidden = true)
    @GetMapping(value = "/")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }
}