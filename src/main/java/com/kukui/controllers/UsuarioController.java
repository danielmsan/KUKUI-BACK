package com.kukui.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kukui.models.Usuario;
import com.kukui.services.UsuarioService;
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.agregarUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long idUsuario) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(idUsuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Usuario> obtenerUsuarioPorEmail(@RequestParam String email) {
        Usuario usuario = usuarioService.obtenerUsuarioPorEmail(email);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
    @PostMapping("/validar-contrasena")
    public ResponseEntity<Boolean> validarContrasena(@RequestBody Map<String, Object> requestBody) {
        String email = requestBody.get("email").toString();
        String contrasena = requestBody.get("contrasena").toString();
        boolean resultado = usuarioService.validarContrasena(email, contrasena);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

}
