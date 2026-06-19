package com.usuarios.api.services;

import com.usuarios.api.entity.Especialidad;

public interface EspecialidadService extends ICRUD<Especialidad, Long> {
    boolean existePorNombre(String nombre);
    boolean existePorNombreYIdDiferente(String nombre, Long id);
}
