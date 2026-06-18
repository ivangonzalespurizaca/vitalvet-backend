package com.vitalvet.api.mapper;

import com.vitalvet.api.dto.MascotaResponseDTO;
import com.vitalvet.api.dto.MascotaRequestDTO;
import com.vitalvet.api.entity.Mascota;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MascotaMapper {
    @Mapping(target = "idMascota", ignore = true)
    @Mapping(target = "raza", ignore = true)
    @Mapping(target = "codigoMascota", ignore = true)
    @Mapping(target = "vacunasAplicadas", ignore = true)
    Mascota toEntity(MascotaRequestDTO dto);

    @AfterMapping
    default void generarCamposAutomaticos(MascotaRequestDTO dto, @MappingTarget Mascota mascota) {
        mascota.setCodigoMascota("MAS-" + dto.getIdCliente() + "-" + System.currentTimeMillis());
        mascota.setActivo(true);
    }

    @Mapping(target = "idRaza", source = "mascota.raza.idRaza")
    @Mapping(target = "nombreRaza", source = "mascota.raza.nombreRaza")
    @Mapping(target = "idEspecie", source = "mascota.raza.especie.idEspecie")
    @Mapping(target = "nombreEspecie", source = "mascota.raza.especie.nombreEspecie")
    MascotaResponseDTO toResponseDTO(Mascota mascota);

    @Mapping(target = "idMascota", ignore = true)
    @Mapping(target = "codigoMascota", ignore = true)
    @Mapping(target = "idCliente", ignore = true)
    @Mapping(target = "raza", ignore = true)
    @Mapping(target = "vacunasAplicadas", ignore = true)
    @Mapping(target = "activo", ignore = true)
    void updateEntityFromRequestDto(MascotaRequestDTO dto, @MappingTarget Mascota mascota);
}
