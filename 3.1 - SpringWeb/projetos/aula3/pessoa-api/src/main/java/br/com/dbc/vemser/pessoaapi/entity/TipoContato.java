package br.com.dbc.vemser.pessoaapi.entity;

import java.util.Arrays;

public enum TipoContato {
    RESIDENCIAL(1),
    COMERCIAL(2);

    private Integer tipo;

    TipoContato(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoContato ofTipo(Integer tipo){
        return Arrays.stream(TipoContato.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
