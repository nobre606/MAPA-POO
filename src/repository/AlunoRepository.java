package repository;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoRepository {
    private final List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno a) {
        alunos.add(a);
    }

    public Optional<Aluno> buscarPorMatricula(String matricula) {
        return alunos.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst();
    }

    public List<Aluno> listar() {
        return new ArrayList<>(alunos);
    }
}
