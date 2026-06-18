package com.agenda.api.entity;

import com.agenda.api.entity.enums.TipoEstadoCita;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "cita", schema = "agenda")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCita;

    @Column(name = "codigo_cita", nullable = false, unique = true, length = 20)
    private String codigoCita;

    @Column(name = "id_mascota", nullable = false)
    private Long idMascota;

    @Column(name = "id_veterinario", nullable = false)
    private Long idVeterinario;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(length = 255)
    private String motivo;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 30)
    @Builder.Default
    private TipoEstadoCita estado = TipoEstadoCita.PAGADA;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @JsonIgnore
    @OneToOne(mappedBy = "cita", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ComprobantePago comprobantePago;
}