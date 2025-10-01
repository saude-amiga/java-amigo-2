package fiap.sprint.application;

import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.domain.repository.AgendamentoRepository;
import fiap.sprint.domain.service.AgendamentoService;

import java.util.ArrayList;
import java.util.Date;

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
        agendamentoRepository.criarAgendamento(descricao);
    }

    @Override
    public ArrayList<Agendamento> listarAgendamentos() {
        return null;
    }

    @Override
    public void deletarAgendamento(int idAgendamento) {

    }

    @Override
    public void confirmarAgendamento(int idAgendamento, Date data) {
        agendamentoRepository.confirmarAgendamento(idAgendamento, data);
    }
}
