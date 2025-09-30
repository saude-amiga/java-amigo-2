package fiap.sprint.application;

import fiap.sprint.domain.repository.AcessoRepository;
import fiap.sprint.domain.repository.HistoricoRepository;
import fiap.sprint.domain.service.HistoricoService;

public class HistoricoServiceImpl implements HistoricoService {

    private final AcessoRepository acessoRepository;

    public HistoricoServiceImpl(AcessoRepository acessoRepository) {
        this.acessoRepository = acessoRepository;
    }
}
