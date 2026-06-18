package com.vitalvet.api.controller;

import com.vitalvet.api.dto.ConsultaDetalleDTO;
import com.vitalvet.api.entity.Consulta;
import com.vitalvet.api.mapper.ConsultaMapper;
import com.vitalvet.api.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/paciente/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private ConsultaMapper consultaMapper;

    @PreAuthorize("permitAll()")
    @GetMapping("/cita/interno/{idCita}")
    public ResponseEntity<ConsultaDetalleDTO> obtenerConsultaPorCita(
            @PathVariable("idCita") Long idCita) {

        Optional<Consulta> consultaOpt = consultaService.buscarPorIdCita(idCita);

        if (consultaOpt.isEmpty()) {
            return ResponseEntity.ok(null);
        }

        Consulta consulta = consultaOpt.get();
        ConsultaDetalleDTO dto = consultaMapper.toDto(consulta);
        return ResponseEntity.ok(dto);
    }
}
