package model;

/**
 * Fase 3 - encapsulamento das notas
 */
public class Avaliacao {
    private double nota; // 0..10
    private String descricao;

    public Avaliacao(String descricao) {
        this.descricao = descricao;
        this.nota = -1; // não atribuída
    }

    // Atualização controlada da nota (apenas por este método)
    public boolean atribuirNota(double valor) {
        if (valor < 0 || valor > 10) {
            return false;
        }
        this.nota = valor;
        return true;
    }

    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        if (nota < 0) return descricao + " [sem nota]";
        return descricao + " - " + nota;
    }
}
