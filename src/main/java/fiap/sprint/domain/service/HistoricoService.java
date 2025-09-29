package fiap.sprint.domain.service;

import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.domain.model.Historico;

public interface HistoricoService {
    Historico addAgendamento(Agendamento agendamento);
}
