package com.parcial.usuarios_servicio.service;


import com.parcial.usuarios_servicio.entity.Usuario;

public interface UsuarioService {
    Usuario obtenerUsuario(Long id);
    Usuario crearUsuario(Usuario usuario);
    Usuario autenticar(String correo, String password);

    boolean existePorCorreo(String correo);
}
