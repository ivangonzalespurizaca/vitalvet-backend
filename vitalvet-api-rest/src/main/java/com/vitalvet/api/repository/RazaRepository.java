package com.vitalvet.api.repository;

import com.vitalvet.api.entity.Raza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazaRepository extends JpaRepository<Raza, Long> {
    boolean existsByNombreRazaIgnoreCaseAndEspecieIdEspecie(String nombreRaza, Long idEspecie);

    boolean existsByNombreRazaIgnoreCaseAndEspecieIdEspecieAndIdRazaNot(String nombreRaza, Long idEspecie, Long idRaza);
}
