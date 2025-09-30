package fiap.sprint.domain.model;

import java.util.Date;

public class Agendamento {
    
    private int id;
    private Date data;
    private String descricao;
    private int pacienteId;
    
    public Agendamento(int id, String descricao, Date data, int pacienteId) {
            this.id = id;
            this.data = data;
            this.descricao = descricao;
            this.pacienteId = pacienteId;
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
