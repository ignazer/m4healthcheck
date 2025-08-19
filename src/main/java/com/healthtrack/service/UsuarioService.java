package com.healthtrack.service;

import com.healthtrack.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioService {
    
    private final Map<String, Usuario> usuarios = new HashMap<>();
    
    public Usuario crearUsuario(Usuario usuario) {
        usuarios.put(usuario.getNombre(), usuario);
        return usuario;
    }
    
    public Optional<Usuario> obtenerUsuario(String nombre) {
        return Optional.ofNullable(usuarios.get(nombre));
    }
    
    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios.values());
    }
    
    public Optional<Usuario> actualizarUsuario(String nombre, Usuario usuarioActualizado) {
        if (!usuarios.containsKey(nombre)) {
            return Optional.empty();
        }
        
        usuarios.put(nombre, usuarioActualizado);
        return Optional.of(usuarioActualizado);
    }
    
    public boolean eliminarUsuario(String nombre) {
        if (!usuarios.containsKey(nombre)) {
            return false;
        }
        
        usuarios.remove(nombre);
        return true;
    }
    
    public Optional<Usuario> actualizarPesoUsuario(String nombre, double nuevoPeso) {
        return obtenerUsuario(nombre).map(usuario -> {
            usuario.actualizarPeso(nuevoPeso);
            return usuario;
        });
    }
}
