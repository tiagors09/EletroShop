package br.com.tiagors09.eletroshop.modelos;

import java.util.Date;
import java.util.UUID;

public class Usuario {
    private final UUID ID;
    private String nome;
    private Date dataNascimento;
    private Localizacao local;
    private String bio;
    private String email;
    private String password;

    public Usuario(String nome, Date dataNascimento, Localizacao local, String bio, String email, String password) {
        this.ID = UUID.randomUUID();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.local = local;
        this.bio = bio;
        this.email = email;
        this.password = password;
    }

    public UUID getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Localizacao getLocal() {
        return local;
    }

    public void setLocal(Localizacao local) {
        this.local = local;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(!this.password.equals(password) && password.length() >= 8) {
            this.password = password;
        }
    }
}
