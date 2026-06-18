package com.vitalvet.api.repository;

import com.vitalvet.api.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    int countByIdClienteAndActivoTrue(Long idCliente);
    @Query("SELECT m FROM Mascota m " +
            "JOIN FETCH m.raza r " +
            "JOIN FETCH r.especie e " +
            "WHERE m.idCliente = :idCliente AND m.activo = true")
    List<Mascota> findByIdClienteConRazaYEspecie(@Param("idCliente") Long idCliente);
}
