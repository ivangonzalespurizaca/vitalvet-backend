package com.vitalvet.api.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VacunaAplicadaDTO {
    @NotNull(message = "El ID de la vacuna es un campo obligatorio.")
    private Long idVacuna;
    private LocalDate proximaDosis;
    @NotBlank(message = "El número o tipo de dosis es obligatorio (Ej: '1ra Dosis').")
    private String nroDosis;
}