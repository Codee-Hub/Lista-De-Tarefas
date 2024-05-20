package br.ucsal.listadetarefas.model.entities;

import br.ucsal.listadetarefas.model.enums.NivelDePermissao;
import br.ucsal.listadetarefas.model.enums.StatusDaTarefa;

public class TarefaComPessoa extends Tarefa{

    private PessoaComPermissao pessoa;
    private StatusDaTarefa status;
    private NivelDePermissao nivel;

    public TarefaComPessoa(String descricao, PessoaComPermissao pessoa, StatusDaTarefa status, NivelDePermissao nivel) {
        super(descricao);
        this.pessoa = pessoa;
        this.status = status;
        this.nivel = nivel;
    }

    public TarefaComPessoa(Integer id ,String descricao, PessoaComPermissao pessoa, StatusDaTarefa status, NivelDePermissao nivel) {
        super(id, descricao);
        this.pessoa = pessoa;
        this.status = status;
        this.nivel = nivel;
    }

    public NivelDePermissao getNivel() {
        return nivel;
    }

    public void setNivel(NivelDePermissao nivel) {
        this.nivel = nivel;
    }

    public StatusDaTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusDaTarefa status) {
        this.status = status;
    }

    public PessoaComPermissao getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaComPermissao pessoa) {
        this.pessoa = pessoa;
    }
}
