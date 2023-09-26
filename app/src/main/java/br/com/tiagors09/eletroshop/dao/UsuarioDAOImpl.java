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
    public void salvar(Usuario u) {
        usuarios.put(u.getID(), u);
    }

    @Override
    public void apagar(UUID ID) {
        if (usuarios.containsKey(ID)) {
            usuarios.remove(ID);
        }
    }

    @Override
    public void atualizar(Usuario u) {
        if(usuarios.containsKey(u.getID())) {
            usuarios.put(u.getID(), u);
        }
    }

    @Override
    public Usuario ler(UUID ID) {
        return usuarios.get(ID);
    }

    @Override
    public HashMap<UUID, Usuario> lerTodosUsuarios() {
        return this.usuarios;
    }
}
