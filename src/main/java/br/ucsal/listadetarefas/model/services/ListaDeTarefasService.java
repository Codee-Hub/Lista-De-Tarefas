package br.ucsal.listadetarefas.model.services;

import br.ucsal.listadetarefas.model.entities.Tarefa;
import br.ucsal.listadetarefas.model.entities.TarefaComPessoa;
import br.ucsal.listadetarefas.model.enums.StatusDaTarefa;
import br.ucsal.listadetarefas.model.services.exceptions.PessoaSemPermissao;
import br.ucsal.listadetarefas.model.services.exceptions.TarefaNaoEncontrada;
import br.ucsal.listadetarefas.model.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaDeTarefasService {

    private List<TarefaComPessoa> tarefas = new ArrayList<>();

    public List<TarefaComPessoa> getTarefas() {
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

    public void insertTarefas(TarefaComPessoa tarefaComPessoa)  {
        try {
            if(Utils.ChecarNivelDePermissao(tarefaComPessoa.getPessoa(), tarefaComPessoa.getNivel())){
                tarefas.add(tarefaComPessoa);
                System.out.println("Tarefa sucesso");
            } else{
                throw new PessoaSemPermissao("A Pessoa designada para essa tarefa nao tem a permissao necessaria para realiza-la");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTarefaById(Integer id)  {
        try {
            if(tarefas.stream().filter(p -> p.getId() == id).findFirst().isPresent()) {
                tarefas = tarefas.stream().filter(Tarefa -> Tarefa.getId() != id).collect(Collectors.toList());
                System.out.println("Tarefa sucesso");
            } else {
                throw new TarefaNaoEncontrada("Tarefa não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTarefas(TarefaComPessoa tarefaComPermissao)  {
        try {
            if(tarefas.stream().filter(p -> p.getId() == tarefaComPermissao.getId()).findFirst().isPresent()) {
                if(Utils.ChecarNivelDePermissao(tarefaComPermissao.getPessoa(), tarefaComPermissao.getNivel())){
                    deleteTarefaById(tarefaComPermissao.getId());
                    insertTarefas(tarefaComPermissao);
                    System.out.println("Tarefa modificada com sucesso");
                } else{
                    throw new PessoaSemPermissao("A Pessoa designada para essa tarefa nao tem a permissao necessaria para realiza-la");
                }
            } else {
                throw new TarefaNaoEncontrada("Tarefa não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TarefaComPessoa> getTarefasByPessoa(int idPessoa) {
        return tarefas.stream().filter(tarefa -> tarefa.getId() == idPessoa).collect(Collectors.toList());
    }

    public List<TarefaComPessoa> getTarefasPendentes() {
        return tarefas.stream().filter(tarefa -> tarefa.getStatus() == StatusDaTarefa.PENDENTE).collect(Collectors.toList());
    }
}
