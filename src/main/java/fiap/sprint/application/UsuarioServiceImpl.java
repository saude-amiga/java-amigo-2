package fiap.sprint.application;

import fiap.sprint.application.exceptions.CredencialException;
import fiap.sprint.domain.model.Acesso;
import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.domain.model.Pergunta;
import fiap.sprint.domain.model.Usuario;
import fiap.sprint.domain.repository.AcessoRepository;
import fiap.sprint.domain.repository.AgendamentoRepository;
import fiap.sprint.domain.repository.PerguntaRepository;
import fiap.sprint.domain.repository.UsuarioRepository;
import fiap.sprint.domain.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PerguntaRepository perguntaRepository;
    private final AgendamentoRepository agendamentoRepository;
    private final AcessoRepository acessoRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PerguntaRepository perguntaRepository,
                              AgendamentoRepository agendamentoRepository, AcessoRepository acessoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perguntaRepository = perguntaRepository;
        this.agendamentoRepository = agendamentoRepository;
        this.acessoRepository = acessoRepository;
    }

    @Override
    public Usuario criarUsuario(String nome, String email, String senha, boolean funcionario)  {
        return usuarioRepository.criarUsuario(nome, email, senha, funcionario);
    }

    @Override
    public Usuario alterarNome(int id, String nome) {
        return usuarioRepository.alterarNome(id,nome);
    }

    @Override
    public Usuario alterarEmail(String email) {
        return null;
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        return (ArrayList<Usuario>) usuarioRepository.listarUsuarios();
    }

    @Override
    public void deletarUsuario(int id) {
        //TODO: Deveria otimizar isso no futuro
        for (Agendamento agendamento : agendamentoRepository.listarAgendamentos()){
            if(agendamento.getPacienteId() == id){
                agendamentoRepository.deletarAgendamento(id);
            }
        }
        for (Acesso acesso : acessoRepository.listarAcesso()){
            if(acesso.getId() == id){
                acessoRepository.deletarAcesso(id);
            }
        }
        usuarioRepository.deletarUsuario(id);
    }

    @Override
    public Usuario login(String email, String senha) {
        if (loginExiste(email, senha)){
            return usuarioRepository.getUsuarioByEmail(email);
        }
        throw new CredencialException("Login incorreto!");
    }

    @Override
    String getUsuarioById(int id){
        List<Usuario> usuarioList = listarUsuarios();
        for(Usuario usuario : usuarioList){
            if(usuario.getUserId() == id){
                return usuario.getName();
            }
        }
        return "Usuário não identificado";
    }

    private boolean loginExiste(String email, String senha){
        ArrayList<Usuario> listaUsuario = this.listarUsuarios();
        for(Usuario usuario: listaUsuario){
            if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }

}
