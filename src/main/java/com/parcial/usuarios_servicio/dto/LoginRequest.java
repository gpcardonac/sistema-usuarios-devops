package com.parcial.usuarios_servicio.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String correo;
    private String password;
}
