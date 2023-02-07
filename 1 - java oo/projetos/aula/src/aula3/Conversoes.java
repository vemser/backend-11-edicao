package aula3;

public class Conversoes {
    public static void main(String[] args) {
        int valor = 5;
//        Integer valorWrapper = new Integer(1);
        Integer valorWrapper = 5;

        long valorLong = 8;

        valorLong = valor;
        valor = (int) valorLong;

        Long valorLongWrapper = 8l;

        Integer valorConvertido = valorLongWrapper.intValue();
        Long valorDeIntegerPLong = valorConvertido.longValue();


        // https://www.devmedia.com.br/conversoes-em-java/2695
        // https://docs.oracle.com/javase/specs/jls/se17/html/jls-5.html

        String teste = "meu teste";
        passarValor(teste);
        System.out.println(teste);

        Jogador meuJogador = new Jogador();
        meuJogador.nome = "João";
        passarReferencia(meuJogador);
        System.out.println(meuJogador.nome);
    }

    public static void passarValor(String qualquerCoisa){ // wrapper, String...
        qualquerCoisa = "Não é mais um teste";
    }

    public static void passarReferencia(Jogador jogador){ //NÃO É UM TIPO PRIMITIVO / Wrapper LOGO ALTERA O VALOR
        jogador.nome = "Michael Jackson";
    }
}
