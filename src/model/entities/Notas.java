package model.entities;

import java.util.Objects;

public class Notas {
    private Aluno aluno;
    private Turma turma;
    private TipoAvaliacao Tipo;
    private Double valor;

    public Notas(){

    }

    public Notas(Aluno aluno, Turma turma, TipoAvaliacao Tipo, Double valor) {
    this.aluno = aluno;
    this.turma = turma;
    this.Tipo = Tipo;
    this.valor = valor;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public Turma getTurma() {
        return turma;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    public TipoAvaliacao getTipo() {
        return Tipo;
    }
    public void setTipo(TipoAvaliacao Tipo) {
        this.Tipo = Tipo;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "Nota [" + Tipo +
                "= " + String.format("%.2f", valor) +
                ", Aluno: " + aluno.getNome() +
                ", Turma: " + turma.getNome() + "]";
    }
}

