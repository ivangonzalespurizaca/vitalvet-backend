package com.vitalvet.api.services.impl;

import com.vitalvet.api.entity.Vacuna;
import com.vitalvet.api.repository.VacunaRepository;
import com.vitalvet.api.services.VacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class VacunaServiceImpl extends ICRUDImpl<Vacuna, Long> implements VacunaService {

    @Autowired
    private VacunaRepository repository;

    @Override
    public JpaRepository<Vacuna, Long> getRepository() {
        return repository;
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return repository.existsByNombreVacunaIgnoreCase(nombre);
    }

    @Override
    public boolean existePorNombreYIdDiferente(String nombre, Long id) {
        return repository.existsByNombreVacunaIgnoreCaseAndIdVacunaNot(nombre, id);
    }
}
