package repository;

import model.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoRepository {
    private final List<Curso> cursos = new ArrayList<>();

    public void salvar(Curso c) {
        cursos.add(c);
    }

    public Optional<Curso> buscarPorCodigo(String codigo) {
        return cursos.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst();
    }

    public List<Curso> listar() {
        return new ArrayList<>(cursos);
    }
}
