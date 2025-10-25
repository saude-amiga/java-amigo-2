package fiap.sprint.mapper;

import fiap.sprint.domain.model.Acesso;
import fiap.sprint.dto.output.AcessoOutputDto;

public class AcessoMapper {
    public static AcessoOutputDto toDto(Acesso acessoCriado) {
        return new AcessoOutputDto(acessoCriado.getId(), acessoCriado.getDataAcesso(),
                acessoCriado.getIdPagina(), acessoCriado.getIdUsuario());
    }
}
