package com.usuarios.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadDTO {
    private Long idEspecialidad;

    @NotBlank(message = "El nombre de la especialidad es obligatorio.")
    private String nombreEspecialidad;

    private Boolean activo;
}