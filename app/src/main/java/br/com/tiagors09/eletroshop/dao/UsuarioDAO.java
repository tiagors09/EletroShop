package br.com.tiagors09.eletroshop.dao;

import java.util.List;

import br.com.tiagors09.eletroshop.modelos.Usuario;

public interface UsuarioDAO {
    boolean salvar(Usuario u);
    Usuario apagar(String cpf);
    Usuario ler(String chave);
    List<Usuario> lerTodosUsuarios();
}
