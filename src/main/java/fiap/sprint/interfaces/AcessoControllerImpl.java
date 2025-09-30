package fiap.sprint.interfaces;

import fiap.sprint.domain.model.Acesso;
import fiap.sprint.domain.service.AcessoService;

import java.util.ArrayList;

public class AcessoControllerImpl implements AcessoController {

    private final AcessoService acessoService;

    public AcessoControllerImpl(AcessoService acessoService) {
        this.acessoService = acessoService;
    }

    @Override
    public Acesso createAcesso(int paginaId) {
        return acessoService.criarAcesso(paginaId);
    }

    @Override
    public void deletarAcesso(int idAcesso) {
        acessoService.deletarAcesso(idAcesso);
    }

    @Override
    public Acesso editarAcesso(int idAcesso, Acesso acesso) {
        return acessoService.editarAcesso(idAcesso, acesso);
    }

    @Override
    public ArrayList<Acesso> listarAcessos() {
        return acessoService.listarAcessos();
    }
}
