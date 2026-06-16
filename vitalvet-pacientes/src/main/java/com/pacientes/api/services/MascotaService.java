package com.pacientes.api.services;

import com.pacientes.api.dto.MascotaResponseDTO;
import com.pacientes.api.entity.Mascota;

import java.util.List;

public interface MascotaService extends ICRUD<Mascota, Long> {
    int contarPorIdCliente(Long id);
    List<Mascota> listarMascotasPorCliente(Long idCliente);
}
