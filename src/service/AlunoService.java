package service;

import model.Aluno;
import repository.AlunoRepository;
import java.util.List;
import java.util.Optional;

public class AlunoService {
    private final AlunoRepository repo;

    public AlunoService(AlunoRepository repo) {
        this.repo = repo;
    }

    public void cadastrar(Aluno a) {
        repo.salvar(a);
    }

    public Optional<Aluno> buscarPorMatricula(String m) {
        return repo.buscarPorMatricula(m);
    }

    public List<Aluno> listar() {
        return repo.listar();
    }
}
