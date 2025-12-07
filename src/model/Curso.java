package model;

/**
 * Fase 1 e Fase 4 (será estendido)
 */
public class Curso {
    protected String nome;
    protected String codigo;
    protected int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String detalharCurso() {
        return String.format("Curso: %s (%s) - %d h", nome, codigo, cargaHoraria);
    }

    @Override
    public String toString() {
        return nome + " (" + codigo + ")";
    }
}
