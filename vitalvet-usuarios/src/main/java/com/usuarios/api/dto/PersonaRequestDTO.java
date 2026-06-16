package com.usuarios.api.dto;

import com.usuarios.api.entity.enums.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonaRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellidos;

    @NotBlank(message = "El DNI es obligatorio")
    @Size(min = 8, max = 12, message = "DNI no válido")
    private String dni;

    private String celular;

    @NotNull(message = "El género es obligatorio")
    private Genero genero;
}