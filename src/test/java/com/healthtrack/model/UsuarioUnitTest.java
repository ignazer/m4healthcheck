package com.healthtrack.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioUnitTest {
    
    private Usuario usuario;
    
    @BeforeEach
    void setUp() {
        usuario = new Usuario("Juan Pérez", 70.0);
    }
    
    @Test
    void testActualizarPesoCorrectamente() {
        // Given
        double nuevoPeso = 75.5;
        
        // When
        usuario.actualizarPeso(nuevoPeso);
        
        // Then
        assertEquals(nuevoPeso, usuario.getPeso(), 0.01, 
                    "El peso debe actualizarse al valor exacto ingresado");
    }
    
    @Test
    void testActualizarPesoNoReduceAutomaticamente() {
        // Given
        double pesoInicial = usuario.getPeso();
        double nuevoPeso = 80.0;
        
        // When
        usuario.actualizarPeso(nuevoPeso);
        
        // Then
        assertNotEquals(pesoInicial - 1, usuario.getPeso(), 
                       "El sistema NO debe restar 1kg automáticamente");
        assertEquals(nuevoPeso, usuario.getPeso(), 0.01);
    }
    
    @Test
    void testActualizarPesoConValoresBorde() {
        // Test con peso mínimo
        usuario.actualizarPeso(40.0);
        assertEquals(40.0, usuario.getPeso(), 0.01);
        
        // Test con peso máximo
        usuario.actualizarPeso(200.0);
        assertEquals(200.0, usuario.getPeso(), 0.01);
        
        // Test con decimales
        usuario.actualizarPeso(72.75);
        assertEquals(72.75, usuario.getPeso(), 0.01);
    }
    
    @Test
    void testMultiplesActualizacionesPeso() {
        // Simular múltiples actualizaciones consecutivas
        usuario.actualizarPeso(75.0);
        assertEquals(75.0, usuario.getPeso(), 0.01);
        
        usuario.actualizarPeso(73.2);
        assertEquals(73.2, usuario.getPeso(), 0.01);
        
        usuario.actualizarPeso(71.8);
        assertEquals(71.8, usuario.getPeso(), 0.01);
    }
}
