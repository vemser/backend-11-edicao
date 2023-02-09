package aula5;


public class Jogador extends Object {
    //atributos / caracteristicas
    private String nome;
    private int idade;
    private int altura;
    private double peso;
    private int nrCamisa; // 01 ?
    private String time;
    private String modalidade;
    private int velocidadeAtual;

    public Jogador(){

    }

    public Jogador(String nome){
        this.nome = nome;
    }

    public Jogador(String nome, int idade, int altura, double peso, int nrCamisa, String time, String modalidade, int velocidadeAtual) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.nrCamisa = nrCamisa;
        this.time = time;
        this.modalidade = modalidade;
        this.velocidadeAtual = velocidadeAtual;
    }

    public Jogador(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Jogador(String nome, int idade, int altura, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Jogador " + nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
//        return this.nome;
        return nome;
    }

    public void dormir(){

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

    void correr(int velocidadeAMais){
        velocidadeAtual+=velocidadeAMais;
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
