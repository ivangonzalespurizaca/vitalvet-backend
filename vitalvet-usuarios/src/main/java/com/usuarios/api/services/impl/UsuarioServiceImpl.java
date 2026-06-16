package com.usuarios.api.services.impl;

import com.usuarios.api.entity.Usuario;
import com.usuarios.api.repository.UsuarioRepository;
import com.usuarios.api.services.UsuarioService;
import com.usuarios.api.utils.ModeloNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends ICRUDImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public JpaRepository<Usuario, Long> getRepository() {
        return repo;
    }

    @Override
    public Usuario buscarPorEmail(String email){
        return repo.findByEmail(email)
                .orElseThrow(() -> new ModeloNotFoundException("Usuario no encontrado"));
    }
}
