import java.util.List;

class Aluno{
    private int id;
    private String nome;
    private String matricula;
    private String email;


    public Aluno(int idAL, String nomeAL, String emailAL, String matriculaAL) {
        id=idAL;
        nome = nomeAL;
        matricula = matriculaAL;
        email = emailAL;
    }

    public int getIdAL() {
        return id;
    }
    public String getNomeAL() {
        return nome;
    }
    public String getMatriculaAL() {
        return matricula;
    }
    public String getEmailAL() {
        return email;
    }
    public void setIdAL(int idAL) {
        id=idAL;
    }
    public void setNomeAL(String nomeAL) {
        nome=nomeAL;
    }
    public void setMatriculaAL(String matriculaAL) {
        matricula=matriculaAL;
    }
    public void setEmailAL(String emailAL) {
        email=emailAL;
    }
    @Override
    public String toString() {
        return "Nome: " + nome
                + "Matricula: " + matricula
                + "Email: " + email
                + " ID do sistema: " + id;
    }
}

class Turma {
    private int id;
    private String nome;
    private int ano;
    private int semestre;
    private Disciplina disciplina;
    private List<Aluno> alunos;

    public Turma(int id, String nome, int ano, int semestre, Disciplina disciplina, List<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.semestre = semestre;
        this.disciplina = disciplina;
        this.alunos = alunos;
    }
    public int getId() { return id;}
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome;}
    public int getAno() {return ano;  }
    public void setAno(int ano) {this.ano = ano; }
    public int getSemestre() { return semestre;  }
    public void setSemestre(int semestre) {this.semestre = semestre; }
    public Disciplina getDisciplina() {return disciplina; }
    public void setDisciplina(Disciplina disciplina) {this.disciplina = disciplina;  }
    public List<Aluno> getAlunos() { return alunos;  }

}

class Disciplina {
    private int id;
    private String nome;
    private String CargaHoraria;

    public Disciplina(int idDaDisciplina, String nomeDaDisciplina, String CargaHorariaDaDisciplina) {
        id = idDaDisciplina;
        nome = nomeDaDisciplina;
        CargaHoraria = CargaHorariaDaDisciplina;
    }

    public int getIdDaDisciplina() { return id; }

    public void setIdDaDisciplina(int id) { this.id = id; }

    public String getNomeDaDisciplina() {return nome; }

    public void setNomeDaDisciplina(String nome) {this.nome = nome; }

    public String getCargaHorariaDaDisciplina() {return CargaHoraria;}
}
class Nota {
    private Aluno aluno;
    private Turma turma;
    private TipoAvaliacao tipo;
    private Double valor;

    public Nota(Aluno aluno, Turma turma, double valor) {
        this.aluno = aluno;
        this.turma = turma;
        this.tipo = tipo;
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


 public enum TipoAvaliacao {
     PARTICIPACAO,
     PROVA, TRABALHO;

     public static TipoAvaliacao fromString(String tipoAvaliacao) {
         if (tipoAvaliacao.equals("PARTICIPACAO")) {
             return PARTICIPACAO;
         } else if (tipoAvaliacao.equals("PROVA")) {
             return PROVA;
         } else if (tipoAvaliacao.equals("TRABALHO")) {
             return TRABALHO;
         }
         return null;
     }
 }

}

public class Main {
     static void main(String[] args) {
        Aluno aluno = new Aluno(123112, "Pedro Nathan", "pnslguimaraes@gmail.com", "1290318-2025/01");
        System.out.println("Nome do aluno: " + aluno.getNomeAL());
        System.out.println("Email do aluno: " + aluno.getEmailAL());
        System.out.println("Matricula do aluno: " + aluno.getMatriculaAL());
        System.out.println("Id do aluno: " + aluno.getIdAL());




    }
}