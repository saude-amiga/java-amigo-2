package fiap.sprint.domain.repository;

import fiap.sprint.domain.model.Acesso;

import java.util.ArrayList;

public interface AcessoRepository {
    Acesso criarAcesso(Acesso acesso);

    Acesso editarAcesso(Acesso acesso, int idPagina);

    void deletarAcesso(int id);

    ArrayList<Acesso> listarAcesso();
}
