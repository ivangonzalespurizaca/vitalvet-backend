package com.usuarios.api.client;

import com.usuarios.api.dto.MascotaRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "vitalvet-api-client", url = "http://localhost:8080")
public interface PacienteClient {
    @GetMapping("/api/paciente/mascota/contar/{idCliente}")
    int obtenerTotalMascotasPorCliente(@PathVariable("idCliente") Long idCliente);

    @PostMapping("/api/paciente/mascota/public/registrar")
    Object registrarMascotaPublicoInterno(@RequestBody MascotaRequestDTO mascotaRequestDTO);
}
