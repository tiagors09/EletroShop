package br.com.tiagors09.eletroshop.dao;

import java.util.HashMap;
import java.util.UUID;

import br.com.tiagors09.eletroshop.modelos.Usuario;

public interface UsuarioDAO {
    public void salvar(Usuario u);
    public void apagar(UUID ID);
    public void atualizar(Usuario u);
    public Usuario ler(UUID ID);
    public HashMap<UUID, Usuario> lerTodosUsuarios();
}
