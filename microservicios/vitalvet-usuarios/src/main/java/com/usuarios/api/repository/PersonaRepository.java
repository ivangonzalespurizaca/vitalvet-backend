package com.usuarios.api.repository;

import com.usuarios.api.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query("SELECT p FROM Persona p WHERE p.rol = Rol.CLIENTE " +
            "AND (:texto IS NULL OR :texto = '' " +
            "OR LOWER(p.dni) LIKE LOWER(CONCAT('%', :texto, '%')) " +
            "OR LOWER(p.nombres) LIKE LOWER(CONCAT('%', :texto, '%')) " +
            "OR LOWER(p.apellidos) LIKE LOWER(CONCAT('%', :texto, '%')))")
    List<Persona> buscarClientesPorFiltro(@Param("texto") String texto);

    boolean existsByDni(String dni);

    Persona findByDni(String dni);

}
