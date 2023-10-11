package br.com.tiagors09.eletroshop.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.tiagors09.eletroshop.modelos.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
    private List<Usuario> usuarios;
    private static UsuarioDAO instance;

    private UsuarioDAOImpl() {
        this.usuarios = new ArrayList<Usuario>();
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAOImpl();
        }

        return instance;
    }

    @Override
    public boolean salvar(Usuario u) {
        return usuarios.add(u);
    }

    @Override
    public Usuario apagar(String CPF) {
        Usuario u = this.usuarios
                .stream()
                .filter(usuario -> usuario
                                .getCPF()
                                .equals(CPF))
                .findFirst()
                .orElse(null);

        return this.usuarios
                .remove(this.usuarios.indexOf(u));
    }

    @Override
    public Usuario ler(String CPF) {
        return usuarios
                .stream()
                .filter(usuario -> usuario.getCPF().equals(CPF))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Usuario> lerTodosUsuarios() {
        return this.usuarios;
    }
}
