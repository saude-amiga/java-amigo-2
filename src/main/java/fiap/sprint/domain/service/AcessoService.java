package fiap.sprint.domain.service;

import fiap.sprint.domain.model.Acesso;

import java.util.ArrayList;

public interface AcessoService {
    Acesso criarAcesso(int idPagina);
    Acesso editarAcesso(int idAcesso,  Acesso acesso);
    void deletarAcesso(int idAcesso);
    ArrayList<Acesso> listarAcessos();
}
