package br.com.dbc.vemser.pessoaapi.entity;

import java.util.Arrays;

public enum TipoEndereco {
    RESIDENCIAL(1), COMERCIAL(2);

    private Integer tipo;

    TipoEndereco(Integer tipo) { this.tipo = tipo; }

    public Integer getTipo() { return tipo; }

    public static TipoEndereco ofTipo(Integer tipo) {
        return Arrays.stream(TipoEndereco.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}