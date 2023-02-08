package aula4;

public class Main {
    public static void main(String[] args) {
        Jogador jogador = new Jogador();
//        jogador.nome = "Maicon";
        jogador.setNome("Gabriel");
        String nomeJogador = jogador.getNome();
        System.out.println(nomeJogador);

//        SerHumano serHumano = new SerHumano();

        Arquiteto arquiteto = new Arquiteto();
        arquiteto.setNome("");
    }
}
