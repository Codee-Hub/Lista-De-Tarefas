package br.ucsal.listadetarefas.model.utils;

import br.ucsal.listadetarefas.model.entities.PessoaComPermissao;
import br.ucsal.listadetarefas.model.enums.NivelDePermissao;
import br.ucsal.listadetarefas.model.services.exceptions.PessoaSemPermissao;

public class Utils {

	public static Boolean ChecarNivelDePermissao(PessoaComPermissao pessoa, NivelDePermissao permissaoDaTarefa) {

		NivelDePermissao nivelDePermissaoPessoa = pessoa.getNivelDePermissao();

		if (nivelDePermissaoPessoa != null) {
			switch (nivelDePermissaoPessoa) {
			case AVANÇADO:
				return true;
			case INTERMEDIARIO:
				if (permissaoDaTarefa != NivelDePermissao.AVANÇADO) {
					return true;
				}
				break;
			case BASICO :
				if (permissaoDaTarefa == NivelDePermissao.BASICO) {
					return true;
				}
				break;
			default:
				break;
			}
		} else {
			throw new PessoaSemPermissao("A pessoa não tem uma atribuicão de permissão");
		}
		return false;
	}
}
