package com.kukui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kukui.models.Usuario;
import com.kukui.services.UsuarioService;

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

}
