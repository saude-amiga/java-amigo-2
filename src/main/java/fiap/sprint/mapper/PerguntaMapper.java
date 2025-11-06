package fiap.sprint.mapper;

import fiap.sprint.domain.model.Pergunta;
import fiap.sprint.domain.service.UsuarioService;
import fiap.sprint.dto.input.PerguntaInputDto;
import fiap.sprint.dto.output.PerguntaOutputDto;

public class PerguntaMapper {
    static UsuarioService usuarioService;
    public static PerguntaOutputDto toDto(Pergunta perguntaCriado) {
        PerguntaOutputDto perguntaOutputDto = new PerguntaOutputDto(
                perguntaCriado.getId(),
                perguntaCriado.getTitulo(),
                perguntaCriado.getCorpo(),
                perguntaCriado.getAutorDaPergunta(),
                perguntaCriado.getAutorDaReposta(),
                perguntaCriado.getData()
        );
        perguntaOutputDto.setNomeAutorResposta(usuarioService.getUsuarioById(perguntaOutputDto.getId()));
        return perguntaOutputDto;
    }

}
