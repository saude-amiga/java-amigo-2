package fiap.sprint.interfaces;

import fiap.sprint.domain.model.Acesso;

import java.util.ArrayList;

public interface AcessoController {

    Acesso createAcesso(int paginaId);

    void deletarAcesso(int idAcesso);

    Acesso editarAcesso(int idAcesso, Acesso acesso);

    ArrayList<Acesso> listarAcessos();
}
