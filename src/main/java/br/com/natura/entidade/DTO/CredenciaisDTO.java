package br.com.natura.entidade.DTO;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private String senha;

    public CredenciaisDTO() {
    }

    public CredenciaisDTO(String email, String nome) {
        this.email = email;
        this.senha = nome;
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
