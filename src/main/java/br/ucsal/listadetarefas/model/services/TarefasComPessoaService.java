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

public class TarefasComPessoaService {

    private List<TarefaComPessoa> tarefasComPessoa = new ArrayList<>();

    public List<TarefaComPessoa> getTarefasComPessoa() {
        return tarefasComPessoa;
    }

    public TarefaComPessoa getTarefaComPessoaById(int id) {
        try {
            if(tarefasComPessoa.stream().filter(p -> p.getId() == id).findFirst().isPresent()) {
                return tarefasComPessoa.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
            } else {
                throw new TarefaNaoEncontrada("Tarefa não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertTarefaComPessoa(TarefaComPessoa tarefaComPessoa)  {
        try {
            if(Utils.ChecarNivelDePermissao(tarefaComPessoa.getPessoa(), tarefaComPessoa.getNivel())){
                tarefasComPessoa.add(tarefaComPessoa);
                System.out.println("Tarefa sucesso");
            } else{
                throw new PessoaSemPermissao("A Pessoa designada para essa tarefa nao tem a permissao necessaria para realiza-la");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTarefaComPessoaById(Integer id)  {
        try {
            if(tarefasComPessoa.stream().filter(p -> p.getId() == id).findFirst().isPresent()) {
                tarefasComPessoa = tarefasComPessoa.stream().filter(Tarefa -> Tarefa.getId() != id).collect(Collectors.toList());
                System.out.println("Tarefa sucesso");
            } else {
                throw new TarefaNaoEncontrada("Tarefa não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTarefaComPessoa(TarefaComPessoa tarefaComPessoa)  {
        try {
            if(tarefasComPessoa.stream().filter(p -> p.getId() == tarefaComPessoa.getId()).findFirst().isPresent()) {
                if(Utils.ChecarNivelDePermissao(tarefaComPessoa.getPessoa(), tarefaComPessoa.getNivel())){
                    deleteTarefaComPessoaById(tarefaComPessoa.getId());
                    insertTarefaComPessoa(tarefaComPessoa);
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

    public List<TarefaComPessoa> getTarefaByPessoa(int idPessoa) {
        return tarefasComPessoa.stream().filter(tarefa -> tarefa.getId() == idPessoa).collect(Collectors.toList());
    }

    public List<TarefaComPessoa> getTarefasComPessoaPendentes() {
        return tarefasComPessoa.stream().filter(tarefa -> tarefa.getStatus() == StatusDaTarefa.PENDENTE).collect(Collectors.toList());
    }
}
