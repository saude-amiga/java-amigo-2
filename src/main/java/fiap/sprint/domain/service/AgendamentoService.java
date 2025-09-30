package fiap.sprint.domain.service;

import fiap.sprint.domain.model.Agendamento;

import java.util.ArrayList;

public interface AgendamentoService {
    Agendamento editarAgendamento(int idAgendamento, Agendamento agendamento);
    Agendamento criarAgendamento(String descricao);
    ArrayList<Agendamento> listarAgendamentos();
    void deletarAgendamento(int idAgendamento);
}
