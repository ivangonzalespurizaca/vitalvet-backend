package com.usuarios.api.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {
    String subirFotoPerfil(MultipartFile archivo) throws IOException;
}
