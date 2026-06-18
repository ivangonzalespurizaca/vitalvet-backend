package com.usuarios.api.controller;

import com.usuarios.api.services.CloudinaryService;
import com.usuarios.api.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/media/perfil")
public class MediaController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<Map<String, String>>> subirArchivo(
            @RequestPart("archivo") MultipartFile archivo) throws Exception {

        String urlSegura = cloudinaryService.subirFotoPerfil(archivo);
        Map<String, String> data = Map.of("urlFoto", urlSegura);

        return ResponseEntity.ok(new ApiResponse<>(
                true, "¡Imagen subida a la nube con éxito!", data
        ));
    }
}