package br.com.tiagors09.eletroshop.dao;

import java.util.ArrayList;
import java.util.UUID;

import br.com.tiagors09.eletroshop.modelos.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
    private ArrayList<Usuario> usuarios;
    private static UsuarioDAO instance;

    private UsuarioDAOImpl() {
        usuarios = new ArrayList<Usuario>();
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
        int IDConvertido = Integer.parseInt(u.getID().toString());
        boolean estaNoBanco = usuarios.contains(u);

        if (estaNoBanco) {
            usuarios.add(IDConvertido, u);
            return true;
        } else {
            return usuarios.add(u);
        }
    }

    @Override
    public Usuario lerUsuario(UUID ID) {
        int IDConvertido = Integer.parseInt(ID.toString());
        Usuario usuario = usuarios.get(IDConvertido);

        if (usuario != null) {
            return usuario;
        }

        return null;
    }

    @Override
    public boolean deletarUsuario(UUID ID) {
        int IDConvertido = Integer.parseInt(ID.toString());
        boolean estaNoBanco = usuarios.get(IDConvertido) != null;
        if (estaNoBanco) {
            usuarios.remove(IDConvertido);
            return  true;
        }

        return false;
    }
}
