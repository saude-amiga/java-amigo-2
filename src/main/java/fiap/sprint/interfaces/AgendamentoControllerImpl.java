package fiap.sprint.interfaces;

import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.domain.service.AgendamentoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgendamentoControllerImpl implements AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoControllerImpl(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @Override
    public Agendamento createAgendamento(String descricao, int pacienteId) {

        return agendamentoService.criarAgendamento(descricao, pacienteId );
    }

    @Override
    public void deletarAgendamento(int id) {
        agendamentoService.deletarAgendamento(id);
    }

    @Override
    public ArrayList<Agendamento> listarAgendamento() {
        return agendamentoService.listarAgendamentos();
    }

    @Override
    public void confirmarAgendamento(int idAgendamento) {
        agendamentoService.confirmarAgendamento(idAgendamento);
    }

    @Override
    public List<Agendamento> listarAgendamentosPorUsuario(int userId) {
        return agendamentoService.listarAgendamentosPorUsuario(userId);
    }
}
