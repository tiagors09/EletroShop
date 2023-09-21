package br.com.tiagors09.eletroshop.dao;

import java.util.UUID;

import br.com.tiagors09.eletroshop.modelos.Usuario;

public interface UsuarioDAO {
    public boolean salvarUsuario(Usuario u);
    public Usuario lerUsuario(UUID ID);
    public boolean deletarUsuario(UUID ID);
}
