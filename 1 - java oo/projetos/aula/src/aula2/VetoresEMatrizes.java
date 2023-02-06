package aula2;

import java.util.Scanner;

public class VetoresEMatrizes {
    public static void main(String[] args) {
//        double[] notas = new double[4];
//        // double nota1 =
//        // double nota2 =
//        // double nota3 =
//        // double nota4 =
//
//        notas[0] = 9.4;
//        notas[1] = 8.0;
//        notas[2] = 7.0;
//        notas[3] = 9.0;

        // parada = 4
//        for (int parada = 0; parada < notas.length; parada++){
//            System.out.println("indice: "+ parada + " valor: "+ notas[parada]);
//        }
//
//        System.out.println(notas[2]);
//        System.out.println(notas[0]);
//        System.out.println(notas[1]);

//        String[] alunos = {"Luis", "Miguel", "Gabriel 1", "Gabriel 2", "Gabriel 3", "Gabriel 4"};
//
//        for (String aluno : alunos) {
//            System.out.println(aluno);
//        }

//
//        System.out.println(alunos[0]);
//        System.out.println(alunos[alunos.length - 1]);
//        System.out.println(alunos.length);
//
//        int[][] matriz = new int[4][5]; // 4 linhas e 5 colunas
//////        int matriz2[][] = new int[2][2];
//        for(int x = 0; x < matriz.length ; x++){
//            for (int y = 0; y < matriz[x].length; y++){
//                System.out.println("indice: "+ x + ", " + y + " valor: "+ matriz[x][y]);
//            }
//        }

//        for (int[] matriz1 : matriz) {
//            for(int valor : matriz1){
//                System.out.println(valor);
//            }
//        }

//
//        matriz[1][1] = 10;
//        System.out.println(matriz[1][1]);
//        System.out.println(matriz[0][0]);
//
//        int[][] matrizInicializada = {
//                // 0 1 2
//                {10,2,5}, // 0
//                {9,8,1,6},  // 1
//                {9,9,9}   // 2
//        };
//
//        matrizInicializada[0][1] = 5;
//        System.out.println(matrizInicializada[0][1]);
//        System.out.println(matrizInicializada[0][3]);

        Scanner leitor = new Scanner(System.in);
//        int valor = leitor.nextInt();
//
//        while(valor == 0) { //false
//            System.out.println("é igual a zero");
//            valor = leitor.nextInt();
//        }
//        System.out.println("saiu do while");

//        String valor = leitor.nextLine();

//        while(!valor.equals("sair")) { //false
//            System.out.println("não é sair");
//            valor = leitor.nextLine(); // sair
//        }
//        System.out.println("saiu do while");

        String valor = "";
        do {
            valor = leitor.nextLine();
            System.out.println(valor);
        } while (!valor.equals("sair"));
        System.out.println("saiu do while");
    }
}
