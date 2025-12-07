package model;

public class Administrador extends Usuario implements Autenticacao {
    public Administrador(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.getSenhaPrivada().equals(senha);
    }

    @Override
    public String gerarRelatorio() {
        return "Administrador: " + nome;
    }
}
