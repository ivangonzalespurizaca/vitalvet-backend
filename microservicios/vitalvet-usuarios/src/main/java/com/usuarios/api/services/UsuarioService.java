package com.usuarios.api.services;

import com.usuarios.api.entity.Usuario;

import java.util.Optional;

public interface UsuarioService extends ICRUD<Usuario, Long> {
    Usuario buscarPorEmail(String email);
}
