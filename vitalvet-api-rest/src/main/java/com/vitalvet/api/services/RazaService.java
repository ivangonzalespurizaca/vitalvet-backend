package com.vitalvet.api.services;

import com.vitalvet.api.entity.Raza;

public interface RazaService extends ICRUD<Raza, Long> {
    boolean existeDuplicado(String nombre, Long idEspecie);
    boolean existeDuplicadoActualizar(String nombre, Long idEspecie, Long idRaza);
}