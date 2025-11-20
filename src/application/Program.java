package application;
import model.entities.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Program {
     static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Aluno> alunos = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();
        List<Notas> notas = new ArrayList<>();

        int proximoIdAluno = 1;
        int proximoIdDisciplina = 1;
        int proximoIdTurma = 1;

        int opcao;

        do {
            System.out.println("========Sistema Escolar =========");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Disciplina");
            System.out.println("3. Cadastrar Turma");
            System.out.println("4. Matricular aluno em turma");
            System.out.println("5. Lançar nota");
            System.out.println("6. Ver boletim de um aluno");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }
            switch (opcao) {
                case 1:
                    proximoIdAluno = cadastrarAlunos(sc, alunos, proximoIdAluno);
                    break;
                case 2:
                    proximoIdDisciplina = cadastrarDisciplina(sc, disciplinas, proximoIdDisciplina);
                    break;
                case 3:
                    proximoIdTurma = cadastrarTurma(sc, disciplinas, turmas, proximoIdTurma);
                    break;
                case 4:
                    matricularAlunoEmTurma(sc, alunos, turmas);
                    break;
                case 5:
                    lancarNotas(sc, alunos, turmas, notas);
                    break;
                case 6:
                    verBoletim(sc, alunos, turmas, notas);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }
        while (opcao != 0 );
        sc.close();
    }
    private static int cadastrarAlunos(Scanner sc, List<Aluno> alunos, int proximoId){
        System.out.println("\n--- Cadastro de Alunos ---");
        System.out.println("Digite o nome do aluno: ");
        String nome = sc.nextLine();
        System.out.println("Digite o email do aluno: ");
        String email = sc.nextLine();
        System.out.println("Matricula do aluno: : ");
        String matricula = sc.nextLine();

        Aluno a = new Aluno(nome, email, matricula, proximoId);
        alunos.add(a);

        System.out.println("Aluno cadastrado com ID: " + proximoId);
        return proximoId + 1;
    }
    private static int cadastrarDisciplina( Scanner sc, List<Disciplina> disciplinas, int proximoId){
        System.out.println("\n--- Cadastro de Disciplinas ---");
        System.out.println("Digite o nome do disciplina: ");
        String nome = sc.nextLine();
        System.out.println("Digite a carga horária(em horas) da Disciplina: ");
        Integer CargaHoraria = Integer.parseInt(sc.nextLine());
        Disciplina d = new Disciplina(proximoId, nome, CargaHoraria);
        disciplinas.add(d);

        System.out.println("Disciplina cadastrada com ID: " + proximoId);
        return proximoId + 1;
    }
    private static int cadastrarTurma(Scanner sc,
                                  List<Disciplina> disciplinas,
                                  List<Turma> turmas,
                                  int proximoIdTurma){
        System.out.println("\n--- Cadastro de Turmas ---");

        if(disciplinas.isEmpty()){
            System.out.println("Cadastre pelo menos uma disciplina");
            return proximoIdTurma;
        }

        System.out.println("Digite o nome do turma: ");
        String nomeTurma = sc.nextLine();
        System.out.println("Ano: ");
        int ano = Integer.parseInt(sc.nextLine());
        System.out.println("Semestre: ");
        int semestre = Integer.parseInt(sc.nextLine());

        System.out.println("Digite as disciplinas disponíveis: ");
        for(Disciplina d : disciplinas){
            System.out.println(d.getId() + " - " + d.getNome());
        }
        System.out.println("ID da Disciplina da Turma: ");
        int idDisciplina = Integer.parseInt(sc.nextLine());

        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.getId() == idDisciplina)
                .findFirst()
                .orElse(null);

        if(disciplina == null){
            System.out.println("Disciplina não encontrada");
        return proximoIdTurma;
        }

         Turma t = new Turma (proximoIdTurma, nomeTurma, ano, disciplina, semestre);
            turmas.add(t);

            System.out.print("Turma criada com ID: " + proximoIdTurma);
            return proximoIdTurma + 1;

        }

        private static void matricularAlunoEmTurma(Scanner sc,
                                                   List<Aluno> alunos,
                                                   List<Turma> turmas) {
            System.out.println("\n--- Matricula de Aluno em Turma ---");

            if (alunos.isEmpty()) {
                System.out.println("Cadastre pelo menos um aluno e uma turma cadastrada");
                return;
            }
            System.out.println("Alunos cadastrados: ");
            for (Aluno alunoss : alunos) {
                System.out.println(alunoss.getId() + " - " + alunoss.getNome());
            }
            System.out.println("Id do aluno: ");
            int idAluno = Integer.parseInt(sc.nextLine());

            Aluno aluno = alunos.stream()
                    .filter(alunoss -> alunoss.getId() == idAluno)
                    .findFirst()
                    .orElse(null);
            if (aluno == null) {
                System.out.println("Aluno não encontrado!");
                return;
            }
            System.out.println("Turmas cadastras: ");
            for (Turma t : turmas) {
                System.out.println(t.getId() + " - " + t.getNome() +
                        " (" + t.getDisciplina().getNome() + ")");
            }
            System.out.println("ID da Turma: ");
            int idTurma = Integer.parseInt(sc.nextLine());

            Turma turma = turmas.stream()
                    .filter(t -> t.getId() == idTurma)
                    .findFirst()
                    .orElse(null);
            if (turma == null) {
                System.out.println("Turma não encontrada!");
                return;
            }
            turma.matricularAluno(aluno);
            System.out.println("Aluno matriculado na turma com sucesso.");
        }

        private static void lancarNotas(Scanner sc, List<Aluno> alunos, List<Turma> turmas, List<Notas> notas) {

         System.out.println("\n--- Lançar Notas ---");
         if (alunos.isEmpty() || turmas.isEmpty()){
             System.out.println("É necessário ter pelo menos 1 aluno e 1 turma cadastrada!");
             return;
         }

         System.out.println("Alunos cadastrados: ");
         for(Aluno aluno : alunos){
             System.out.println(aluno.getId() + " - " + aluno.getNome());
         }

         System.out.println("Id do aluno: ");
         int idAluno = Integer.parseInt(sc.nextLine());

         Aluno aluno = alunos.stream()
                 .filter(alunoss-> alunoss.getId() == idAluno)
                 .findFirst()
                 .orElse(null);

         if (aluno == null) {
         System.out.println("Aluno não encontrado!");
             return;
         }

         System.out.println("Turmas cadastras: ");
         for(Turma t: turmas){
             System.out.println(t.getId() + " - " + t.getNome() + " (" + t.getDisciplina().getNome() + ") " );
         }
         System.out.println("ID da Turma: ");
         int idTurma = Integer.parseInt(sc.nextLine());

         Turma Turmas =turmas.stream()
                 .filter(Turma ->Turma.getId() == idTurma )
                 .findFirst()
                 .orElse(null);

            if (Turmas == null) {
             System.out.println("Turma não encontrada'");
             return;
         }
         if(!Turmas.getAlunosMatriculados().contains(aluno)){
             System.out.print("Aluno nõa está matriculado nesta turma");
         }

         System.out.println("Tipos de Avaliação: ");
         for(TipoAvaliacao tipo : TipoAvaliacao.values()){
             System.out.println(tipo.ordinal() + " - " + tipo);
         }
        System.out.println("Tipo (numero) : " );
         int tipoIndex = Integer.parseInt(sc.nextLine());
         TipoAvaliacao tipo = TipoAvaliacao.values()[tipoIndex];


            System.out.println("Valor da nota: ");
            double valor = Double.parseDouble(sc.nextLine());
            Notas Nota = new Notas(aluno, Turmas, tipo, valor);
            notas.add(Nota);
            System.out.println("Notas cadastradas com sucesso!");
            }

        private static void verBoletim(Scanner sc, List<Aluno> alunos, List<Turma> turmas, List<Notas> notas) {
        System.out.println("\n--- Boletim do Aluno ---");

        if(alunos.isEmpty()){
            System.out.println("Nenhum aluno encontrado!");
        return;
        }

        System.out.println("Alunos cadastrados: ");
        for(Aluno a : alunos){
            System.out.println(a.getId() + " - " + a.getNome());
        }
        System.out.println("Id do aluno: ");
        int idAluno;
        try {
            idAluno = Integer.parseInt(sc.nextLine());
        }
        catch (NumberFormatException e) {
            System.out.println("ID inválido!");
            return;
        }

        Aluno aluno = alunos.stream()
                .filter(a ->a.getId() == idAluno)
                .findFirst()
                .orElse(null);

        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
            System.out.println("\nBoletim de: "+ aluno.getNome());
            System.out.println("DEBUG: total de notas cadastradas: " + notas.size());

        //para cada turma em que o aluno está matriculado, listar notas
            turmas.stream()
                    .filter(t->t.getAlunosMatriculados().contains(aluno))
                    .forEach(t-> {
                        System.out.println("\nTurma: " + t.getNome() + " - " + t.getDisciplina().getNome());


                        List<Notas> notasDaTurma=notas.stream()
                                .filter(n -> n.getAluno().equals(aluno) && n.getTurma().equals(t))
                                .toList();
                        if(notasDaTurma.isEmpty()){
                            System.out.println("Nenhum nota encontrada para esta Turma!");
                        }
                        else{
                            for(Notas n : notasDaTurma){
                                System.out.println(" " + n);
                            }
                        }
                    });
    }

}
