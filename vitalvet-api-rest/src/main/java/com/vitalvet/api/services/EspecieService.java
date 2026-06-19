package com.vitalvet.api.services;

import com.vitalvet.api.entity.Especie;

public interface EspecieService extends ICRUD<Especie, Long> {
    boolean existePorNombre(String nombre);
    boolean existePorNombreYIdDiferente(String nombre, Long id);
}