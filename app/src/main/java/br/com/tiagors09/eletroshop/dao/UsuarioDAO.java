package br.com.tiagors09.eletroshop.dao;

import com.google.android.gms.tasks.Task;

import java.util.List;

import br.com.tiagors09.eletroshop.modelos.Usuario;

public interface UsuarioDAO {
    Task<Boolean> salvar(Usuario u);
    Task<Boolean> apagar(String CPF);
    Task<Usuario> ler(String CPF);
    Task<List<Usuario>> lerTodosUsuarios();
}
