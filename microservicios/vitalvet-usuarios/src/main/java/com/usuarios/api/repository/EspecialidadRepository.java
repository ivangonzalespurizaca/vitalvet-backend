package com.usuarios.api.repository;

import com.usuarios.api.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
    boolean existsByNombreEspecialidadIgnoreCase(String nombreEspecialidad);

    boolean existsByNombreEspecialidadIgnoreCaseAndIdEspecialidadNot(String nombreEspecialidad, Long id);
}
