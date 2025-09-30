package fiap.sprint.interfaces;

import fiap.sprint.domain.model.Acesso;
import fiap.sprint.domain.model.Agendamento;

import java.util.ArrayList;

public interface AgendamentoController {

    Agendamento createAgendamento(String descricao);

    void deletarAgendamento(int id);

    Agendamento editarAgendamento(int idAgendamento, Agendamento agendamento);

    ArrayList<Agendamento> listarAgendamento();
}
