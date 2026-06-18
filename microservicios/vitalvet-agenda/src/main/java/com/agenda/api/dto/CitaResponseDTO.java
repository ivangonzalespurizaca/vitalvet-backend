package com.agenda.api.dto;

import com.agenda.api.entity.enums.TipoEstadoCita;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CitaResponseDTO {

    private Long idCita;
    private String codigoCita;
    private Long idMascota;
    private Long idVeterinario;

    private LocalDate fecha;

    @JsonFormat(pattern = "hh:mm a")
    private LocalTime hora;

    private String motivo;
    private TipoEstadoCita estado;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaCreacion;

}
