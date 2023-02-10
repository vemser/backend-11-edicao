package aula6;

public class Funcoes {
    public static void main(String[] args) {
        Funcao funcaoSr = new Funcao(){
            public String gerar(String valor) {
                return "Sr. "+ valor;
            }
        };

        System.out.println(funcaoSr.gerar("Maicon"));

        Funcao funcaoSrComFuncao = (String qualquerCoisa) -> {
            return "Sr." + qualquerCoisa;
        };

        System.out.println(funcaoSrComFuncao.gerar("Miguel"));

        Funcao funcaoSrComFuncaoSimplificada = qualquerCoisa -> "Sr." + qualquerCoisa;


        Funcao funcaoSra = new Funcao(){
            public String gerar(String valor) {
                return "Sra. "+ valor;
            }
        };


        System.out.println(funcaoSra.gerar("Kelly"));
    }
}
