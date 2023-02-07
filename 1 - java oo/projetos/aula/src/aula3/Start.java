package aula3;

public class Start {
    public static void main(String[] args) {
        Jogador gabriel = new Jogador();
        gabriel.nome = "Gabriel de Jesus";
        gabriel.velocidadeAtual = 11;
        gabriel.altura = 181;
        gabriel.idade = 23;

        System.out.println(gabriel.velocidadeAtual);

        gabriel.correr();

        System.out.println(gabriel.velocidadeAtual); // 12

//        int retornoSimulacao = gabriel.simularCorrida();
        System.out.println(gabriel.simularCorrida());
        System.out.println(gabriel.simularCorridaComParametros(10));
        System.out.println(gabriel.simularCorridaComParametros2(10, "o cara é o usin bolt"));

        System.out.println(gabriel.velocidadeAtual); // 12

//        Jogador maicon = new Jogador();
//        maicon.nome = "Maicon Gerardi";
//        maicon.velocidadeAtual = 8;
//        maicon.altura = 173;
//        maicon.idade = 31;
//
//        System.out.println(maicon.altura);


    }
}
