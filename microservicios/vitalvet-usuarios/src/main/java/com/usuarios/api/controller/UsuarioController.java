package com.usuarios.api.controller;

import com.usuarios.api.config.JwtUtil;
import com.usuarios.api.dto.PerfilRequestDTO;
import com.usuarios.api.dto.PerfilResponseDTO;
import com.usuarios.api.entity.Persona;
import com.usuarios.api.entity.Usuario;
import com.usuarios.api.mapper.PersonaMapper;
import com.usuarios.api.services.PersonaService;
import com.usuarios.api.services.UsuarioService;
import com.usuarios.api.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private PersonaService personaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PersonaMapper personaMapper;

    @Autowired
    private JwtUtil jwtService;

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/actualizar")
    public ResponseEntity<ApiResponse<Map<String, Object>>> actualizarPerfil(
            @Valid @RequestBody PerfilRequestDTO perfilRequestDTO,
            Authentication authentication) throws Exception {

        String emailLogueado = authentication.getName();
        Usuario usuario = usuarioService.buscarPorEmail(emailLogueado);

        Persona persona = usuario.getPersona();
        personaMapper.updatePersonaFromDto(perfilRequestDTO, persona);
        personaService.actualizar(persona);

        PerfilResponseDTO responseDTO = personaMapper.toResponseDTO(persona, usuario);

        String nuevoToken = jwtService.generarToken(usuario);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("perfil", responseDTO);
        responseData.put("token", nuevoToken);

        ApiResponse<Map<String, Object>> response = new ApiResponse<>(true, "¡Perfil actualizado exitosamente!", responseData);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
