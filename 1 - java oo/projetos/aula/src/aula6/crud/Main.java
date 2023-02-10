package aula6.crud;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PessoaManipulacao pessoaManipulacao = new PessoaManipulacao();

        int opcao = 0;
        while (opcao != 9) {
            System.out.println("Digite 1 para criar pessoa");
            System.out.println("Digite 2 para listar pessoas");
            System.out.println("Digite 3 para editar uma pessoa");
            System.out.println("Digite 4 para excluir pessoas");
            System.out.println("Digite 9 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    Pessoa pessoa = new Pessoa();
                    System.out.println("Digite o nome da pessoa");
                    pessoa.setNome(scanner.nextLine());
                    System.out.println("Digite a idade da pessoa");
                    pessoa.setIdade(scanner.nextInt());
                    pessoaManipulacao.adicionarPessoa(pessoa);
                    break;
                case 2:
                    pessoaManipulacao.listarPessoas();
                    break;
                case 3:
                    System.out.println("Qual pessoa você deseja editar?");
                    pessoaManipulacao.listarPessoas();
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    Pessoa pessoaNova = new Pessoa();
                    System.out.println("Digite o novo nome da pessoa");
                    pessoaNova.setNome(scanner.nextLine());
                    System.out.println("Digite a nova idade da pessoa");
                    pessoaNova.setIdade(scanner.nextInt());
                    pessoaManipulacao.editarPessoa(index, pessoaNova);
                    break;
                case 4:
                    System.out.println("Qual pessoa você deseja excluir?");
                    pessoaManipulacao.listarPessoas();
                    int id = scanner.nextInt();
                    pessoaManipulacao.removerPessoaPorIndice(id);
                    break;
                case 9:
                    break;
                default:
                    System.err.println("opção inválida");
                    break;
            }
        }

    }
}
