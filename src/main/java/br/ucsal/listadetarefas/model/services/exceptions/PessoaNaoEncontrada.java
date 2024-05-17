package br.ucsal.listadetarefas.model.services.exceptions;

public class PessoaNaoEncontrada extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public PessoaNaoEncontrada (String msg) {
        super(msg);
    }
}
