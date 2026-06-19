package com.vitalvet.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VacunaRegistroRequestDTO {
    @NotNull(message = "Debe seleccionar una vacuna del catálogo.")
    private Long idVacuna;

    @NotNull(message = "Debe especificar el tipo de dosis.")
    @Size(min = 3, max = 50, message = "El tipo de dosis debe tener entre 3 y 50 caracteres.")
    private String dosisTipo;

    @NotNull(message = "Debe seleccionar una fecha.")
    private LocalDate fecha;

}
