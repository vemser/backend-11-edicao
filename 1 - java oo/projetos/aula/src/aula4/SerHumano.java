package aula4;

public abstract class SerHumano {
    private String nome;

    public SerHumano(String nome) {
        this.nome = nome;
    }
//
    public SerHumano (){

    }

    public abstract void dormir();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
