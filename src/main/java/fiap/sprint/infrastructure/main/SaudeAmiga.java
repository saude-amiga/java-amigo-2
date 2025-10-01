package fiap.sprint.infrastructure.main;

import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.domain.model.Usuario;
import fiap.sprint.infrastructure.exceptions.ListagemDeUsuarioException;
import fiap.sprint.infrastructure.exceptions.LoginException;
import fiap.sprint.interfaces.AcessoController;
import fiap.sprint.interfaces.AgendamentoController;
import fiap.sprint.interfaces.PerguntaController;
import fiap.sprint.interfaces.UsuarioController;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Date;

public class SaudeAmiga implements QuarkusApplication {

    @Inject
    UsuarioController usuarioController;

    @Inject
    AgendamentoController agendamentoController;

    @Inject
    AcessoController acessoController;

    @Inject
    PerguntaController perguntaController;

    private String DESCRICAO = "DESCRICAO";
    private String NOME = "NomeTeste";
    private String EMAIL = "teste@gmail.com";
    private String SENHA = "senha123";
    private Usuario usuarioatual = null;

    @Override
    public int run(String... args) {
        criarUsuario();
        return 0;
    }
    private void criarUsuario(){
        try {
            usuarioController.criarUsuario(NOME, EMAIL, SENHA);
        }catch (Exception e){
            System.out.println("Erro ao criar usuario");
        }
    }
    private void logar() {
        boolean usuarioExiste = false;
        try {
            usuarioExiste = usuarioController.loginExiste(EMAIL, SENHA);
        } catch (LoginException e) {
            throw new LoginException("Erro na validação do login");
        }
        if(usuarioExiste){
            try {
                ArrayList<Usuario> listarUsuarios = usuarioController.listarUsuarios();
                for(Usuario usuario:listarUsuarios){
                    if(usuario.getEmail().equals(EMAIL)){
                        usuarioatual = new Usuario(usuario.getUserId(), NOME, EMAIL, SENHA);
                    }
                }
            }catch (ListagemDeUsuarioException e){
                throw new ListagemDeUsuarioException("Erro na busca de usuários no banco");
            }
        }else{
            System.out.println("Usuário não existe");
        }
    }

    private void agendamentoDeConsultaPaciente() {
        agendamentoController.confirmarAgendamento(2, new Date());
    }

    private void criarAgendamentoDeConsultaAdmin(){
        agendamentoController.createAgendamento(DESCRICAO);
    }
}
