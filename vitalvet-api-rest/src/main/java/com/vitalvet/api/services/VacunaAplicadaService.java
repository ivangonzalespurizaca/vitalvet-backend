package com.vitalvet.api.services;

import com.vitalvet.api.dto.CarnetVacunaDTO;
import com.vitalvet.api.dto.VacunaAplicadaDTO;
import com.vitalvet.api.dto.VacunaRegistroRequestDTO;
import com.vitalvet.api.dto.VacunaResponseDTO;
import com.vitalvet.api.entity.Raza;
import com.vitalvet.api.entity.VacunaAplicada;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VacunaAplicadaService extends ICRUD<VacunaAplicada, Long>{
    VacunaAplicada registrarVacunaManual(VacunaRegistroRequestDTO dto, Long idMascota);

    @Transactional(rollbackFor = Exception.class)
    void confirmarAplicacionVacuna(Long idAplicacion, Long idConsulta);

    CarnetVacunaDTO obtenerCarnetCompletoPorMascota(Long idMascota, String estadoFiltro);
}
