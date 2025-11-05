package fiap.sprint.infrastructure.api.rest;

import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.dto.input.AgendamentoInputDto;
import fiap.sprint.dto.output.AgendamentoOutputDto;
import fiap.sprint.interfaces.AgendamentoController;
import fiap.sprint.mapper.AgendamentoMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/agendamento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgendamentoRestController {
    private final AgendamentoController agendamentoController;

    public AgendamentoRestController(AgendamentoController agendamentoController){
        this.agendamentoController = agendamentoController;
    }

    @POST
    public Response create(AgendamentoInputDto dto) {
        try {
            Agendamento agendamentoCriado = agendamentoController.createAgendamento(dto.getDescricao(), dto.getPacienteId(), dto.getData());
            AgendamentoOutputDto agendamentoSaida = AgendamentoMapper.toDto(agendamentoCriado);
            return Response.status(Response.Status.CREATED).entity(agendamentoSaida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/confirmar/{id}")
    public Response confirmarAgendamento(@PathParam("id") int id) {
        try {
            agendamentoController.confirmarAgendamento(id);
            return Response.noContent().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            agendamentoController.deletarAgendamento(id);
            return Response.noContent().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{userid}")
    public Response listarAgendamentosPorUsuario(@PathParam("userId") int userId) {
        try {
            List<Agendamento> agendamentoList = agendamentoController.listarAgendamentosPorUsuario(userId);
            List<AgendamentoOutputDto> agendamentoSaida = new ArrayList<>();
            for (Agendamento agendamento : agendamentoList) {
                agendamentoSaida.add(AgendamentoMapper.toDto(agendamento));
            }
            return Response.ok(agendamentoSaida).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
