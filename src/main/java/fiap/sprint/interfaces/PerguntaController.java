package fiap.sprint.interfaces;

import fiap.sprint.domain.model.Pergunta;

import java.util.ArrayList;
import java.util.Date;

public interface PerguntaController {
    Pergunta criarPergunta(String titulo, int autor, Date data);
    Pergunta responderPergunta(int id, String resposta, int autor, boolean isFuncionario);
    void deletarPergunta(int id);
    ArrayList<Pergunta> listarPerguntas();
}
