package br.com.tiagors09.eletroshop.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.tiagors09.eletroshop.R;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
    private List<Usuario> usuarios;
    private static UsuarioDAO instance;

    private UsuarioDAOImpl() {
        this.usuarios = new ArrayList<Usuario>();

        salvar(new Usuario(
                "01234567891",
                "Tiago Rodrigues Sousa",
                "28/01/2001",
                new Localizacao(3.1000, 4.000),
                "Vendedor de produtos usados de Quixadá",
                "tiagorodriguessousa9@gmail.com",
                "SenhaTeste123",
                R.drawable.pic
        ));
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
    public Usuario ler(String chave) {
        return usuarios
                .stream()
                .filter(usuario -> usuario.getCPF().equals(chave) || usuario.getEmail().equals(chave))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Usuario> lerTodosUsuarios() {
        return this.usuarios;
    }
}
