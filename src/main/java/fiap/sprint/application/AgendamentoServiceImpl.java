package fiap.sprint.application;

import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.domain.repository.AgendamentoRepository;
import fiap.sprint.domain.service.AgendamentoService;

import java.util.ArrayList;

public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoServiceImpl(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Override
    public Agendamento editarAgendamento(int idAgendamento, Agendamento agendamento) {
        return null;
    }

    @Override
    public Agendamento criarAgendamento(String descricao) {
        return null;
    }

    @Override
    public ArrayList<Agendamento> listarAgendamentos() {
        return null;
    }

    @Override
    public void deletarAgendamento(int idAgendamento) {

    }
}
