package com.usuarios.api.dto;

import lombok.Data;

@Data
public class VeterinarioResponseDTO {
    private Long idVeterinario;
    private String dni;
    private String nombres;
    private String apellidos;
    private String email;
    private String nroColegiatura;
    private String especialidad;
    private String fotoUrl;
    private boolean activo;

    public String getNombreCompletoConEspecialidad() {
        return "Dr. " + this.nombres + " " + this.apellidos + " - " + this.especialidad;
    }
}