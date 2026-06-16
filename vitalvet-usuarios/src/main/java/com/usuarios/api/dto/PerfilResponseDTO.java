package com.usuarios.api.dto;

import com.usuarios.api.entity.enums.Rol;
import lombok.Data;

@Data
public class PerfilResponseDTO {
    private Long idPersona;
    private String codigoPersona;
    private String nombres;
    private String apellidos;
    private String dni;
    private Rol rol;
    private String celular;
    private String fotoUrl;
    private String email;
    private String numColegiatura;
}