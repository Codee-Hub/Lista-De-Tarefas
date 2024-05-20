package br.ucsal.listadetarefas.model.controllers;

import br.ucsal.listadetarefas.model.entities.PessoaComPermissao;
import br.ucsal.listadetarefas.model.services.PessoasComPermissaoService;

import java.util.List;

public class PessoaComPermissaoController {

    private final PessoasComPermissaoService service = new PessoasComPermissaoService();

    public PessoaComPermissao getPessoaById(int id) {
        return service.getPessoaComPermissaoById(id);
    }

    public List<PessoaComPermissao> getListaDePessoa(){
       return service.getPessoaComPermissao();
    }

    public void insert(PessoaComPermissao pessoaComPermissao) {
        service.insertPessoaComPermissaos(pessoaComPermissao);
    }

    public void delete(int id) {
        service.deletePessoaComPermissaoById(id);
    }

    public void update(PessoaComPermissao pessoaComPermissao) {
        service.updatePessoaComPermissaos(pessoaComPermissao);
    }
}
