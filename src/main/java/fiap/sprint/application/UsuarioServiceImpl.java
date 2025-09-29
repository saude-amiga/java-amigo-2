package fiap.sprint.application;

import fiap.sprint.domain.repository.UsuarioRepository;
import fiap.sprint.domain.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
