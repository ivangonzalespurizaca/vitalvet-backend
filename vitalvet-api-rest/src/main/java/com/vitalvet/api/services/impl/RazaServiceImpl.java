package com.vitalvet.api.services.impl;

import com.vitalvet.api.entity.Raza;
import com.vitalvet.api.repository.RazaRepository;
import com.vitalvet.api.services.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RazaServiceImpl extends ICRUDImpl<Raza, Long> implements RazaService {

    @Autowired
    private RazaRepository repo;

    @Override
    public JpaRepository<Raza, Long> getRepository() {
        return repo;
    }

}
