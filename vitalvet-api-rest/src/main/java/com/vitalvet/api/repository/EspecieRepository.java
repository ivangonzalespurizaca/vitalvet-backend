package com.vitalvet.api.repository;

import com.vitalvet.api.entity.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {

    boolean existsByNombreEspecieIgnoreCase(String nombreEspecie);

    boolean existsByNombreEspecieIgnoreCaseAndIdEspecieNot(String nombreEspecie, Long id);
}