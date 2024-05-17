package br.ucsal.listadetarefas.model.entities;

public class TarefaComPessoa extends Tarefa{

    private PessoaComPermissao pessoa;

    public TarefaComPessoa(String descricao, Integer id, PessoaComPermissao pessoa) {
        super(descricao, id);
        this.pessoa = pessoa;
    }

    public PessoaComPermissao getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaComPermissao pessoa) {
        this.pessoa = pessoa;
    }
}
