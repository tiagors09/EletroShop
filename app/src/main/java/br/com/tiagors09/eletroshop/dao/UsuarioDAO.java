package br.com.tiagors09.eletroshop.dao;

import java.util.HashMap;
import java.util.UUID;

import br.com.tiagors09.eletroshop.modelos.Usuario;

public interface UsuarioDAO {
    public Usuario salvar(Usuario u);
    public Usuario apagar(String cpf);
    public Usuario ler(String cpf);
    public HashMap<String, Usuario> lerTodosUsuarios();
}
