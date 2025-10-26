package fiap.sprint.dto.input;

public class RespostaInputDto {
    private int id;
    private String corpo;
    private int autorDaReposta;

    public RespostaInputDto(int idPergunta, int idAutor, String resposta) {
        this.id = idPergunta;
        this.corpo = resposta;
        this.autorDaReposta = idAutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public int getAutorDaReposta() {
        return autorDaReposta;
    }

    public void setAutorDaReposta(int autorDaReposta) {
        this.autorDaReposta = autorDaReposta;
    }
}
