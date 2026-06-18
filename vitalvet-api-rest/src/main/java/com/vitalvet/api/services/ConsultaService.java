package com.vitalvet.api.services;

import com.vitalvet.api.entity.Consulta;

import java.util.Optional;

public interface ConsultaService extends ICRUD<Consulta, Long>{
    Optional<Consulta> buscarPorIdCita (Long idCita);
}