package br.ucsal.listadetarefas.model.services;

import br.ucsal.listadetarefas.model.entities.PessoaComPermissao;
import br.ucsal.listadetarefas.model.services.exceptions.PessoaNaoEncontrada;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PessoasComPermissaoService {

    private List<PessoaComPermissao> pessoasComPermissao = new ArrayList<>();

    public List<PessoaComPermissao> getPessoaComPermissao() {
        return pessoasComPermissao;
    }

    public PessoaComPermissao getPessoaComPermissaoById(int id) {
        try {
            if(pessoasComPermissao.stream().filter(p -> p.getId() == id).findFirst().isPresent()) {
                return pessoasComPermissao.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
            } else {
                throw new PessoaNaoEncontrada("PessoaComPermissao não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertPessoaComPermissaos(PessoaComPermissao pessoaComPermissao)  {
        try {
            pessoasComPermissao.add(pessoaComPermissao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePessoaComPermissaoById(Integer id)  {
        try {
            if(pessoasComPermissao.stream().filter(p -> p.getId() == id).findFirst().isPresent()) {
                pessoasComPermissao = pessoasComPermissao.stream().filter(pessoa -> pessoa.getId() != id).collect(Collectors.toList());
            } else {
                throw new PessoaNaoEncontrada("PessoaComPermissao não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePessoaComPermissaos(PessoaComPermissao pessoaComPermissao)  {
        try {
            if(pessoasComPermissao.stream().filter(p -> p.getId() == pessoaComPermissao.getId()).findFirst().isPresent()) {
                deletePessoaComPermissaoById(pessoaComPermissao.getId());
                insertPessoaComPermissaos(pessoaComPermissao);
            } else {
                throw new PessoaNaoEncontrada("PessoaComPermissao não encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
