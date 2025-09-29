package fiap.sprint.application;

import fiap.sprint.domain.repository.PerguntaRepository;
import fiap.sprint.domain.service.PerguntaService;

public class PerguntaServiceImpl implements PerguntaService {

    private final PerguntaRepository perguntaRepository;

    public PerguntaServiceImpl(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }
}
