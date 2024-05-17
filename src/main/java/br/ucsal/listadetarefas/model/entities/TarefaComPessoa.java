package br.ucsal.listadetarefas.model.entities;

public class TarefaComPessoa extends Tarefa{

    private PessoaComPermissao pessoa;

    public TarefaComPessoa(String descricao, PessoaComPermissao pessoa) {
        super(descricao);
        this.pessoa = pessoa;
    }

    public TarefaComPessoa(Integer id ,String descricao, PessoaComPermissao pessoa) {
        super(id, descricao);
        this.pessoa = pessoa;
    }

    public PessoaComPermissao getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaComPermissao pessoa) {
        this.pessoa = pessoa;
    }
}
