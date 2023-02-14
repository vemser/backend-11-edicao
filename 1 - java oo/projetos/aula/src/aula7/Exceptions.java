package aula7;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args)  /* throws IOException */ {

//        try {
//            System.out.println("TRY: TENTA ");
//            double divisao = 5/0;
//        } catch (){
//            System.out.println("CATCH: DEU RUIM ");
//        } finally {
//            System.out.println("FINALLY: SEMPRE EXECUTA ");
//        }
//        if(nome == gabriel){

//        }

//        throw new Exception("já estourou o limite de gabriel na turma");
        Scanner scanner = new Scanner(System.in);

        try {
            criarArquivoMinhaException("teste");
        } catch (ArquivoNaoEncontradoException e) {
            e.printStackTrace();
        }

        try {
            criarArquivo("Arquivo"); // IOException
            criarArquivoMinhaException("teste"); // ArquivoNaoEncontradoException

            // individualmente
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            System.out.println("Arquivo nao criado! ");
//        } catch (ArquivoNaoEncontradoException ex){

            // concatenada
//        } catch (ArquivoNaoEncontradoException | IOException  ex){
//            ex.printStackTrace();
//        }

            // genérica
        } catch (Exception ex){
            ex.printStackTrace();
        }

        finally {
            scanner.close();
            System.out.println("executou o finally");
        }
        // propago / trato

    }

    public static void criarArquivoMinhaException(String nome) throws ArquivoNaoEncontradoException {
        try {
            File destino = new File("/teste/teste.jpeg");
            destino.createNewFile();
        } catch (IOException ex){
            throw new ArquivoNaoEncontradoException("Arquivo "+nome +" não foi encontrado");
        }
    }

    public static void criarArquivo(String nome) throws IOException {
        File destino = new File("/teste/teste.jpeg");
        destino.createNewFile();
    }


}
