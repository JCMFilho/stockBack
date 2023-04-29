package com.api.stock.service;

import com.api.stock.entity.Usuario;
import com.api.stock.model.Login;
import com.api.stock.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServiceTest {
    @InjectMocks
    UsuarioService service;
    @Mock
    UsuarioRepository usuarioRepository;
    @Mock
    RecuperarSenhaService recuperarSenhaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUsuarioTest() {
        assertNull(service.getUsuario("1Y6ULkt7uIRr3s1J0Or3tJw4hMa2").getId());
    }

    @Test
    void getUsuarioPorEmailTest() {
        assertNull(service.getUsuarioPorEmail("1Y6ULkt7uIRr3s1J0Or3tJw4hMa2").getId());
    }

    @Test
    void getUsuariosTest() {
        assertNotNull(service.getUsuarios());
    }

    @Test
    void postUsuarioTest() {
        Usuario usuario = new Usuario();
        usuario.setSenha("123deoliveira4");
        assertNull(service.postUsuario(usuario));
    }

    @Test
    void putUsuarioTest() {
        Usuario usuario = new Usuario();
        usuario.setSenha("123deoliveira4");
        assertNull(service.putUsuario(usuario));
    }

    @Test
    void recuperarSenhaTest() {
        assertDoesNotThrow(()-> service.recuperarSenha("teste@teste.com"));
    }

    @Test
    void trocarSenhaTest() {
        Login login = new Login();
        login.setSenha("teste");
        login.setLogin("login");
        assertTrue(()-> service.trocarSenha(login));
    }
}
