package com.agenda.api.services;

import com.agenda.api.dto.*;
import com.agenda.api.entity.Cita;
import com.agenda.api.entity.enums.TipoEstadoCita;
import com.agenda.api.http.response.CitaDetalleResponse;
import com.agenda.api.http.response.CitaPanelResponse;

import java.time.LocalDate;
import java.util.List;

public interface CitaService extends ICRUD<Cita, Long>{

    List<SlotDTO> obtenerHorasDisponibles(Long idVeterinario, LocalDate fecha);
    CitaResponseDTO registrarCita(CitaRequestDTO dto);
    List<CitaPanelResponse> listarCitasPanelPrincipal(TipoEstadoCita estado, String criterio, Long idCliente, Long idVeterinario);
    CitaDetalleResponse obtenerDetalleCompletoCita(Long idCita);
    void cambiarEstadoCompletadoInterno(Long idCita);
    List<AgendaBloqueResponseDTO> obtenerAgendaDiariaVeterinario(Long idVeterinario, LocalDate fecha);
}
