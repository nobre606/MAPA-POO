package service;

import model.Professor;
import repository.ProfessorRepository;
import java.util.List;
import java.util.Optional;

public class ProfessorService {
    private final ProfessorRepository repo;

    public ProfessorService(ProfessorRepository repo) {
        this.repo = repo;
    }

    public void cadastrar(Professor p) {
        repo.salvar(p);
    }

    public Optional<Professor> buscarPorRegistro(String r) {
        return repo.buscarPorRegistro(r);
    }

    public List<Professor> listar() {
        return repo.listar();
    }
}
