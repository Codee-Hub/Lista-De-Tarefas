package br.ucsal.listadetarefas.model.entities;

import java.util.Objects;

public abstract class Pessoa {
	public static Integer contadorId = 0;
	
	protected Integer id;
	protected String nome;
	
	public Pessoa() {
		
	}

	public Pessoa(Integer id, String nome) {
		this.id = GerarId();
		this.nome = nome;
	}

	private Integer GerarId() {
		return contadorId++;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
}
