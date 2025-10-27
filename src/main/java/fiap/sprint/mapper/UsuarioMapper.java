package fiap.sprint.mapper;

import fiap.sprint.domain.model.Usuario;
import fiap.sprint.dto.input.UsuarioInputDto;
import fiap.sprint.dto.output.UsuarioOutputDto;

public class UsuarioMapper {
    public static UsuarioOutputDto toDto(Usuario usuarioCriado) {
        return new UsuarioOutputDto(
                usuarioCriado.getUserId(),
                usuarioCriado.getName(),
                usuarioCriado.getEmail(),
                usuarioCriado.getSenha()
        );
    }

    public static Usuario toModel(UsuarioInputDto dto) {
        return new Usuario(
                dto.getUserId(),
                dto.getName(),
                dto.getEmail(),
                dto.getSenha()
        );
    }
}
