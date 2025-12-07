package ui;

import model.*;
import repository.*;
import service.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Instanciar repos e serviços (camada repository + service - Fase 7)
        var alunoRepo = new AlunoRepository();
        var profRepo = new ProfessorRepository();
        var cursoRepo = new CursoRepository();
        var turmaRepo = new TurmaRepository();

        var alunoService = new AlunoService(alunoRepo);
        var profService = new ProfessorService(profRepo);
        var cursoService = new CursoService(cursoRepo);
        var turmaService = new TurmaService(turmaRepo);

        // Inserir alguns dados de exemplo (para testes)
        Curso c1 = new CursoPresencial("Sistemas de Informação", "SI101", 360, "Sala 12");
        Curso c2 = new CursoEAD("Logística", "LG202", 200, "Plataforma X");
        cursoService.cadastrar(c1);
        cursoService.cadastrar(c2);

        Professor p1 = new Professor("Dra. Maria", "Banco de Dados", "PROF100", "maria", "123");
        profService.cadastrar(p1);

        Aluno a1 = new Aluno("João Silva", "2025001", c1, "joao", "abc");
        alunoService.cadastrar(a1);

        Turma t1 = new Turma("TURMA01", p1, c1);
        turmaService.cadastrar(t1);
        t1.adicionarAluno(a1);

        // Loop do menu simples (Fase Final)
        boolean sair = false;
        while (!sair) {
            System.out.println("\n== SGE - Menu ==");
            System.out.println("1) Cadastrar Aluno");
            System.out.println("2) Cadastrar Professor");
            System.out.println("3) Cadastrar Curso");
            System.out.println("4) Criar Turma");
            System.out.println("5) Matricular Aluno em Turma");
            System.out.println("6) Registrar Avaliação");
            System.out.println("7) Gerar Relatórios");
            System.out.println("0) Sair");
            System.out.print("Opção: ");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1" -> {
                    System.out.print("Nome do aluno: ");
                    String nome = sc.nextLine();
                    System.out.print("Matrícula: ");
                    String mat = sc.nextLine();
                    System.out.println("Cursos disponíveis:");
                    List<Curso> cursos = cursoService.listar();
                    for (int i = 0; i < cursos.size(); i++) {
                        System.out.printf("%d) %s\n", i + 1, cursos.get(i).detalharCurso());
                    }
                    System.out.print("Escolha (número): ");
                    int ci = Integer.parseInt(sc.nextLine()) - 1;
                    Curso escolhido = cursos.get(ci);
                    System.out.print("Login: ");
                    String login = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    Aluno novo = new Aluno(nome, mat, escolhido, login, senha);
                    alunoService.cadastrar(novo);
                    System.out.println("Aluno cadastrado: " + novo);
                }
                case "2" -> {
                    System.out.print("Nome do professor: ");
                    String nome = sc.nextLine();
                    System.out.print("Especialidade: ");
                    String esp = sc.nextLine();
                    System.out.print("Registro: ");
                    String reg = sc.nextLine();
                    System.out.print("Login: ");
                    String login = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    Professor prof = new Professor(nome, esp, reg, login, senha);
                    profService.cadastrar(prof);
                    System.out.println("Professor cadastrado: " + prof);
                }
                case "3" -> {
                    System.out.print("Nome do curso: ");
                    String nome = sc.nextLine();
                    System.out.print("Código: ");
                    String cod = sc.nextLine();
                    System.out.print("Carga horária: ");
                    int ch = Integer.parseInt(sc.nextLine());
                    System.out.print("Tipo (1) Presencial (2) EAD: ");
                    String tipo = sc.nextLine();
                    if (tipo.equals("1")) {
                        System.out.print("Sala: ");
                        String sala = sc.nextLine();
                        Curso cp = new CursoPresencial(nome, cod, ch, sala);
                        cursoService.cadastrar(cp);
                        System.out.println("Curso presencial cadastrado.");
                    } else {
                        System.out.print("Plataforma: ");
                        String pla = sc.nextLine();
                        Curso ce = new CursoEAD(nome, cod, ch, pla);
                        cursoService.cadastrar(ce);
                        System.out.println("Curso EAD cadastrado.");
                    }
                }
                case "4" -> {
                    System.out.print("Código da turma: ");
                    String cod = sc.nextLine();
                    System.out.println("Professores:");
                    var profs = profService.listar();
                    for (int i = 0; i < profs.size(); i++) {
                        System.out.printf("%d) %s\n", i + 1, profs.get(i));
                    }
                    System.out.print("Escolha (número): ");
                    int pi = Integer.parseInt(sc.nextLine()) - 1;
                    Professor prof = profs.get(pi);

                    System.out.println("Cursos:");
                    var cursos = cursoService.listar();
                    for (int i = 0; i < cursos.size(); i++) {
                        System.out.printf("%d) %s\n", i + 1, cursos.get(i).detalharCurso());
                    }
                    System.out.print("Escolha (número): ");
                    int ci2 = Integer.parseInt(sc.nextLine()) - 1;
                    Curso curso = cursos.get(ci2);

                    Turma t = new Turma(cod, prof, curso);
                    turmaService.cadastrar(t);
                    System.out.println("Turma criada: " + t.resumoTurma());
                }
                case "5" -> {
                    System.out.println("Turmas:");
                    var turmas = turmaService.listar();
                    for (int i = 0; i < turmas.size(); i++) {
                        System.out.printf("%d) %s\n", i + 1, turmas.get(i).resumoTurma());
                    }
                    System.out.print("Escolha turma (número): ");
                    int ti = Integer.parseInt(sc.nextLine()) - 1;
                    Turma turma = turmas.get(ti);

                    System.out.println("Alunos:");
                    var alunos = alunoService.listar();
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.printf("%d) %s\n", i + 1, alunos.get(i));
                    }
                    System.out.print("Escolha aluno (número): ");
                    int ai = Integer.parseInt(sc.nextLine()) - 1;
                    Aluno aluno = alunos.get(ai);

                    turma.adicionarAluno(aluno);
                    System.out.println("Aluno matriculado na turma.");
                }
                case "6" -> {
                    System.out.println("Alunos:");
                    var alunos = alunoService.listar();
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.printf("%d) %s\n", i + 1, alunos.get(i));
                    }
                    System.out.print("Escolha aluno (número): ");
                    int ai = Integer.parseInt(sc.nextLine()) - 1;
                    Aluno aluno = alunos.get(ai);

                    System.out.print("Descrição da avaliação: ");
                    String desc = sc.nextLine();
                    Avaliacao av = new Avaliacao(desc);
                    System.out.print("Nota (0-10): ");
                    double nota = Double.parseDouble(sc.nextLine());
                    boolean ok = av.atribuirNota(nota);
                    if (!ok) {
                        System.out.println("Nota inválida. Deve ser entre 0 e 10.");
                    } else {
                        aluno.adicionarAvaliacao(av);
                        System.out.println("Avaliação registrada.");
                    }
                }
                case "7" -> {
                    System.out.println("Relatórios:");
                    System.out.println("1) Alunos");
                    System.out.println("2) Professores");
                    System.out.println("3) Cursos");
                    System.out.print("Escolha: ");
                    String r = sc.nextLine();
                    if (r.equals("1")) {
                        for (Aluno al : alunoService.listar()) {
                            System.out.println(al.gerarRelatorio());
                        }
                    } else if (r.equals("2")) {
                        for (Professor pr : profService.listar()) {
                            System.out.println(pr.gerarRelatorio());
                        }
                    } else if (r.equals("3")) {
                        for (Curso cu : cursoService.listar()) {
                            System.out.println(cu.detalharCurso());
                        }
                    }
                }
                case "0" -> sair = true;
                default -> System.out.println("Opção inválida.");
            }
        }

        System.out.println("Encerrando sistema.");
    }
}
