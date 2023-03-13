package br.com.dbc.vemser.pessoaapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertieReader {

    @Value("${ambiente}")
    private String ambiente;
    public String getPropertie(){
        return ambiente;
    }
}
