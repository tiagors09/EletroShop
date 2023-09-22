package br.com.tiagors09.eletroshop.dao;

import java.util.HashMap;
import java.util.UUID;

import br.com.tiagors09.eletroshop.modelos.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
    private HashMap<UUID,Usuario> usuarios;
    private static UsuarioDAO instance;

    private UsuarioDAOImpl() {
        usuarios = new HashMap<UUID,Usuario>();
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAOImpl();
            return instance;
        }

        return instance;
    }

    @Override
    public boolean salvarUsuario(Usuario u) {
        usuarios.put(u.getID(), u);
        return true;
    }

    @Override
    public Usuario lerUsuario(UUID ID) {
        return usuarios.get(ID);
    }

    @Override
    public boolean deletarUsuario(UUID ID) {
        Usuario u = usuarios.get(ID);

        if (u != null) {
            usuarios.remove(ID);
            return true;
        }

        return false;
    }
}
