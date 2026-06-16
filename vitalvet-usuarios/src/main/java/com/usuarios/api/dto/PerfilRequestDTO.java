package com.usuarios.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PerfilRequestDTO {
    @NotBlank(message = "Los nombres no pueden estar vacíos")
    @Size(max = 100)
    private String nombres;

    @NotBlank(message = "Los apellidos pueden estar vacíos")
    @Size(max = 100)
    private String apellidos;

    @Size(max = 15)
    private String celular;

    private String fotoUrl;
}
