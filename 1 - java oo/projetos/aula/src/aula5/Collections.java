package aula5;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        //NÃO USAR
//        List listaDeNomes = new ArrayList();
//        listaDeNomes.add(1);        // 0
//        listaDeNomes.add("Maicon"); // 1
//        listaDeNomes.add(5.5);      // 2
//
//        System.out.println(listaDeNomes);
//        Object maicon = listaDeNomes.get(1);
//        String maiconConvertido = (String) maicon;
//
        //usar assim:
//        List<String> listaDeNomesGenerica = new ArrayList<>();
//        listaDeNomesGenerica.add("Maicon");     //0
//        listaDeNomesGenerica.add("Maicon");     //0
//        listaDeNomesGenerica.add("Gabriel 1");  //1
//        listaDeNomesGenerica.add("Gabriel 2");  //2
//        listaDeNomesGenerica.add("Gabriel 3");  //3
//        listaDeNomesGenerica.add("Gabriel 4");  //4
//
//        listaDeNomesGenerica.set(5, "Gabriel Schramm");
//        // 5 elementos
//        // ultimo indice 4
//
//        System.out.println(listaDeNomesGenerica);
//        String maiconGenerico = listaDeNomesGenerica.get(0);
////        String gabriel = listaDeNomesGenerica.get(5); // erro
//
//
//
//       String obj = listaDeNomesGenerica.remove(0);
//       boolean removido = listaDeNomesGenerica.remove("Maicon");
//
//        System.out.println(listaDeNomesGenerica);
//
//        System.out.println(listaDeNomesGenerica.size());
//
//        System.out.println(listaDeNomesGenerica.get(listaDeNomesGenerica.size() - 1));

//        Queue<String> fila = new LinkedList<>();
//
//        fila.add("Maicon");
//        fila.add("Gabriel");
//        fila.add("Kelly");
//
//        System.out.println(fila);
//
//        String primeiro = fila.poll();
//
//        System.out.println(primeiro);
//
//        System.out.println(fila);

//        Stack<String> pilha = new Stack<>();
//        pilha.add("Maicon");
//        pilha.add("Gabriel");
//        pilha.add("João");
//
//        System.out.println(pilha);
//
//        String retirado = pilha.pop();
//        System.out.println(retirado);
//
//        System.out.println(pilha);
//
//        pilha.add("Felipe");
//
//        System.out.println(pilha);

        Map<String, String> pessoasPorCPF = new HashMap<>();
        pessoasPorCPF.put("20366326023", "João da Silva");
        pessoasPorCPF.put("39432181049", "Pedro José");
        pessoasPorCPF.put("23502812055", "Henrique de Souza");
        pessoasPorCPF.put("23502812055", "Maicon Gerardi");

        System.out.println(pessoasPorCPF);

        System.out.println(pessoasPorCPF.get("454"));
        System.out.println(pessoasPorCPF.get("20366326023"));
        System.out.println(pessoasPorCPF.remove("20366326023"));
        System.out.println(pessoasPorCPF);

    }
}
