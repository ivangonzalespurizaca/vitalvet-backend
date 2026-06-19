package com.usuarios.api.services.impl;

import com.usuarios.api.client.PacienteClient;
import com.usuarios.api.entity.Persona;
import com.usuarios.api.repository.PersonaRepository;
import com.usuarios.api.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends ICRUDImpl<Persona, Long> implements PersonaService {

    @Autowired
    private PersonaRepository repo;

    @Autowired
    private PacienteClient pacienteClient;

    @Override
    public JpaRepository<Persona, Long> getRepository() {
        return repo;
    }

    @Override
    public List<Persona> buscarClientesPorFiltro(String texto) {
        return repo.buscarClientesPorFiltro(texto);
    }

    @Override
    public boolean existeDni(String dni) {
        return repo.existsByDni(dni);
    }

    @Override
    public Persona buscarPorDni(String dni) {
        return repo.findByDni(dni);
    }

    @Override
    public int obtenerTotalMascotas(Long id) {
        try {
            return pacienteClient.obtenerTotalMascotasPorCliente(id);
        } catch (Exception e) {
            return 0;
        }
    }
}
