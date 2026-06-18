package com.usuarios.api.services;

import com.usuarios.api.dto.LoginRequestDTO;
import com.usuarios.api.dto.PersonaRequestDTO;
import com.usuarios.api.dto.RegistroClienteRequestDTO;
import com.usuarios.api.entity.Persona;

public interface AuthService {
    String login(LoginRequestDTO loginRequestDTO);
    Persona registrarCliente(PersonaRequestDTO dto);
    void procesarSolicitudRecuperacion(String email);
    void cambiarContraseniaOlvidada(String token, String nuevaContrasenia);
}
