package aula5;

public class Main {
    public static void main(String[] args) {

        // sobrecarga
        Jogador jogador = new Jogador();
        Jogador jogador2 = new Jogador("Maicon");
        Jogador jogador3 = new Jogador("Maicon", 32);
        int teste = 0;

        jogador.correr();
        jogador.correr(5);

        // sobrescrita
        Object objeto = new Object();
        System.out.println(objeto.toString());
        System.out.println(jogador.toString());
    }


}
