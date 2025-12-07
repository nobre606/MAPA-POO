package repository;

import model.Turma;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TurmaRepository {
    private final List<Turma> turmas = new ArrayList<>();

    public void salvar(Turma t) {
        turmas.add(t);
    }

    public Optional<Turma> buscarPorCodigo(String codigo) {
        return turmas.stream().filter(t -> t.getCodigo().equals(codigo)).findFirst();
    }

    public List<Turma> listar() {
        return new ArrayList<>(turmas);
    }
}
