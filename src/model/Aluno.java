package model;

import java.util.ArrayList;
import java.util.List;

import model.Avaliacao;
import model.Curso;

/**
 * Fase 1 + 3 + 5 + 6
 */
public class Aluno extends Usuario implements Autenticacao {
    private String matricula;
    private Curso curso;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Aluno(String nome, String matricula, Curso curso, String login, String senha) {
        super(nome, login, senha);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void adicionarAvaliacao(Avaliacao a) {
        avaliacoes.add(a);
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.getSenhaPrivada().equals(senha);
    }

    @Override
    public String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aluno: ").append(nome).append(" | Matrícula: ").append(matricula).append("\n");
        sb.append("Curso: ").append(curso.getNome()).append("\n");
        sb.append("Avaliações:\n");
        for (Avaliacao a : avaliacoes) {
            sb.append(" - ").append(a).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return nome + " (" + matricula + ")";
    }
}
