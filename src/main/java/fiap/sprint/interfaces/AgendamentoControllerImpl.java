package fiap.sprint.interfaces;

import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.domain.service.AgendamentoService;

import java.util.ArrayList;

public class AgendamentoControllerImpl implements AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoControllerImpl(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @Override
    public Agendamento createAgendamento(String descricao) {
        return agendamentoService.criarAgendamento(descricao);
    }

    @Override
    public void deletarAgendamento(int id) {
        agendamentoService.deletarAgendamento(id);
    }

    @Override
    public Agendamento editarAgendamento(int idAgendamento, Agendamento agendamento) {
        return agendamentoService.editarAgendamento(idAgendamento, agendamento);
    }

    @Override
    public ArrayList<Agendamento> listarAgendamento() {
        return agendamentoService.listarAgendamentos();
    }
}
