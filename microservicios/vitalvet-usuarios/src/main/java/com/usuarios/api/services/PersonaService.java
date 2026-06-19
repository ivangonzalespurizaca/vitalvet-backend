package com.usuarios.api.services;

import com.usuarios.api.entity.Persona;

import java.util.List;

public interface PersonaService extends ICRUD<Persona, Long> {
    List<Persona> buscarClientesPorFiltro(String texto);

    boolean existeDni(String dni);

    Persona buscarPorDni(String dni);

    int obtenerTotalMascotas(Long id);

}
