package br.com.dbc.pacote2;

public class Jogador {
    //atributos / caracteristicas
    private String nome;
    int idade;
    private int altura;
    private double peso;
    private int nrCamisa; // 01 ?
    private String time;
    private String modalidade;
    private int velocidadeAtual;

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
//        return this.nome;
        return nome;
    }

    // metodos / comportamentos
//    correr
//    pular
//    driblar
//    jogar
//    passar
//    trocaCamisa
//    fazerAcerto
//    cabecear
//    fazerFinta / fintar

    void correr() {
        velocidadeAtual++;
        System.out.println("o jogador correu");
    }

    int simularCorrida(){
        int simulacao = velocidadeAtual + 5;
        return simulacao;
    }

    int simularCorridaComParametros(int valorSimulacao){
        int simulacao = velocidadeAtual + valorSimulacao;
        return simulacao;
    }

    int simularCorridaComParametros2(int valorSimulacao, String mensagem){
        int simulacao = velocidadeAtual + valorSimulacao;
        System.out.println(mensagem);
        return simulacao;
    }

    void fazerFinta() {
        velocidadeAtual--;
    }

}
