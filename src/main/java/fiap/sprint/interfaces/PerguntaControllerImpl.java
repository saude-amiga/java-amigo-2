package fiap.sprint.interfaces;

import fiap.sprint.domain.model.Pergunta;
import fiap.sprint.domain.service.PerguntaService;
import fiap.sprint.domain.service.UsuarioService;

import java.util.ArrayList;
import java.util.Date;

public class PerguntaControllerImpl implements PerguntaController {

    private final PerguntaService perguntaService;
    private final UsuarioService usuarioService;
    public PerguntaControllerImpl(PerguntaService perguntaService, UsuarioService usuarioService) {
        this.perguntaService = perguntaService;
        this.usuarioService = usuarioService;
    }

    @Override
    public Pergunta criarPergunta(String titulo, String autor, String assunto, String email, String celular) {
        return perguntaService.criarPergunta(titulo, autor, assunto, email, celular);
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

    @Override
    public String getUsuarioById(int id) {
        return usuarioService.getUsuarioNameById(id).getName();
    }
}
