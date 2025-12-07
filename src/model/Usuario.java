package model;

/**
 * Classe abstrata que reúne atributos comuns a todos os usuários do sistema.
 * Fase 5 - Abstração
 */
public abstract class Usuario {
    protected String nome;
    protected String login;
    protected String senha;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    // Não expor getSenha publicamente por segurança
    protected String getSenhaPrivada() {
        return senha;
    }

    // Relatório polimórfico: cada tipo pode sobrescrever
    public abstract String gerarRelatorio();
}
