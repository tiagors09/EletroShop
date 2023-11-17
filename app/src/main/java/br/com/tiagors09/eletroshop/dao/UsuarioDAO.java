package br.com.tiagors09.eletroshop.dao;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import java.util.List;

import br.com.tiagors09.eletroshop.modelos.Usuario;

public interface UsuarioDAO {
    Task<Boolean> salvar(Usuario u);
    Task<Boolean> apagar();
    Task<Usuario> ler();
    Task<List<Usuario>> lerTodosUsuarios();
    Task<AuthResult> entrar(Usuario u);
    Task<Void> sair();
}
