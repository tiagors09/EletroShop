package br.com.tiagors09.eletroshop;

import static org.junit.Assert.*;

import com.google.android.gms.tasks.OnSuccessListener;

import org.junit.Test;

import br.com.tiagors09.eletroshop.dao.UsuarioDAO;
import br.com.tiagors09.eletroshop.dao.UsuarioDAOImpl;
import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class UsuarioDAOTestCase {
    private UsuarioDAO usuarioDAO = UsuarioDAOImpl.getInstance();

    @Test
    public void adicionarUsuario() {
        Usuario usuario = new Usuario(
                "01234567891",
                "Tiago Rodrigues Sousa",
                "28/01/2001",
                new Localizacao(3.12, 4.12),
                "Teste teste teste",
                "tiagors09@gmail.com",
                "Teste1234!");

        usuarioDAO
                .salvar(usuario)
                .addOnSuccessListener(
                        new OnSuccessListener<Boolean>() {
                            @Override
                            public void onSuccess(Boolean aBoolean) {
                                assertTrue(aBoolean);
                            }
                        }
                );
    }

    @Test
    public void lerUsuario() {
        assertNotNull(this.usuarioDAO.ler("01234567891"));
    }

    @Test
    public void apagarUsuario() {
        assertNotNull(this.usuarioDAO.apagar("01234567891"));
    }

    @Test
    public void lerTodosUsuarios() {
        assertNotNull(this.usuarioDAO.lerTodosUsuarios());
    }
}
