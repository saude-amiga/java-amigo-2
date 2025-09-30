package fiap.sprint.application;

import fiap.sprint.domain.model.Acesso;
import fiap.sprint.domain.repository.AcessoRepository;
import fiap.sprint.domain.service.AcessoService;

import java.util.ArrayList;

public class AcessoServiceImpl implements AcessoService {

    private final AcessoRepository acessoRepository;

    public AcessoServiceImpl(AcessoRepository acessoRepository) {
        this.acessoRepository = acessoRepository;
    }

    @Override
    public Acesso criarAcesso(int idPagina) {
        return null;
    }

    @Override
    public Acesso editarAcesso(int idAcesso, Acesso acesso) {
        return null;
    }

    @Override
    public void deletarAcesso(int idAcesso) {

    }

    @Override
    public ArrayList<Acesso> listarAcessos() {
        return null;
    }
}
