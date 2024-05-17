package br.ucsal.listadetarefas.model.exceptions;

public class PessoaSemPermissao extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public PessoaSemPermissao (String msg) {
		super(msg);
	}
}
