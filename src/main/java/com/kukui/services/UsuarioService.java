package com.kukui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kukui.models.Usuario;
import com.kukui.repositories.UsuarioRepository;
import com.kukui.util.UsuarioNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    
    public Usuario agregarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado"));
    }

    public Usuario obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    public boolean validarContrasena(String email, String contrasena) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(usuario != null) {
            String contrasenaAlmacenada = usuario.getPassword();
            if(contrasenaAlmacenada.equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

}