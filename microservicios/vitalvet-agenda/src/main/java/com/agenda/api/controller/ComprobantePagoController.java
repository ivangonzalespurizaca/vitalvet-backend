package com.agenda.api.controller;

import com.agenda.api.http.response.ComprobanteAdminResponse;
import com.agenda.api.http.response.ComprobanteClienteResponse;
import com.agenda.api.services.ComprobanteService;
import com.agenda.api.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/agenda/comprobantes")
public class ComprobantePagoController {

    @Autowired
    private ComprobanteService comprobanteService;

    @GetMapping("/historial")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'VETERINARIO')")
    public ResponseEntity<ApiResponse<ComprobanteAdminResponse>> consultarHistorial(
            @RequestParam(value = "tipo", required = false) String tipo,
            @RequestParam(value = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(value = "fin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {

        ComprobanteAdminResponse reporte = comprobanteService.obtenerHistorialComprobantes(tipo, inicio, fin);

        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Historial financiero y datos de clientes recuperados exitosamente.",
                reporte
        ));
    }

    @GetMapping("/mis-comprobantes")
    @PreAuthorize("hasRole('CLIENTE')")
    public ResponseEntity<ApiResponse<ComprobanteClienteResponse>> obtenerMisComprobantes(
            Authentication authentication,
            @RequestParam(value = "tipo", required = false) String tipo,
            @RequestParam(value = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(value = "fin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin){

        Long idCliente = null;

        if (authentication.getDetails() instanceof Map<?, ?> claims) {
            Object idObject = claims.containsKey("idPersona") ? claims.get("idPersona") : claims.get("idpersona");
            if (idObject != null) {
                idCliente = Long.valueOf(idObject.toString());
            }
        }

        ComprobanteClienteResponse response = comprobanteService.obtenerComprobantesPorCliente(
                idCliente, tipo, inicio, fin);

        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Tu historial de comprobantes de pago fue recuperado correctamente.",
                response
        ));
    }
}
