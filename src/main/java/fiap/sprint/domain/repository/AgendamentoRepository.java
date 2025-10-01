package fiap.sprint.domain.repository;

import javax.xml.crypto.Data;
import java.util.Date;

public interface AgendamentoRepository{
    void confirmarAgendamento(int agendamentoId, Date data);
    void criarAgendamento(String conteudo);
}
