package com.usuarios.api.services.impl;

import com.usuarios.api.entity.Especialidad;
import com.usuarios.api.repository.EspecialidadRepository;
import com.usuarios.api.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadServiceImpl extends ICRUDImpl<Especialidad, Long> implements EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public JpaRepository<Especialidad, Long> getRepository() {
        return especialidadRepository;
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return especialidadRepository.existsByNombreEspecialidadIgnoreCase(nombre);
    }

    @Override
    public boolean existePorNombreYIdDiferente(String nombre, Long id) {
        return especialidadRepository.existsByNombreEspecialidadIgnoreCaseAndIdEspecialidadNot(nombre, id);
    }
}
