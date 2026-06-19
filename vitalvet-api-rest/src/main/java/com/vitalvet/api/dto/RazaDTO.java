package com.vitalvet.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RazaDTO {
    private Long idRaza;

    @NotBlank(message = "El nombre de la raza es obligatorio.")
    private String nombreRaza;

    @NotNull(message = "Debe asociar la raza a una especie.")
    private Long idEspecie;

    private String nombreEspecie;

    private Boolean activo;
}