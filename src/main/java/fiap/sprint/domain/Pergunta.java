import java.util.Date;

public class Pergunta{

    private String titulo;
    private String corpo;
    private int idNoticia;
    private String autor;
    private Date data;

    public Pergunta(int idNoticia, String titulo, String corpo, String autor, Date data) {
        this.titulo = titulo;
        this.corpo = corpo;
        this.idNoticia = idNoticia;
        this.autor = autor;
        this.data = data;
    }

}