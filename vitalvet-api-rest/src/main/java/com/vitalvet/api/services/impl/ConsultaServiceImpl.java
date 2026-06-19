package com.vitalvet.api.services.impl;

import com.vitalvet.api.client.AgendaClient;
import com.vitalvet.api.dto.ConsultaRequestDTO;
import com.vitalvet.api.dto.VacunaAplicadaDTO;
import com.vitalvet.api.entity.Consulta;
import com.vitalvet.api.entity.Vacuna;
import com.vitalvet.api.entity.VacunaAplicada;
import com.vitalvet.api.entity.enums.EstadoVacuna;
import com.vitalvet.api.repository.ConsultaRepository;
import com.vitalvet.api.repository.MascotaRepository;
import com.vitalvet.api.repository.VacunaAplicadaRepository;
import com.vitalvet.api.services.ConsultaService;
import com.vitalvet.api.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ConsultaServiceImpl extends ICRUDImpl<Consulta, Long> implements ConsultaService{

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private VacunaAplicadaRepository vacunaAplicadaRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private AgendaClient agendaClient;

    @Override
    public JpaRepository<Consulta, Long> getRepository() {
        return consultaRepository;
    }

    @Override
    public Optional<Consulta> buscarPorIdCita(Long idCita) {
        return consultaRepository.findByIdCita(idCita);
    }

    @Override
    public Consulta registrarConsultaClinica(ConsultaRequestDTO dto, Long idMascota) {

        if (consultaRepository.existsByIdCita(dto.getIdCita())) {
            throw new BusinessException("Operación Denegada: Esta cita ya cuenta con un historial médico registrado.");
        }

        Consulta consulta = new Consulta();
        consulta.setIdCita(dto.getIdCita());
        consulta.setIdVeterinario(dto.getIdVeterinario());
        consulta.setPesoActual(dto.getPesoActual());
        consulta.setTemperatura(dto.getTemperatura());
        consulta.setDiagnostico(dto.getDiagnostico());
        consulta.setRecomendaciones(dto.getRecomendaciones());

        Consulta consultaGuardada = consultaRepository.save(consulta);

        if (dto.getVacunas() != null && !dto.getVacunas().isEmpty()) {
            for (VacunaAplicadaDTO vDto : dto.getVacunas()) {
                VacunaAplicada vacunaAplicada = new VacunaAplicada();
                vacunaAplicada.setFechaAplicacion(LocalDate.now());
                vacunaAplicada.setProximaDosis(vDto.getProximaDosis());
                vacunaAplicada.setNroDosis(vDto.getNroDosis() != null ? vDto.getNroDosis() : "1ra Dosis");
                vacunaAplicada.setEstado(EstadoVacuna.APLICADA);

                com.vitalvet.api.entity.Mascota mascotaProxy = new com.vitalvet.api.entity.Mascota();
                mascotaProxy.setIdMascota(idMascota);
                vacunaAplicada.setMascota(mascotaProxy);

                Vacuna vacuna = new Vacuna();
                vacuna.setIdVacuna(vDto.getIdVacuna());
                vacunaAplicada.setVacuna(vacuna);

                vacunaAplicada.setConsulta(consultaGuardada);

                vacunaAplicadaRepository.save(vacunaAplicada);
            }
        }

        if (dto.getPesoActual() != null) {
            mascotaRepository.actualizarPesoMascota(idMascota, dto.getPesoActual());
        }

        try {
            agendaClient.completarCitaInterno(dto.getIdCita());
        } catch (Exception e) {
            System.err.println("Error al actualizar el estado de la cita vía Feign: " + e.getMessage());
        }

        return consultaGuardada;
    }
}