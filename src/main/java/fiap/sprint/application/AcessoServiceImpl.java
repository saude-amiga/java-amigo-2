package fiap.sprint.application;

import fiap.sprint.domain.repository.AcessoRepository;
import fiap.sprint.domain.repository.HistoricoRepository;
import fiap.sprint.domain.service.AcessoService;

public class AcessoServiceImpl implements AcessoService {

    private final AcessoRepository acessoRepository;

    public AcessoServiceImpl(AcessoRepository acessoRepository) {
        this.acessoRepository = acessoRepository;
    }
}
