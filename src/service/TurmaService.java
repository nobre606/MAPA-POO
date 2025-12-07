package service;

import model.Turma;
import repository.TurmaRepository;
import java.util.List;
import java.util.Optional;

public class TurmaService {
    private final TurmaRepository repo;

    public TurmaService(TurmaRepository repo) {
        this.repo = repo;
    }

    public void cadastrar(Turma t) {
        repo.salvar(t);
        t.getProfessor().adicionarTurma(t);
    }

    public Optional<Turma> buscarPorCodigo(String c) {
        return repo.buscarPorCodigo(c);
    }

    public List<Turma> listar() {
        return repo.listar();
    }
}
