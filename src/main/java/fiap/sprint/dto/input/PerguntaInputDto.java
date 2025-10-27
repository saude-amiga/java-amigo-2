package fiap.sprint.dto.input;

import java.util.Date;

public class PerguntaInputDto{

    private int id;
    private String titulo;
    private int autorDaPergunta;
    private Date data;

    public PerguntaInputDto(String titulo, int autor, Date data) {
        this.titulo = titulo;
        this.autorDaPergunta = autor;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAutorDaPergunta() {
        return autorDaPergunta;
    }

    public void setAutorDaPergunta(int autorDaPergunta) {
        this.autorDaPergunta = autorDaPergunta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}