package fiap.sprint.dto.output;

import java.util.Date;

public class AgendamentoOutputDto {
    
    private int id;
    private Date data;
    private String descricao;
    private int pacienteId;
    private boolean confirmado;

    public AgendamentoOutputDto(int id, String descricao, Date data, int pacienteId) {
            this.id = id;
            this.data = data;
            this.descricao = descricao;
            this.pacienteId = pacienteId;
            this.confirmado = false;
    }

    public AgendamentoOutputDto(Date data, String descricao, int pacienteId, boolean confirmado) {
        this.data = data;
        this.descricao = descricao;
        this.pacienteId = pacienteId;
        this.confirmado = confirmado;
    }

    public AgendamentoOutputDto() {

    }

    public AgendamentoOutputDto(int id, Date data, String descricao, int pacienteId, boolean isConfirmado) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.pacienteId = pacienteId;
        this.confirmado = isConfirmado;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }
}
