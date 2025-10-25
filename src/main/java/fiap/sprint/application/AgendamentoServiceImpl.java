package fiap.sprint.application;

import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.domain.repository.AgendamentoRepository;
import fiap.sprint.domain.service.AgendamentoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoServiceImpl(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Override
    public Agendamento getAgendamento(int id) {
        Agendamento agendamento = agendamentoRepository.getAgendamento(id);
        return agendamento;
    }

    @Override
    public Agendamento criarAgendamento(String descricao, int pacienteId) {
        return agendamentoRepository.criarAgendamento(new Date(), descricao, pacienteId);
    }

    @Override
    public ArrayList<Agendamento> listarAgendamentos() {
        return agendamentoRepository.listarAgendamentos();
    }


    @Override
    public void deletarAgendamento(int idAgendamento) {
        agendamentoRepository.deletarAgendamento(idAgendamento);
    }

    @Override
    public void confirmarAgendamento(int idAgendamento) {

        agendamentoRepository.confirmarAgendamento(idAgendamento);
    }

    @Override
    public List<Agendamento> listarAgendamentosPorUsuario(int userId) {
        return agendamentoRepository.listarAgendamentosPorUsuario(userId);
    }
}
