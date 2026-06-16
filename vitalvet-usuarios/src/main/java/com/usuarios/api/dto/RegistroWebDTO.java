package com.usuarios.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistroWebDTO {
    @NotNull
    @Valid
    private RegistroClienteRequestDTO datosCliente;

    @NotNull
    @Valid
    private MascotaRequestDTO datosMascota;
}
