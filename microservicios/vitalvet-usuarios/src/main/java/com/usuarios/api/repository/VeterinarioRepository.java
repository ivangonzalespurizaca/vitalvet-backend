package com.usuarios.api.repository;

import com.usuarios.api.entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    @Query("SELECT v FROM Veterinario v " +
            "JOIN FETCH v.persona p " +
            "JOIN FETCH v.especialidad e " +
            "LEFT JOIN FETCH p.usuario u " +
            "WHERE (:criterio IS NULL OR :criterio = '' " +
            "OR LOWER(p.dni) LIKE LOWER(CONCAT('%', :criterio, '%')) " +
            "OR LOWER(p.nombres) LIKE LOWER(CONCAT('%', :criterio, '%')) " +
            "OR LOWER(p.apellidos) LIKE LOWER(CONCAT('%', :criterio, '%')))")
    List<Veterinario> buscarPorCriterio(@Param("criterio") String criterio);

    @Query("SELECT v FROM Veterinario v " +
            "JOIN FETCH v.persona p " +
            "JOIN FETCH v.especialidad e " +
            "WHERE p.activo = true")
    List<Veterinario> listarActivos();

    boolean existsByNumColegiatura(String numColegiatura);
}
