package fiap.sprint.infrastructure.api.rest;

import fiap.sprint.domain.model.Pergunta;
import fiap.sprint.dto.input.PerguntaInputDto;
import fiap.sprint.dto.input.RespostaInputDto;
import fiap.sprint.dto.output.PerguntaOutputDto;
import fiap.sprint.interfaces.PerguntaController;
import fiap.sprint.mapper.PerguntaMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/pergunta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerguntaRestController {

    private final PerguntaController perguntaController;
    public PerguntaRestController(PerguntaController perguntaController){
        this.perguntaController = perguntaController;
    }

    @POST
    public Response create(PerguntaInputDto dto) {
        try {
            Pergunta perguntaCriado = perguntaController.criarPergunta(dto.getTitulo(), dto.getAutorDaPergunta(),
                    dto.getAssunto(), dto.getEmail(), dto.getCelular());
            PerguntaOutputDto perguntaSaida = PerguntaMapper.toDto(perguntaCriado, null);
            return Response.status(Response.Status.CREATED).entity(perguntaSaida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, RespostaInputDto dto) {
        try {
            Pergunta perguntaEditado = perguntaController.responderPergunta(id, dto.getCorpo(), dto.getAutorDaReposta());
            PerguntaOutputDto perguntaSaida = PerguntaMapper.toDto(perguntaEditado, null);
            return Response.ok(perguntaSaida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            perguntaController.deletarPergunta(id);
            return Response.noContent().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    public Response listAll() {
        try {
            List<Pergunta> perguntaList = perguntaController.listarPerguntas();
            List<PerguntaOutputDto> perguntaSaida = new ArrayList<>();
            for (Pergunta pergunta : perguntaList) {
                String nomeAutor = perguntaController.getUsuarioById(pergunta.getAutorDaReposta());
                perguntaSaida.add(PerguntaMapper.toDto(pergunta, nomeAutor));
            }
            return Response.ok(perguntaSaida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
