package com.parcial.usuarios_servicio.security;

import com.parcial.usuarios_servicio.dto.LoginRequest;
import com.parcial.usuarios_servicio.entity.Usuario;
import com.parcial.usuarios_servicio.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioService usuarioService, JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = usuarioService.autenticar(loginRequest.getCorreo(), loginRequest.getPassword());
        String token = jwtUtil.generateToken(usuario);
        return ResponseEntity.ok(Map.of("token", token));
    }
}