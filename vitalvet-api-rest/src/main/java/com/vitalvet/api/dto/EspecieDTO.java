package com.vitalvet.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EspecieDTO {
    private Long idEspecie;

    @NotBlank(message = "El nombre de la especie es obligatorio.")
    private String nombreEspecie;

    private Boolean activo;
}