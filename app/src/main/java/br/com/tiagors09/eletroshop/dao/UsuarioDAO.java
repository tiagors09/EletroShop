package br.com.tiagors09.eletroshop.dao;

import java.util.Collection;

import br.com.tiagors09.eletroshop.modelos.Usuario;

public interface UsuarioDAO {
    Usuario salvar(Usuario u);
    Usuario apagar(String cpf);
    Usuario ler(String cpf);
    Collection<Usuario> lerTodosUsuarios();
}
