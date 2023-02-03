public class Comparadores {
    public static void main(String args[]){
        /*
          OPERADORES ARITMÉTICOS
          + : soma
          - : subtração
          / : divisão
          * : multiplicação
          % : módulo / resto da divisão

          ++ : incrementa o valor
          -- : decrementa
          += : soma com o valor que já tem na variável
          -= : diminui com o valor que já tem na variável
          *= : multiplica com o valor que já tem na variável
          /= : divide com o valor que já tem na variável
          */

        // COMENTAR / DESCOMENTAR = [CTRL] + [/]
        // + : soma
//        System.out.println(5 + 3);
//
//        int salarioMeu = 10000;
//        int salarioDaMinhaEsposa = 15000;
//        System.out.println(salarioMeu + salarioDaMinhaEsposa);

        // - : subtração
//        System.out.println(10 - 3);

        // / : divisão
//        System.out.println(6 / 2);
//        System.out.println(6 / 0);

        // * : multiplicação
//        System.out.println(6 * 2);

        // % : módulo / resto da divisão
//        System.out.println(3 % 2);
//        System.out.println(4 % 2);

        // ++ : incrementa o valor
//        int numero = 10;
////        System.out.println(numero++);
//        System.out.println(++numero);
//        System.out.println(numero);

        // -- : decrementa
//        int numero = 10;
//        numero--;
//        System.out.println(numero);

        // += : soma com o valor que já tem na variável
//        int numero = 10;
//        numero+=10;
//        System.out.println(numero);

        // -= : diminui com o valor que já tem na variável
//        int numero = 10;
//        numero-=5;
//        System.out.println(numero);

        // *= : multiplica com o valor que já tem na variável
//        int numero = 10;
//        numero*=3;
//        System.out.println(numero);

        // /= : divide com o valor que já tem na variável
//        int numero = 10;
//        numero/=2;
//        System.out.println(numero);

        /*
          COMPARADORES
          == : variavel é igual a outraVariavel
          != : variavel é diferente da outraVariavel
          < : variável (< menor) outraVariavel
          > : variável (> maior) outraVariavel
          >= : variável (>= maior ou igual) outraVariavel
          <= : variável (<= menor ou igual) outraVariavel
          */

        // == : variavel é igual a outraVariavel
//        System.out.println(1 == 1);
//        System.out.println(2 == 1);
//        boolean pagaPensao = false;
//        System.out.println(pagaPensao == true);

        // != : variavel é diferente da outraVariavel
//        System.out.println(1 != 2);
//        System.out.println(1 != 1);
//        boolean ehCasado = false;
//        System.out.println(ehCasado != true);

        // < : variável (< menor) outraVariavel
//        System.out.println(10 < 2);
//        System.out.println(10 < 20);


        // > : variável (> maior) outraVariavel
//        System.out.println(10 > 2);
//        System.out.println(10 > 20);

        // >= : variável (>= maior ou igual) outraVariavel
//        System.out.println(10 >= 10);
//        System.out.println(10 >= 9);
//        System.out.println(10 >= 20);

        // <= : variável (<= menor ou igual) outraVariavel
//        System.out.println(9 <= 9);
//        System.out.println(9 <= 20);
//        System.out.println(9 <= 8);

        /*
          AGREGADORES
          ! = não ... !ehSolteiro (não ehSolteiro) PS: se a variável estiver como TRUE, ela se torna FALSE. e vice-versa
          && = e ... ehSolteiro e temVidaSocial
          || = ou ... ehSolteiro ou ehCasado
          */

        // ! = não ... !ehSolteiro (não ehSolteiro) PS: se a variável estiver como TRUE, ela se torna FALSE. e vice-versa
//        boolean ehSolteiro = 1==2; // false
//        System.out.println(!ehSolteiro); // true

        // && = E ... ehSolteiro e temVidaSocial
        // as duas condições tem que ser verdadeira para o && ser verdadeiro...
//        boolean ehSolteiro = true;
//        boolean temVidaSocial = true;
//        System.out.println(ehSolteiro && temVidaSocial); // true && false && X

//        boolean ehSolteiro = true;
//        boolean temVidaSocial = false;
//        System.out.println(ehSolteiro && temVidaSocial);
        // || = OU ... ehSolteiro ou ehCasado
        // uma das duas condições tem que ser verdadeira para o || ser verdadeiro...
//        boolean ehSolteiro = true;
//        boolean ehCasado = false;
//        System.out.println(ehSolteiro || ehCasado); // true || true || true

//        boolean ehSolteiro = false;
//        boolean ehCasado = false;
//        System.out.println(ehSolteiro || ehCasado);
    }
}
