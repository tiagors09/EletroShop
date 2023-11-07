package br.com.tiagors09.eletroshop.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Usuario {
    private String CPF;
    private String nome;
    private LocalDate dataNascimento;
    private Localizacao local;
    private String bio;
    private String email;
    private int fotoPerfil;

    public Usuario(String CPF, String nome, String dataNascimento, Localizacao local, String bio, String email) {
        this.CPF = CPF;
        this.nome = nome;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataNascimento = LocalDate.parse(dataNascimento,dateTimeFormatter);

        this.local = local;
        this.bio = bio;
        this.email = email;
    }

    public Usuario(String CPF, String nome, String dataNascimento, Localizacao local, String bio, String email, int fotoPerfil) {
        this.CPF = CPF;
        this.nome = nome;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataNascimento = LocalDate.parse(dataNascimento,dateTimeFormatter);

        this.local = local;
        this.bio = bio;
        this.email = email;
        this.fotoPerfil = fotoPerfil;
    }

    public String getCPF() { return CPF; }

    public void setCpf(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
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

    public void setFotoPerfil(int fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public int getFotoPerfil() {
        return fotoPerfil;
    }

    @Override
    public String toString() {
        return String.format("" +
                "{ cpf: %s," +
                " nome: %s," +
                " dataNascimento: %s," +
                " local: %s,"  +
                " bio: %s," +
                " email: %s }", CPF, nome, dataNascimento.toString(), local.toString(), bio, email);
    }
}
