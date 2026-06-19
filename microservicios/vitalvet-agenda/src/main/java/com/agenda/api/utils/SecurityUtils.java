package com.agenda.api.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;

public class SecurityUtils {

    private SecurityUtils() {
        throw new IllegalStateException("Clase Utilitaria de Seguridad");
    }

    public static Long extraerIdVeterinario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getDetails() instanceof Map<?, ?> claims) {
            Object idVet = claims.containsKey("idVeterinario") ? claims.get("idVeterinario") : claims.get("idveterinario");
            if (idVet != null) {
                return Long.valueOf(idVet.toString());
            }

            Object idPersona = claims.containsKey("idPersona") ? claims.get("idPersona") : claims.get("idpersona");
            if (idPersona != null) {
                return Long.valueOf(idPersona.toString());
            }
        }
        return null;
    }

    public static Long extraerIdCliente() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getDetails() instanceof Map<?, ?> claims) {
            Object idPersona = claims.containsKey("idPersona") ? claims.get("idPersona") : claims.get("idpersona");
            if (idPersona != null) {
                return Long.valueOf(idPersona.toString());
            }
        }
        return null;
    }
}