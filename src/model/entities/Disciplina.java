package model.entities;

import java.util.Objects;

public class Disciplina {
    private Integer id;
    private String nome;
    private Integer CargaHoraria;

    public Disciplina() {
    }

    public Disciplina(Integer id, String nome, Integer CargaHoraria) {
    this.id=id;
    this.nome=nome;
    this.CargaHoraria=CargaHoraria;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public Integer getCargaHoraria() {
        return CargaHoraria;
    }
    public void setCargaHoraria(Integer cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }


    @Override
    public String toString(){
        return "[Nome: " + nome + ", " + "Id: " + id + "CargaHoraria: " + CargaHoraria + "]";

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}

