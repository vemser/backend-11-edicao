package aula1;

import java.util.Scanner;

public class LeitorUsuario {
    public static void main(String[] args) {
        Scanner leitorDoUsuario = new Scanner(System.in);

        System.out.println("Informe o seu nome: ");
        String nome = leitorDoUsuario.nextLine();
        System.out.println(nome);

        System.out.println("Informe a sua idade: ");
        int idade = leitorDoUsuario.nextInt();
        leitorDoUsuario.nextLine();
        System.out.println(idade);

    }
}
