package com.usuarios.api.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.usuarios.api.services.CloudinaryService;
import com.usuarios.api.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String subirFotoPerfil(MultipartFile archivo) throws IOException {
        if (archivo.isEmpty()) {
            throw new BusinessException("El archivo seleccionado está vacío.");
        }

        Map opciones = ObjectUtils.asMap(
                "folder", "vitalvet/perfiles",
                "resource_type", "image"
        );

        Map resultado = cloudinary.uploader().upload(archivo.getBytes(), opciones);

        return (String) resultado.get("secure_url");
    }
}
