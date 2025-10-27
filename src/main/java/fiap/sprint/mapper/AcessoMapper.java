package fiap.sprint.mapper;

import fiap.sprint.domain.model.Acesso;
import fiap.sprint.dto.input.AcessoInputDto;
import fiap.sprint.dto.output.AcessoOutputDto;

public class AcessoMapper {
    public static AcessoOutputDto toDto(Acesso acessoCriado) {
        return new AcessoOutputDto(acessoCriado.getId(), acessoCriado.getDataAcesso(),
                acessoCriado.getIdPagina(), acessoCriado.getIdUsuario());
    }

    public static Acesso toModel(AcessoInputDto dto) {
        return new Acesso(dto.getId(), dto.getDataAcesso(),
                dto.getIdPagina(), dto.getIdUsuario());
    }
}
