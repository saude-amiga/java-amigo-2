package fiap.sprint.domain.service;

import fiap.sprint.domain.model.Usuario;

public interface UsuarioService {
    Usuario criarUsuario();
    Usuario alterarNome(String nome);
    Usuario alterarEmail(String email);
}
