package br.ucsal.listadetarefas;

import br.ucsal.listadetarefas.model.controllers.PessoaComPermissaoController;
import br.ucsal.listadetarefas.model.controllers.TarefaComPessoaController;
import br.ucsal.listadetarefas.model.entities.PessoaComPermissao;
import br.ucsal.listadetarefas.model.entities.TarefaComPessoa;
import br.ucsal.listadetarefas.model.enums.NivelDePermissao;

public class Main {
	
	public static void main(String [] args) {
		TarefaComPessoaController tarefaComPessoaController = new TarefaComPessoaController();
		PessoaComPermissaoController pessoaComPermissaoController = new PessoaComPermissaoController();

		pessoaComPermissaoController.insert(new PessoaComPermissao("Pedro", NivelDePermissao.AVANÇADO));
		pessoaComPermissaoController.insert(new PessoaComPermissao("Maria", NivelDePermissao.INTERMEDIARIO));
		pessoaComPermissaoController.insert(new PessoaComPermissao("marco", NivelDePermissao.BASICO));

		pessoaComPermissaoController.getListaDePessoa().forEach(System.out::println);

		tarefaComPessoaController.insert(new TarefaComPessoa("Laver pratos", pessoaComPermissaoController.getPessoaById(2), NivelDePermissao.BASICO));
		tarefaComPessoaController.insert(new TarefaComPessoa("Laver banheiro", pessoaComPermissaoController.getPessoaById(1), NivelDePermissao.INTERMEDIARIO));
		tarefaComPessoaController.insert(new TarefaComPessoa("Lavar Carro", pessoaComPermissaoController.getPessoaById(0), NivelDePermissao.AVANÇADO));
		tarefaComPessoaController.insert(new TarefaComPessoa("Lavar Casa", pessoaComPermissaoController.getPessoaById(0), NivelDePermissao.AVANÇADO));

		tarefaComPessoaController.getTarefasComPessoas().forEach(System.out::println);

		tarefaComPessoaController.delete(1);
		tarefaComPessoaController.update(new TarefaComPessoa(2,"lavar barco",pessoaComPermissaoController.getPessoaById(2), NivelDePermissao.BASICO));
		tarefaComPessoaController.concluirTarefaComPessoa(0);
		tarefaComPessoaController.getTarefasComPessoas().forEach(System.out::println);
		System.out.println("Hola");
		tarefaComPessoaController.getTarefasComPessoaByPessoa(2).forEach(System.out::println);
		System.out.println("Hola");
		tarefaComPessoaController.getTarefasComPessoaPendentes().forEach(System.out::println);


	}

}
