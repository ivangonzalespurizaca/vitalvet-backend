package com.vitalvet.api.services;

import com.vitalvet.api.entity.Mascota;

import java.util.List;

public interface MascotaService extends ICRUD<Mascota, Long> {
    int contarPorIdCliente(Long id);
    List<Mascota> listarMascotasPorCliente(Long idCliente);
}
