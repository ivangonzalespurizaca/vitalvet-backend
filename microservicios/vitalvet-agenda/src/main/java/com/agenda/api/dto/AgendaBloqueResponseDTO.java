package com.agenda.api.dto;

import com.agenda.api.entity.enums.TipoEstadoCita;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgendaBloqueResponseDTO {
    private String hora;
    private boolean disponible;
    private Long idCita;
    private String nombreMascota;
    private String razaMascota;
    private String nombrePropietario;
    private String dniPropietario;
    private TipoEstadoCita estadoCita;
    private String motivoConsulta;
}