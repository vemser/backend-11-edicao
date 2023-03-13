package br.com.dbc.vemser.pessoaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PessoaApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(PessoaApiApplication.class, args);
    }

}
