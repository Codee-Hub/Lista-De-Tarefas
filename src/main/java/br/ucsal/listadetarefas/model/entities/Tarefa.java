package br.ucsal.listadetarefas.model.entities;

public abstract class Tarefa {
    private static Integer contadorId = 0;

    protected Integer id;
    protected String descricao;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.id = GerarId();
    }

    public Tarefa(Integer id, String descricao) {
        this.descricao = descricao;
        this.id = id;
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
