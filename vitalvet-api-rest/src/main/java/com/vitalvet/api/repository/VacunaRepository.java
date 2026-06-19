package com.vitalvet.api.repository;

import com.vitalvet.api.entity.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacunaRepository extends JpaRepository<Vacuna, Long> {
    boolean existsByNombreVacunaIgnoreCase(String nombreVacuna);

    boolean existsByNombreVacunaIgnoreCaseAndIdVacunaNot(String nombreVacuna, Long id);
}
