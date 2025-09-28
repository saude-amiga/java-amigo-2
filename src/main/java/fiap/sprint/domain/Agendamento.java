package fiap.sprint.domain;

import java.util.Date;

public class Agendamento {
    
    private int id;
    private Date data;
    private String descricao;

    public Agendamento(int id, String descricao, Date data) {
            this.id = id;
            this.data = data;
            this.descricao = descricao;
    }
     
}
