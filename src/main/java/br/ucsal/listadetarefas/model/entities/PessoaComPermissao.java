package br.ucsal.listadetarefas.model.entities;

import br.ucsal.listadetarefas.model.enums.NivelDePermissao;

public class PessoaComPermissao extends Pessoa {
	
	private NivelDePermissao nivelDePermissao;

	public PessoaComPermissao( String nome, NivelDePermissao nivelDePermissao) {
		super(nome);
		this.nivelDePermissao = nivelDePermissao;
	}
	
	public PessoaComPermissao(Integer id, String nome, NivelDePermissao nivelDePermissao) {
		super(id, nome);
		this.nivelDePermissao = nivelDePermissao;
	}

	public NivelDePermissao getNivelDePermissao() {
		return nivelDePermissao;
	}

	public void setNivelDePermissao(NivelDePermissao nivelDePermissao) {
		this.nivelDePermissao = nivelDePermissao;
	}
}
