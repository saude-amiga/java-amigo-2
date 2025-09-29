package fiap.sprint.application;

import fiap.sprint.domain.repository.HistoricoRepository;
import fiap.sprint.domain.service.HistoricoService;

public class HistoricoServiceImpl implements HistoricoService {

    private final HistoricoRepository historicoRepository;

    public HistoricoServiceImpl(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }
}
