package com.parcial.usuarios_servicio.controller;

import com.parcial.usuarios_servicio.entity.Usuario;
import com.parcial.usuarios_servicio.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerUsuario(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearUsuario(usuario));
    }

    @GetMapping("/existe")
    public ResponseEntity<Boolean> existeUsuario(@RequestParam String correo) {
        boolean existe = usuarioService.existePorCorreo(correo);
        return ResponseEntity.ok(existe);
    }

}
