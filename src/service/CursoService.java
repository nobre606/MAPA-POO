package service;

import model.Curso;
import repository.CursoRepository;
import java.util.List;
import java.util.Optional;

public class CursoService {
    private final CursoRepository repo;

    public CursoService(CursoRepository repo) {
        this.repo = repo;
    }

    public void cadastrar(Curso c) {
        repo.salvar(c);
    }

    public Optional<Curso> buscarPorCodigo(String codigo) {
        return repo.buscarPorCodigo(codigo);
    }

    public List<Curso> listar() {
        return repo.listar();
    }
}
