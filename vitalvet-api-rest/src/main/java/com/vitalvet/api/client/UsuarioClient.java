package com.vitalvet.api.client;

import com.vitalvet.api.dto.ClienteResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MICRO-USUARIO", url = "http://localhost:8091")
public interface UsuarioClient {
    @GetMapping("/api/cliente/interno/dni/{dni}")
    ClienteResponseDTO obtenerPropietarioPorDniInterno(@PathVariable("dni") String dni);
}
