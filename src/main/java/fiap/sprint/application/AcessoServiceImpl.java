package fiap.sprint.application;

import fiap.sprint.domain.repository.HistoricoRepository;
import fiap.sprint.domain.service.AcessoService;

public class AcessoServiceImpl implements AcessoService {

    private final HistoricoRepository historicoRepository;

    public AcessoServiceImpl(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }
}
