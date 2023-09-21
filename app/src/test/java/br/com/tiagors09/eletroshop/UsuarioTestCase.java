package br.com.tiagors09.eletroshop;

import junit.framework.TestCase;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import br.com.tiagors09.eletroshop.modelos.Localizacao;
import br.com.tiagors09.eletroshop.modelos.Usuario;

public class UsuarioTestCase extends TestCase {
    /*
     * Realiza um teste para verificar a integridade e correção do construtor.
     */
    @Test
    public void testUsuario() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Usuario usuarioResultadoNaoEsperado = new Usuario(
          "Tiago Rodrigues Sousa",
                "28/01/2001",
                new Localizacao(3.1000, 4.000),
                "Vendedor de produtos usados de Quixadá",
                "tiagorodriguessousa9@gmail.com",
                "SenhaTeste123"
        );

        Usuario usuario = new Usuario(
                "Tiago Rodrigues Sousa",
                "28/01/2001",
                new Localizacao(3.1000, 4.000),
                "Vendedor de produtos usados de Quixadá",
                "tiagorodriguessousa9@gmail.com",
                "SenhaTeste123"
        );

        // Verifica se a instância foi bem executada
        assertNotNull(usuario);

        // Verifica se gerou dois usuários com ID's únicos
        assertNotSame(usuarioResultadoNaoEsperado, usuario);
    }
}
