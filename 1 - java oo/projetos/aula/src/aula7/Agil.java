package aula7;

import java.util.Arrays;
import java.util.Optional;

public enum Agil {
    KANBAN("Kanban", 1050), //0
    SCRUM("Scrum", 1080), //1
    METODO_TRADICIONAL("Método Tradicional", 1030); //2
    // n...

    private String descricao;
    private Integer identificador;

    Agil(String descricao, Integer identificador){
        this.descricao = descricao;
        this.identificador = identificador;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public Integer getIdentificador(){
        return identificador;
    }

    public static Optional<Agil> recuperarPorIdentificador(Integer identificador){
        return Arrays.stream(values())
                .filter(agil -> agil.getIdentificador() == identificador)
                .findFirst();
    }
    public static Agil recuperarPorIdentificadorFor(Integer identificador){
        for (Agil agil: values()){
            if(agil.getIdentificador() == identificador){
                return agil;
            }
        }
        return null;
    }

}
