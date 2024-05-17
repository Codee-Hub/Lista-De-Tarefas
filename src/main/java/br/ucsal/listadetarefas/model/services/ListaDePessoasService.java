package br.ucsal.listadetarefas.model.services;

import br.ucsal.listadetarefas.model.entities.PessoaComPermissao;
import br.ucsal.listadetarefas.model.services.exceptions.PessoaNaoEncontrada;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaDePessoasService {

    private List<PessoaComPermissao> pessoas = new ArrayList<>();

    public List<PessoaComPermissao> getPessoas() {
        return pessoas;
    }

    public PessoaComPermissao getPessoaById(int id) {
        try {
            if(pessoas.stream().filter(p -> p.getId() == id).findFirst().isPresent()) {
                return pessoas.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
            } else {
                throw new PessoaNaoEncontrada("Pessoa não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertPessoas(PessoaComPermissao pessoaComPermissao)  {
        try {
            pessoas.add(pessoaComPermissao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePessoaById(Integer id)  {
        try {
            if(pessoas.stream().filter(p -> p.getId() == id).findFirst().isPresent()) {
                pessoas = pessoas.stream().filter(pessoa -> pessoa.getId() != id).collect(Collectors.toList());
            } else {
                throw new PessoaNaoEncontrada("Pessoa não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePessoas(PessoaComPermissao pessoaComPermissao)  {
        try {
            if(pessoas.stream().filter(p -> p.getId() == pessoaComPermissao.getId()).findFirst().isPresent()) {
                deletePessoaById(pessoaComPermissao.getId());
                insertPessoas(pessoaComPermissao);
            } else {
                throw new PessoaNaoEncontrada("Pessoa não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
