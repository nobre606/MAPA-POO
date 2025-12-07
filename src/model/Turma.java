package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Fase 2 - relacionamentos entre professor, curso e alunos
 */
public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos = new ArrayList<>();

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
    }

    public String getCodigo() {
        return codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void adicionarAluno(Aluno a) {
        if (!listaAlunos.contains(a)) {
            listaAlunos.add(a);
        }
    }

    public void removerAluno(Aluno a) {
        listaAlunos.remove(a);
    }

    public String resumoTurma() {
        return String.format("Turma %s | Curso: %s | Professor: %s | Alunos: %d",
                codigo, curso.getNome(), professor.getNome(), listaAlunos.size());
    }

    @Override
    public String toString() {
        return resumoTurma();
    }
}
