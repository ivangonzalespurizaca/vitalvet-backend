package com.vitalvet.api.dto;

import com.vitalvet.api.entity.enums.SexoMascota;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarnetVacunaDTO {
    private String codigoMascota;
    private String nombreMascota;
    private SexoMascota sexo;
    private LocalDate fechaNacimiento;
    private BigDecimal pesoActual;
    private String fotoUrl;
    private String nombreRaza;
    private String nombreEspecie;
    private List<VacunaResponseDTO> vacunas;
}
