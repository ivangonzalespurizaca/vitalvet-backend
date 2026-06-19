package com.vitalvet.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ConsultaRequestDTO {

    @NotNull(message = "El ID de la cita es obligatorio")
    private Long idCita;

    private Long idVeterinario;

    private BigDecimal pesoActual;
    private BigDecimal temperatura;

    @NotNull(message = "El diagnóstico médico no puede estar vacío")
    private String diagnostico;

    private String recomendaciones;

    @Valid
    private List<VacunaAplicadaDTO> vacunas;

}