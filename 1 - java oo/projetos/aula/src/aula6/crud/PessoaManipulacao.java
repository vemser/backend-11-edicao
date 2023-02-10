package aula6.crud;

import java.util.ArrayList;
import java.util.List;

public class PessoaManipulacao {
    private List<Pessoa> listaDePessoas;

    public PessoaManipulacao() {
        this.listaDePessoas = new ArrayList<>();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        this.listaDePessoas.add(pessoa);
    }

    public void removerPessoaPorIndice(Integer index) {
        this.listaDePessoas.remove(index.intValue());
    }

    public void editarPessoa(Integer index, Pessoa pessoa) {
        Pessoa pessoaProcurada = listaDePessoas.get(index);
        pessoaProcurada.setIdade(pessoa.getIdade());
        pessoaProcurada.setNome(pessoa.getNome());
    }

    public void listarPessoas() {
        for (int i = 0; i < listaDePessoas.size(); i++) {
            System.out.println("id=" + i + " | " + listaDePessoas.get(i));
        }
    }
}
