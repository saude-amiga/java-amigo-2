package fiap.sprint.domain.repository;

import fiap.sprint.domain.model.Agendamento;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;

public interface AgendamentoRepository{
    void confirmarAgendamento(int agendamentoId, Date data);
    Agendamento criarAgendamento(Date data, String conteudo, int pacienteId);

    Agendamento getAgendamento(int id);

    ArrayList<Agendamento> listarAgendamentos();

    void deletarAgendamento(int idAgendamento);
}
