package br.ucsal.listadetarefas.model.services;

import br.ucsal.listadetarefas.model.entities.Tarefa;
import br.ucsal.listadetarefas.model.services.exceptions.TarefaNaoEncontrada;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaDeTarefasService {

    private List<Tarefa> tarefas = new ArrayList<>();

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public Tarefa getTarefaById(int id) {
        try {
            if(tarefas.stream().filter(p -> p.getId() == id).findFirst().isPresent()) {
                return tarefas.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
            } else {
                throw new TarefaNaoEncontrada("Tarefa não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertTarefas(Tarefa TarefaComPermissao)  {
        try {
            tarefas.add(TarefaComPermissao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTarefaById(Integer id)  {
        try {
            if(tarefas.stream().filter(p -> p.getId() == id).findFirst().isPresent()) {
                tarefas = tarefas.stream().filter(Tarefa -> Tarefa.getId() != id).collect(Collectors.toList());
            } else {
                throw new TarefaNaoEncontrada("Tarefa não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTarefas(Tarefa Tarefa)  {
        try {
            if(tarefas.stream().filter(p -> p.getId() == Tarefa.getId()).findFirst().isPresent()) {
                deleteTarefaById(Tarefa.getId());
                insertTarefas(Tarefa);
            } else {
                throw new TarefaNaoEncontrada("Tarefa não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Tarefa> getTarefasByPessoa(int idPessoa) {
        return tarefas.stream().filter(tarefa -> tarefa.getId() == idPessoa).collect(Collectors.toList());
    }
}
