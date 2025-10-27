package fiap.sprint.interfaces;

import fiap.sprint.domain.model.Pergunta;
import fiap.sprint.domain.service.PerguntaService;

import java.util.ArrayList;
import java.util.Date;

public class PerguntaControllerImpl implements PerguntaController {

    private final PerguntaService perguntaService;

    public PerguntaControllerImpl(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }

    @Override
    public Pergunta criarPergunta(String titulo, int autor) {
        return perguntaService.criarPergunta(titulo, autor);
    }

    @Override
    public Pergunta responderPergunta(int id, String resposta, int autor) {
        return perguntaService.responderPergunta(id, resposta, autor);
    }

    @Override
    public void deletarPergunta(int id) {
        perguntaService.deletarPergunta(id);
    }

    @Override
    public ArrayList<Pergunta> listarPerguntas() {
        return perguntaService.listarPerguntas();
    }
}
