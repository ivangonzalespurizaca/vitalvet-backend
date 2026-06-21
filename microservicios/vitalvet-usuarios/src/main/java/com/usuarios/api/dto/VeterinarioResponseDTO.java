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
    private Long idEspecialidad;
    private String especialidad;
    private String fotoUrl;
    private String celular;
    private String genero;
    private boolean activo;

    public String getNombreCompletoConEspecialidad() {
        return "Dr. " + this.nombres + " " + this.apellidos + " - " + this.especialidad;
    }
}