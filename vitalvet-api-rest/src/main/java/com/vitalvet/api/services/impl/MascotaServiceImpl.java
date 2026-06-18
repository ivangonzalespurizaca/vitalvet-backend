package com.vitalvet.api.services.impl;

import com.vitalvet.api.entity.Mascota;
import com.vitalvet.api.repository.MascotaRepository;
import com.vitalvet.api.services.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl extends ICRUDImpl<Mascota, Long> implements MascotaService {

    @Autowired
    private MascotaRepository repo;

    @Override
    public JpaRepository<Mascota, Long> getRepository() {
        return repo;
    }

    @Override
    public int contarPorIdCliente(Long id) {
        return repo.countByIdClienteAndActivoTrue(id);
    }

    @Override
    public List<Mascota> listarMascotasPorCliente(Long idCliente) {
        return repo.findByIdClienteConRazaYEspecie(idCliente);
    }
}
