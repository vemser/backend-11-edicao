package aula6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Streams {
    public static void main(String[] args) {
//        List<Pessoa> lista = new ArrayList<>();
//        lista.add(new Pessoa(1, "Maicon", 50000));
//        lista.add(new Pessoa(2, "Pedro", 53000));
//        lista.add(new Pessoa(3, "Joel", 60000));

        List<String> minhaLista = new ArrayList<>();
        minhaLista.add("Maicon");
        minhaLista.add("Gabriel");
        minhaLista.add("Kelly");
        minhaLista.add("Miguel");

//        Stream<String> stream = minhaLista.stream();
//        stream.forEach(elemento -> {
//            System.out.println(elemento);
//        });
//
//        minhaLista.stream()
//                .forEach(elemento -> System.out.println(elemento));

//        minhaLista.stream()
//                .forEach(System.out::println);


//        List<String> filtrada = minhaLista.stream()
//                .filter(elemento -> elemento.contains("a"))
//                .collect(Collectors.toList());
//        minhaLista = minhaLista.stream()
//                .filter(elemento -> elemento.contains("a"))
//                .collect(Collectors.toList());

        // - = elemento é menor
        // 0 = igual
        // + = elemento é maior
//        List<String> listaOrdenada = minhaLista.stream()
//                //.sorted((elemento1, elemento2) -> elemento1.compareTo(elemento2)) //asc
//                .sorted((elemento1, elemento2) -> elemento2.compareTo(elemento1)) //desc
//                .toList();

        List<String> listaOrdenada2 = minhaLista.stream()
                //.sorted((elemento1, elemento2) -> elemento1.compareTo(elemento2)) //asc
//                .sorted() // asc
                .sorted(Comparator.reverseOrder()) //desc
                .toList();

        System.out.println(minhaLista);
        System.out.println(listaOrdenada2);
//        System.out.println(filtrada);

        List<Pessoa> lista = new ArrayList<>();
        lista.add(new Pessoa(1, "Maicon", 50000));
        lista.add(new Pessoa(2, "Pedro", 53000));
        lista.add(new Pessoa(3, "Joel", 60000));

        // Pessoa -> PessoaSemNome
        // Pessoa -> String
        // Pessoa -> Batata
        // Pessoa -> Qualquer Coisa

//        List<PessoaSemNome> listaPessoaSemNome =
         lista.stream()
                .filter(pessoa -> pessoa.getId() > 1)
                .sorted(Comparator.comparing(Pessoa::getNome))


                //id=3, nome='Joel', salario=60000.0 | Pessoa{id=2, nome='Pedro', salario=53000.0

//                .map((pessoa) -> {
//                    PessoaSemNome pessoaSemNome = new PessoaSemNome();
//                    pessoaSemNome.setId(pessoa.getId());
//                    pessoaSemNome.setSalario(pessoa.getSalario());
//                    return pessoaSemNome;
//                })
//                .map((pessoa) -> new PessoaSemNome(pessoa.getId(), pessoa.getSalario()))
                .map((pessoa) -> pessoa.getId());

//                .toList();

        System.out.println(lista);
                Double media = lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average()
                .getAsDouble();
        System.out.println(media);

        boolean todosGanham5000 = lista.stream()
                        .allMatch(pessoa -> pessoa.getSalario() > 5000); // todos os meus registros atendem essa condição
        System.out.println(todosGanham5000);

        boolean alguemGanha = lista.stream()
                .anyMatch(pessoa -> pessoa.getSalario() >= 60000);
        System.out.println(alguemGanha);
//        System.out.println(lista);
//        System.out.println(listaPessoaSemNome);

        Optional<Pessoa> primeiraPessoa = lista.stream()
                .filter(pessoa -> pessoa.getId() > 2)
                .findFirst();

        System.out.println(primeiraPessoa);
        System.out.println(primeiraPessoa.orElse(new Pessoa(999, "João", 1000)));
        if(primeiraPessoa.isPresent()){
            Pessoa pes = primeiraPessoa.get();
            System.out.println(pes);
        } else {
            System.out.println("Não encontrada");
        }
    }
}
