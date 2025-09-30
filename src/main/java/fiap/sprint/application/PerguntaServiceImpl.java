package fiap.sprint.application;

import fiap.sprint.domain.model.Pergunta;
import fiap.sprint.domain.repository.PerguntaRepository;
import fiap.sprint.domain.service.PerguntaService;

import java.util.ArrayList;
import java.util.Date;

public class PerguntaServiceImpl implements PerguntaService {

    private final PerguntaRepository perguntaRepository;

    public PerguntaServiceImpl(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    @Override
    public Pergunta criarPergunta(String titulo, int autor, Date data) {
        return null;
    }

    @Override
    public Pergunta responderPergunta(int id, String resposta, int autor) {
        return null;
    }

    @Override
    public void deletarPergunta(int id) {

    }

    @Override
    public ArrayList<Pergunta> listarPerguntas() {
        return null;
    }
}
