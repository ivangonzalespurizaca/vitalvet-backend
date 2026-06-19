package com.vitalvet.api.services.impl;

import com.vitalvet.api.entity.Especie;
import com.vitalvet.api.repository.EspecieRepository;
import com.vitalvet.api.services.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EspecieServiceImpl extends ICRUDImpl<Especie, Long> implements EspecieService {

    @Autowired
    private EspecieRepository repository;

    @Override
    public JpaRepository<Especie, Long> getRepository() {
        return repository;
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return repository.existsByNombreEspecieIgnoreCase(nombre);
    }

    @Override
    public boolean existePorNombreYIdDiferente(String nombre, Long id) {
        return repository.existsByNombreEspecieIgnoreCaseAndIdEspecieNot(nombre, id);
    }
}