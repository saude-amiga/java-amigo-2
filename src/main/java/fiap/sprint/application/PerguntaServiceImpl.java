package fiap.sprint.application;

import fiap.sprint.domain.model.Pergunta;
import fiap.sprint.domain.repository.PerguntaRepository;
import fiap.sprint.domain.service.PerguntaService;
import fiap.sprint.infrastructure.exceptions.PerguntaException;

import java.util.ArrayList;
import java.util.Date;

public class PerguntaServiceImpl implements PerguntaService {

    private final PerguntaRepository perguntaRepository;

    public PerguntaServiceImpl(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    @Override
    public Pergunta criarPergunta(String titulo, String autor, String assunto, String email, String celular) {
        return perguntaRepository.criarPergunta( titulo,  autor,  new Date(), assunto, email, celular);
    }

    @Override
    public Pergunta responderPergunta(int id, String resposta, int autor) {
        return perguntaRepository.responderPergunta(id, resposta, autor);
    }

    @Override
    public void deletarPergunta(int id) {
        perguntaRepository.deletarPergunta(id);
    }

    @Override
    public ArrayList<Pergunta> listarPerguntas() {
        return perguntaRepository.listarPerguntas();
    }
}
