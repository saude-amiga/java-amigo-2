package fiap.sprint.dto.input;

public class RespostaInputDto {
    private String corpo;
    private int autorDaReposta;

    public RespostaInputDto( int idAutor, String resposta) {
        this.corpo = resposta;
        this.autorDaReposta = idAutor;
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
