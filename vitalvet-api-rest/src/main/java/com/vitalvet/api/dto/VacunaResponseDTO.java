package com.vitalvet.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacunaResponseDTO {
    private Long idAplicacion;
    private String nombreVacuna;
    private String dosis;
    private LocalDate fechaAplicacion;
    private LocalDate proximaDosis;
    private String estado;
}