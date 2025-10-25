package fiap.sprint.mapper;

import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.dto.input.AgendamentoInputDto;
import fiap.sprint.dto.output.AgendamentoOutputDto;

public class AgendamentoMapper {
    public static AgendamentoOutputDto toDto(Agendamento agendamentoCriado) {
        return new AgendamentoOutputDto(
                agendamentoCriado.getId(),
                agendamentoCriado.getData(),
                agendamentoCriado.getDescricao(),
                agendamentoCriado.getPacienteId(),
                agendamentoCriado.isConfirmado());
    }

    public static Agendamento toModel(AgendamentoInputDto dto) {
        return new Agendamento(
                dto.getId(),
                dto.getData(),
                dto.getDescricao(),
                dto.getPacienteId(),
                dto.isConfirmado()
        );
    }
}
