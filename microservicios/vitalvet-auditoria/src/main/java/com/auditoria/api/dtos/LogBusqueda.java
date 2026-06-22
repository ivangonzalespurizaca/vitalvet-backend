package com.auditoria.api.dtos;


import lombok.Data;
import java.time.LocalDate;

@Data
public class LogBusqueda {
    private String usuarioOrId;
    private String modulo;
    private String accion;
    private LocalDate fecha;
}