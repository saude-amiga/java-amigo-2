package fiap.sprint.application;

import fiap.sprint.domain.model.Acesso;
import fiap.sprint.domain.repository.AcessoRepository;
import fiap.sprint.domain.service.AcessoService;

import java.util.ArrayList;
import java.util.Date;

public class AcessoServiceImpl implements AcessoService {

    private final AcessoRepository acessoRepository;

    public AcessoServiceImpl(AcessoRepository acessoRepository) {
        this.acessoRepository = acessoRepository;
    }

    @Override
    public Acesso criarAcesso(int idPagina) {
        Acesso acesso = new Acesso(new Date(), idPagina);
        return acessoRepository.criarAcesso(acesso);
    }

    @Override
    public Acesso editarAcesso(int idPagina, Acesso acesso) {

        return acessoRepository.editarAcesso(acesso, idPagina);
    }

    @Override
    public void deletarAcesso(int idAcesso) {
        acessoRepository.deletarAcesso(idAcesso);
    }

    @Override
    public ArrayList<Acesso> listarAcessos() {
        return acessoRepository.listarAcesso();
    }
}
