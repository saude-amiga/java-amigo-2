package fiap.sprint.interfaces;

import fiap.sprint.domain.model.Acesso;
import fiap.sprint.domain.model.Agendamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface AgendamentoController {

    Agendamento createAgendamento(String descricao, int pacienteId);

    void deletarAgendamento(int id);

    ArrayList<Agendamento> listarAgendamento();

    void confirmarAgendamento(int idAgendamento);

    List<Agendamento> listarAgendamentosPorUsuario(int userId);
}
