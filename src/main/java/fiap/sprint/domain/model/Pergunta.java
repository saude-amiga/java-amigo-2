package fiap.sprint.domain.model;

import java.util.Date;

public class Pergunta{

    private String titulo;
    private String corpo;
    private int autorDaPergunta;
    private int autorDaReposta;
    private Date data;

    public Pergunta(String titulo, int autor, Date data) {
        this.titulo = titulo;
        this.autorDaPergunta = autor;
        this.data = data;
    }

    public void responderPergunta(int idAutor, String resposta) {
        setAutorDaReposta(idAutor);
        setResposta(resposta);
    }

    private void setAutorDaReposta(int idAutor){
        this.autorDaReposta = idAutor;
    }

    private void setResposta(String resposta){
        this.corpo = resposta;
    }
}