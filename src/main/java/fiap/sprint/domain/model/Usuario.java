package fiap.sprint.domain.model;

import java.util.ArrayList;

public class Usuario {
    private int userId;
    private String name;
    private String email;
    private String senha;

    public Usuario(int userId, String name, String email, String senha) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.senha = senha;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
