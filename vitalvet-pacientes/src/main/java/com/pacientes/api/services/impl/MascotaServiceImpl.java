package com.pacientes.api.services.impl;

import com.pacientes.api.entity.Mascota;
import com.pacientes.api.repository.MascotaRepository;
import com.pacientes.api.services.MascotaService;
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
