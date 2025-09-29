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
     
}
