package br.ucsal.listadetarefas.model.controllers;

import br.ucsal.listadetarefas.model.entities.TarefaComPessoa;
import br.ucsal.listadetarefas.model.services.TarefasComPessoaService;

import java.util.List;

public class TarefaComPessoaController {

    private final TarefasComPessoaService service = new TarefasComPessoaService();

    public TarefaComPessoa getTarefaComPessoasById(int id) {
        return service.getTarefaComPessoaById(id);
    }

    public List<TarefaComPessoa> getTarefasComPessoas(){
       return service.getTarefasComPessoa();
    }

    public void insert(TarefaComPessoa tarefaComPessoa) {
        service.insertTarefaComPessoa(tarefaComPessoa);
    }

    public void delete(int id) {
        service.deleteTarefaComPessoaById(id);
    }

    public void update(TarefaComPessoa tarefaComPessoa) {
        service.updateTarefaComPessoa(tarefaComPessoa);
    }

    public List<TarefaComPessoa> getTarefasComPessoaPendentes(){
        return service.getTarefasComPessoaPendentes();
    }

    public List<TarefaComPessoa> getTarefasComPessoaByPessoa(int id){
        return service.getTarefaByPessoa(id);
    }
}
