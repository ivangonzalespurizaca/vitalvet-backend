package com.usuarios.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistroRapidoDTO {
    @NotNull
    @Valid
    private PersonaRequestDTO datosCliente;

    @NotNull
    @Valid
    private MascotaRequestDTO datosMascota;
}
