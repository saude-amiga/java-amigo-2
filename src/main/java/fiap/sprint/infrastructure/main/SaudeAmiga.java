package fiap.sprint.infrastructure.main;

import fiap.sprint.domain.model.Acesso;
import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.domain.model.Pergunta;
import fiap.sprint.domain.model.Usuario;
import fiap.sprint.infrastructure.exceptions.*;
import fiap.sprint.interfaces.AcessoController;
import fiap.sprint.interfaces.AgendamentoController;
import fiap.sprint.interfaces.PerguntaController;
import fiap.sprint.interfaces.UsuarioController;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.inject.Inject;
import java.util.UUID;
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
    private String descricao() {
        return "DESCRICAO_" + UUID.randomUUID();
    }

    private String nome() {
        return "Nome Teste " + UUID.randomUUID();
    }

    private String email() {
        return "user_" + UUID.randomUUID() + "@gmail.com";
    }

    private String senha() {
        return "senha_" + UUID.randomUUID();
    }
    private String DESCRICAO = descricao();
    private String NOME = nome();
    private String EMAIL =  email();
    private String SENHA = senha();
    private int paginaId = 123;
    private Usuario usuarioatual = null;

    @Override
    public int run(String... args) throws Exception {

        //funções principais do aplicativo
        criarUsuario();
        logar();
        criarAgendamentoDeConsultaAdmin();
        agendamentoDeConsultaPaciente();
        visualizarHistoricoDeAcessos();

        //funções de alteração geral (CRUD) dos modelos

        // ================== Acesso ==================
        // Create
        try {
            acessoController.createAcesso(paginaId, usuarioatual.getUserId());
        } catch (AcessoException e) {
            System.err.println("Erro ao criar Acesso: " + e.getMessage());
        }

        // Read
        ArrayList<Acesso> listarAcessos = null;
        try {
            listarAcessos = acessoController.listarAcessos();
        } catch (AcessoException e) {
            System.err.println("Erro ao listar Acessos: " + e.getMessage());
        }

        // Update
        try {
            if (listarAcessos != null && !listarAcessos.isEmpty()) {
                acessoController.atualizarAcesso(123, listarAcessos.get(0));
            }
        } catch (AcessoException e) {
            System.err.println("Erro ao atualizar Acesso: " + e.getMessage());
        }

        // Delete
        try {
            if (listarAcessos != null && !listarAcessos.isEmpty()) {
                acessoController.deletarAcesso(listarAcessos.get(0).getId());
            }
        } catch (AcessoException e) {
            System.err.println("Erro ao deletar Acesso: " + e.getMessage());
        }



        // ================== Agendamento ==================
        // Read
        ArrayList<Agendamento> listarAgendamento = null;
        try {
            listarAgendamento = agendamentoController.listarAgendamento();
        } catch (AgendamentoException e) {
            System.err.println("Erro ao listar Agendamentos: " + e.getMessage());
        }

        // Delete
        try {
            if (listarAgendamento != null && !listarAgendamento.isEmpty()) {
                agendamentoController.deletarAgendamento(listarAgendamento.get(0).getId());
            }
        } catch (AgendamentoException e) {
            System.err.println("Erro ao deletar Agendamento: " + e.getMessage());
        }



        // ================== Pergunta ==================
        // Create
        try {
            perguntaController.criarPergunta("Como abrir a tela de chamada", usuarioatual.getUserId(), new Date());
        } catch (PerguntaException e) {
            System.err.println("Erro ao criar Pergunta: " + e.getMessage());
        }

        // Read
        ArrayList<Pergunta> perguntas = null;
        try {
            perguntas = perguntaController.listarPerguntas();
        } catch (PerguntaException e) {
            System.err.println("Erro ao listar Perguntas: " + e.getMessage());
        }

        // Update
        try {
            if (perguntas != null && !perguntas.isEmpty()) {
                perguntaController.responderPergunta(
                        perguntas.get(0).getId(),
                        "Instruções para abrir a aplicação.",
                        usuarioatual.getUserId()
                );
            }
        } catch (PerguntaException e) {
            System.err.println("Erro ao responder Pergunta: " + e.getMessage());
        }

        // Delete
        try {
            if (perguntas != null && !perguntas.isEmpty()) {
                perguntaController.deletarPergunta(perguntas.get(0).getId());
            }
        } catch (PerguntaException e) {
            System.err.println("Erro ao deletar Pergunta: " + e.getMessage());
        }



        // ================== Usuario ==================
        // Read
        ArrayList<Usuario> listarUsuarios = null;
        try {
            listarUsuarios = usuarioController.listarUsuarios();
        } catch (ListagemDeUsuarioException e) {
            System.err.println("Erro ao listar Usuários: " + e.getMessage());
        }

        // Update
        try {
            usuarioController.alterarEmail(EMAIL + ".emailmudaddo.br");
        } catch (LoginException e) {
            System.err.println("Erro ao alterar e-mail do Usuário: " + e.getMessage());
        }

        // Delete
        try {
            if (listarUsuarios != null && !listarUsuarios.isEmpty()) {
                usuarioController.deletarUsuario(listarUsuarios.get(0).getUserId());
            }
        } catch (ListagemDeUsuarioException e) {
            System.err.println("Erro ao deletar Usuário: " + e.getMessage());
        }



            return 0;

    }

        private void visualizarHistoricoDeAcessos() {
        try{

        }catch(AcessoException e){
            throw new AcessoException(e.getMessage());
        }
    }

    private void criarUsuario() throws Exception {
        try {
            usuarioController.criarUsuario(NOME, EMAIL, SENHA);
        }catch (Exception e){
            throw new Exception(e.getMessage());
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
        try {
            int agendamentoId = agendamentoController.listarAgendamento().get(0).getId();
            agendamentoController.confirmarAgendamento(agendamentoId, new Date());
        }catch(AgendamentoException e){
            throw new AgendamentoException("Erro na confirmação do agendamento");
        }
    }

    private void criarAgendamentoDeConsultaAdmin(){
        try {
            agendamentoController.createAgendamento(DESCRICAO, usuarioatual.getUserId());
        }catch (AgendamentoException e){
            throw new AgendamentoException("Erro na criação do agendamento");
        }
    }
}
