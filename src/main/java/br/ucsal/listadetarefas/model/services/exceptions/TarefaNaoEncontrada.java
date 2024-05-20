package br.ucsal.listadetarefas.model.services.exceptions;

public class TarefaNaoEncontrada extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public TarefaNaoEncontrada(String msg) {
        super(msg);
    }
}
