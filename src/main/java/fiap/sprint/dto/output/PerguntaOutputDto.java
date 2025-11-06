package fiap.sprint.dto.output;

import java.util.Date;

public class PerguntaOutputDto{

    private int id;
    private String titulo;
    private String corpo;
    private String autorDaPergunta;
    private int autorDaRepostaId;
    private String nomeAutorResposta;
    private Date data;

    public String getNomeAutorResposta() {
        return nomeAutorResposta;
    }

    public void setNomeAutorResposta(String nomeAutorResposta) {
        this.nomeAutorResposta = nomeAutorResposta;
    }

    public PerguntaOutputDto(String titulo, String autor, Date data) {
        this.titulo = titulo;
        this.autorDaPergunta = autor;
        this.data = data;
    }

    public PerguntaOutputDto(int id, String titulo, String corpo, String autorPergunta, int autorResposta, Date data) {
        this.id = id;
        this.titulo = titulo;
        this.corpo = corpo;
        this.autorDaPergunta = autorPergunta;
        this.autorDaRepostaId = autorResposta;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public String getAutorDaPergunta() {
        return autorDaPergunta;
    }

    public int getAutorDaRepostaId() {
        return autorDaRepostaId;
    }

    public Date getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void responderPergunta(int idAutor, String resposta) {
        setAutorDaRepostaId(idAutor);
        setResposta(resposta);
    }

    private void setAutorDaRepostaId(int idAutor){
        this.autorDaRepostaId = idAutor;
    }

    private void setResposta(String resposta){
        this.corpo = resposta;
    }
}