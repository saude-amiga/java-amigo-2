package fiap.sprint.domain.service;

import fiap.sprint.domain.model.Agendamento;

import java.util.ArrayList;
import java.util.Date;

public interface AgendamentoService {
    Agendamento getAgendamento(int id);
    Agendamento editarAgendamento(int idAgendamento, Agendamento agendamento);
    Agendamento criarAgendamento(String descricao, int pacienteId);
    ArrayList<Agendamento> listarAgendamentos();
    void deletarAgendamento(int idAgendamento);
    void confirmarAgendamento(int idAgendamento, Date data);
}
