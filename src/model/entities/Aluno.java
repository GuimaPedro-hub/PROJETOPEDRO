package model.entities;
import java.util.Objects;


public class Aluno {
    private String nome;
    private String matricula;
    private String email;
    private Integer id;


    public Aluno(String nome, String matricula, String email, int id) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.id = id;

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
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {

        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    @Override
    public String toString() {
        return "[Nome: " + nome + "," +
                "Matricula: " + matricula + ", " +
                "Email: " + email + ", " +
                "ID: " + id + " ] ";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id);
    }

   @Override
   public int hashCode(){
            return Objects.hash(id);
        }

}
