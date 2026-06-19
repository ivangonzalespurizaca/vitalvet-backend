package com.vitalvet.api.services;

import com.vitalvet.api.entity.Vacuna;

public interface VacunaService extends ICRUD<Vacuna, Long> {
    boolean existePorNombre(String nombre);
    boolean existePorNombreYIdDiferente(String nombre, Long id);
}