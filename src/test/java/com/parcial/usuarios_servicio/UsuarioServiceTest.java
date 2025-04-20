package com.parcial.usuarios_servicio;

import com.parcial.usuarios_servicio.entity.Usuario;
import com.parcial.usuarios_servicio.repository.UsuarioRepository;
import com.parcial.usuarios_servicio.service.imp.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    private UsuarioRepository usuarioRepository;
    private UsuarioServiceImpl usuarioService;

    @Test
    @Disabled("Deshabilitado temporalmente para evitar fallos de conexión en GitHub Actions")
    void contextLoads() {
    }
    @BeforeEach
    void setUp() {
        usuarioRepository = mock(UsuarioRepository.class);
        usuarioService = new UsuarioServiceImpl(usuarioRepository);
    }

    @Test
    void testExistePorCorreo_retornaTrueSiExiste() {
        String correo = "juan@example.com";
        when(usuarioRepository.findByCorreo(correo)).thenReturn(Optional.of(new Usuario()));

        boolean existe = usuarioService.existePorCorreo(correo);
        assertTrue(existe);
    }

    @Test
    void testAutenticar_usuarioYPasswordCorrectos() {
        Usuario usuario = new Usuario();
        usuario.setCorreo("test@correo.com");
        usuario.setPassword("1234");

        when(usuarioRepository.findByCorreo("test@correo.com")).thenReturn(Optional.of(usuario));

        Usuario result = usuarioService.autenticar("test@correo.com", "1234");

        assertNotNull(result);
        assertEquals("test@correo.com", result.getCorreo());
    }
}
