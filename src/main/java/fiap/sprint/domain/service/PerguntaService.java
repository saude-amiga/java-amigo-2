package fiap.sprint.domain.service;

import fiap.sprint.domain.model.Pergunta;

import java.util.Date;

public interface PerguntaService {
    Pergunta criarPergunta(String titulo, int autor,  Date data);
    Pergunta responderPergunta(Pergunta pergunta);
}
