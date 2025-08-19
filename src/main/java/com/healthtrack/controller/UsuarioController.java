package com.healthtrack.controller;

import com.healthtrack.model.Usuario;
import com.healthtrack.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    private final UsuarioService usuarioService;
    
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }
    
    @GetMapping("/{nombre}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String nombre) {
        return usuarioService.obtenerUsuario(nombre)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodos() {
        List<Usuario> usuarios = usuarioService.obtenerTodos();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    
    @PutMapping("/{nombre}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable String nombre, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(nombre, usuario)
                .map(usuarioActualizado -> new ResponseEntity<>(usuarioActualizado, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String nombre) {
        if (usuarioService.eliminarUsuario(nombre)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PatchMapping("/{nombre}/peso")
    public ResponseEntity<Usuario> actualizarPeso(@PathVariable String nombre, @RequestParam Double nuevoPeso) {
        return usuarioService.actualizarPesoUsuario(nombre, nuevoPeso)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return new ResponseEntity<>("API funcionando correctamente", HttpStatus.OK);
    }
}
