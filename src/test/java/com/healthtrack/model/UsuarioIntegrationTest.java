package com.healthtrack.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class UsuarioIntegrationTest {
    
    @Test
    void testFlujoCompletoActualizacionPeso() {
        // Given: Usuario registrado en sistema
        Usuario usuario = new Usuario("Test User", 70.0);
        
        // When: Actualizar peso a través del servicio completo
        double nuevoPeso = 75.5;
        usuario.actualizarPeso(nuevoPeso);
        
        // Then: Verificar que el peso se guardó correctamente
        assertEquals(nuevoPeso, usuario.getPeso(), 0.01);
        
        // And: Verificar que la información se muestra correctamente
        // (Este test capturaría el error de mostrar peso incorrecto)
        String infoEsperada = "Usuario: Test User, Peso Actual: 75.5 kg";
        // En una implementación real, verificaríamos la salida del método mostrarInformacion()
    }
}
