package br.com.tiagors09.eletroshop.dao;

import java.util.HashMap;
import java.util.UUID;

import br.com.tiagors09.eletroshop.modelos.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
    private HashMap<String,Usuario> usuarios;
    private static UsuarioDAO instance;

    private UsuarioDAOImpl() {
        usuarios = new HashMap<String,Usuario>();
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAOImpl();
            return instance;
        }

        return instance;
    }

    @Override
    public Usuario salvar(Usuario u) {
        return usuarios.put(u.getCPF(), u);
    }

    @Override
    public Usuario apagar(String CPF) {
        if (usuarios.containsKey(CPF)) {
            return usuarios.remove(CPF);
        }

        return null;
    }

    @Override
    public Usuario ler(String CPF) {
        return usuarios.get(CPF);
    }

    @Override
    public HashMap<String, Usuario> lerTodosUsuarios() {
        return this.usuarios;
    }
}
