package com.auditoria.api.controller;

import com.auditoria.api.documentos.AuditoriaDocument;
import com.auditoria.api.dtos.LogBusqueda;
import com.auditoria.api.service.AuditoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/logs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuditoriaController {


    private final AuditoriaService auditoriaService;

    @GetMapping("/buscar")
    public ResponseEntity<List<AuditoriaDocument>> buscarLogs(LogBusqueda criteria) {

        List<AuditoriaDocument> resultados = auditoriaService.filtros(
                criteria.getUsuarioOrId(),
                criteria.getModulo(),
                criteria.getAccion(),
                criteria.getFecha()
        );

        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AuditoriaDocument>>listdo(){
        List<AuditoriaDocument> lista =auditoriaService.listar();
        return ResponseEntity.ok(lista);
    }

}