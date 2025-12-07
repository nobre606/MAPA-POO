package repository;

import model.Professor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfessorRepository {
    private final List<Professor> professores = new ArrayList<>();

    public void salvar(Professor p) {
        professores.add(p);
    }

    public Optional<Professor> buscarPorRegistro(String registro) {
        return professores.stream().filter(p -> p.getRegistro().equals(registro)).findFirst();
    }

    public List<Professor> listar() {
        return new ArrayList<>(professores);
    }
}
