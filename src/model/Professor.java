package model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario implements Autenticacao {
    private String registro;
    private String especialidade;
    private List<Turma> turmas = new ArrayList<>();

    public Professor(String nome, String especialidade, String registro, String login, String senha) {
        super(nome, login, senha);
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public String getRegistro() {
        return registro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void adicionarTurma(Turma t) {
        turmas.add(t);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.getSenhaPrivada().equals(senha);
    }

    @Override
    public String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("Professor: ").append(nome).append(" | Registro: ").append(registro).append("\n");
        sb.append("Especialidade: ").append(especialidade).append("\n");
        sb.append("Turmas: ").append(turmas.size()).append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return nome + " (" + registro + ")";
    }
}
