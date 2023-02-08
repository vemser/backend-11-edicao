package aula3;

public class Jogador {
    //atributos / caracteristicas
    String nome;
    int idade;
    int altura;
    double peso;
    int nrCamisa; // 01 ?
    static String time;
    String modalidade;
    int velocidadeAtual;

    public Jogador() {

    }

    public Jogador(String nome) {
        this.nome = nome;
    }

    public Jogador(String nome, String time) {
        this.nome = nome;
        this.time = time;
    }

    //
    public Jogador(String nome, int velocidadeAtual, int altura, int idade) {
        this.nome = nome;
        this.velocidadeAtual = velocidadeAtual;
        this.altura = altura;
        this.idade = idade;
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

    int simularCorrida() {
        int simulacao = velocidadeAtual + 5;
        return simulacao;
    }

    int simularCorridaComParametros(int valorSimulacao) {
        int simulacao = velocidadeAtual + valorSimulacao;
        return simulacao;
    }

    int simularCorridaComParametros2(int valorSimulacao, String mensagem) {
        int simulacao = velocidadeAtual + valorSimulacao;
        System.out.println(mensagem);
        return simulacao;
    }

    void fazerFinta() {
        velocidadeAtual--;
    }

    public String toString() {
        return nome + " time: " + time;
    }

}
