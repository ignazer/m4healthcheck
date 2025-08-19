package com.healthtrack.service;

import com.healthtrack.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {
    
    @InjectMocks
    private UsuarioService usuarioService;
    
    private Usuario usuario1;
    private Usuario usuario2;
    
    @BeforeEach
    void setUp() {
        usuarioService = new UsuarioService(); // Crear una nueva instancia para cada prueba
        
        usuario1 = new Usuario("Raúl Fernández", 75.0);
        usuario2 = new Usuario("Laura Torres", 58.0);
    }
    
    @Test
    void testCrearUsuario() {
        Usuario creado = usuarioService.crearUsuario(usuario1);
        
        assertEquals("Raúl Fernández", creado.getNombre());
        assertEquals(75.0, creado.getPeso(), 0.01);
    }
    
    @Test
    void testObtenerUsuario() {
        usuarioService.crearUsuario(usuario1);
        
        Optional<Usuario> recuperado = usuarioService.obtenerUsuario("Raúl Fernández");
        
        assertTrue(recuperado.isPresent());
        assertEquals("Raúl Fernández", recuperado.get().getNombre());
        assertEquals(75.0, recuperado.get().getPeso(), 0.01);
    }
    
    @Test
    void testObtenerUsuarioNoExistente() {
        Optional<Usuario> recuperado = usuarioService.obtenerUsuario("No Existe");
        
        assertFalse(recuperado.isPresent());
    }
    
    @Test
    void testObtenerTodos() {
        usuarioService.crearUsuario(usuario1);
        usuarioService.crearUsuario(usuario2);
        
        List<Usuario> usuarios = usuarioService.obtenerTodos();
        
        assertEquals(2, usuarios.size());
    }
    
    @Test
    void testActualizarUsuario() {
        usuarioService.crearUsuario(usuario1);
        
        Usuario usuarioActualizado = new Usuario("Raúl Fernández", 80.0);
        
        Optional<Usuario> actualizado = usuarioService.actualizarUsuario("Raúl Fernández", usuarioActualizado);
        
        assertTrue(actualizado.isPresent());
        assertEquals("Raúl Fernández", actualizado.get().getNombre());
        assertEquals(80.0, actualizado.get().getPeso(), 0.01);
    }
    
    @Test
    void testActualizarUsuarioNoExistente() {
        Optional<Usuario> actualizado = usuarioService.actualizarUsuario("No Existe", usuario1);
        
        assertFalse(actualizado.isPresent());
    }
    
    @Test
    void testEliminarUsuario() {
        usuarioService.crearUsuario(usuario1);
        
        boolean resultado = usuarioService.eliminarUsuario("Raúl Fernández");
        
        assertTrue(resultado);
        assertEquals(0, usuarioService.obtenerTodos().size());
    }
    
    @Test
    void testEliminarUsuarioNoExistente() {
        boolean resultado = usuarioService.eliminarUsuario("No Existe");
        
        assertFalse(resultado);
    }
    
    @Test
    void testActualizarPesoUsuario() {
        usuarioService.crearUsuario(usuario1);
        
        Optional<Usuario> actualizado = usuarioService.actualizarPesoUsuario("Raúl Fernández", 85.0);
        
        assertTrue(actualizado.isPresent());
        assertEquals(85.0, actualizado.get().getPeso(), 0.01);
    }
    
    @Test
    void testActualizarPesoUsuarioNoExistente() {
        Optional<Usuario> actualizado = usuarioService.actualizarPesoUsuario("No Existe", 85.0);
        
        assertFalse(actualizado.isPresent());
    }
}
