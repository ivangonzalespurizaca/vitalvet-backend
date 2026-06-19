package com.vitalvet.api.http.response;

import com.vitalvet.api.dto.MascotaResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MascotasResponse{
    private Long idPersona;
    private String nombres;
    private String apellidos;
    private String email;
    private String dni;
    private String celular;
    private int totalMascotas;

    private List<MascotaResponseDTO> mascotas;
}