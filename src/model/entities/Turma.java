package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Turma {
    private Integer id;
    private String nome;
    private Integer ano;
    private Disciplina disciplina;
    private Integer semestre;
    private List<Aluno> AlunosMatriculados = new ArrayList<>();



    public Turma(Integer id, String nome, Integer ano, Disciplina disciplina, Integer semestre) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.disciplina = disciplina;
        this.semestre = semestre;
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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getSemestre() {
        return semestre;
    }
    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public List<Aluno> getAlunosMatriculados() {
        return AlunosMatriculados;
    }
    public void matricularAluno(Aluno aluno) {
        if(!AlunosMatriculados.contains(aluno)) {
            AlunosMatriculados.add(aluno);
        }
    }
    public void removerAluno(Aluno aluno) {
        AlunosMatriculados.remove(aluno);
    }
    @Override
    public String toString() {
        return "[ Nome: " + nome +
                ", Ano: " + ano +
                ", Disciplina: " + (disciplina !=null ? disciplina.getNome(): "sem disciplina") +
                ", Semestre: " + semestre +
               ", Quantidade de alunos: " + AlunosMatriculados.size() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Turma)) return false;
        Turma turma = (Turma) o;
        return Objects.equals(id, turma.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }








}


