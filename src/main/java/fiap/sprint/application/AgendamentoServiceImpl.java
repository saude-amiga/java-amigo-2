package fiap.sprint.application;

import fiap.sprint.domain.repository.AgendamentoRepository;
import fiap.sprint.domain.service.AgendamentoService;

public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoServiceImpl(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }
}
