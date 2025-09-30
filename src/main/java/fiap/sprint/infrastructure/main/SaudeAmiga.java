package fiap.sprint.infrastructure.main;

import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.interfaces.AcessoController;
import fiap.sprint.interfaces.AgendamentoController;
import fiap.sprint.interfaces.PerguntaController;
import fiap.sprint.interfaces.UsuarioController;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.inject.Inject;

public class SaudeAmiga implements QuarkusApplication {

    @Inject
    UsuarioController usuarioController;

    @Inject
    AgendamentoController agendamentoController;

    @Inject
    AcessoController acessoController;

    @Inject
    PerguntaController perguntaController;



    @Override
    public int run(String... args) {
        criarUsuario();
        return 0;
    }
    private void criarUsuario(){
        try {
            usuarioController.criarUsuario("NomeTeste", "teste@gmail.com","senha123");
        }catch (Exception e){
            System.out.println("Erro ao criar usuario");
        }
    }
    private void logar(){

    }
}
