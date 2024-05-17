package br.ucsal.listadetarefas.model.entities;

public abstract class Tarefa {
    private static Integer contadorId = 0;

    protected Integer id;
    protected String descricao;

    public Tarefa(String descricao, Integer id) {
        this.descricao = descricao;
        this.id = GerarId();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
