package com.vitalvet.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "MICRO-AGENDA", url = "http://localhost:8091")
public interface AgendaClient {

    @PutMapping("/api/agenda/cita/interno/{idCita}/completar")
    void completarCitaInterno(@PathVariable("idCita") Long idCita);
}