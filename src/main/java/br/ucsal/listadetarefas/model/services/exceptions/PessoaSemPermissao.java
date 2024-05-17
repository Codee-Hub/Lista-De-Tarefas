package br.ucsal.listadetarefas.model.services.exceptions;

public class PessoaSemPermissao extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public PessoaSemPermissao (String msg) {
		super(msg);
	}
}
