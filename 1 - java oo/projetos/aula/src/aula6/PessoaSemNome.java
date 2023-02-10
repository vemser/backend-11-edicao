package aula6;

public class PessoaSemNome {
    private int id;
    private double salario;

    public PessoaSemNome() {
    }

    public PessoaSemNome(int id, double salario) {
        this.id = id;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "PessoaSemNome{" +
                "id=" + id +
                ", salario=" + salario +
                '}';
    }
}
