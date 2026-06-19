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
public class VacunaDTO {
    private Long idVacuna;

    @NotBlank(message = "El nombre de la vacuna es obligatorio.")
    private String nombreVacuna;

    private String descripcion;

    private Boolean activo;
}