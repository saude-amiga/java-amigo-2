package fiap.sprint.mapper;

import fiap.sprint.domain.model.Pergunta;
import fiap.sprint.dto.input.PerguntaInputDto;
import fiap.sprint.dto.output.PerguntaOutputDto;

public class PerguntaMapper {
    public static PerguntaOutputDto toDto(Pergunta perguntaCriado) {
        return new PerguntaOutputDto(
                perguntaCriado.getId(),
                perguntaCriado.getTitulo(),
                perguntaCriado.getCorpo(),
                perguntaCriado.getAutorDaPergunta(),
                perguntaCriado.getAutorDaReposta(),
                perguntaCriado.getData()
        );
    }

}
