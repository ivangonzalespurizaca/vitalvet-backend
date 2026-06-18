package com.agenda.api.repository.custom;

import com.agenda.api.entity.ComprobantePago;
import com.agenda.api.entity.enums.TipoComprobante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ComprobanteRepositoryCustomImpl implements ComprobanteRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ComprobantePago> listarComprobantesConFiltros(Long idCliente, TipoComprobante tipo, LocalDate fechaInicio, LocalDate fechaFin) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ComprobantePago> cq = cb.createQuery(ComprobantePago.class);
        Root<ComprobantePago> root = cq.from(ComprobantePago.class);
        List<Predicate> predicates = new ArrayList<>();

        // Filtro por Cliente (Si es Admin viene null y se ignora; si es Cliente viene su ID)
        if (idCliente != null) {
            predicates.add(cb.equal(root.get("idCliente"), idCliente));
        }

        // Filtro por Tipo (BOLETA, FACTURA)
        if (tipo != null) {
            predicates.add(cb.equal(root.get("tipoDocumento"), tipo));
        }

        // Filtros de Fechas
        if (fechaInicio != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("fechaPago"), fechaInicio.atStartOfDay()));
        }
        if (fechaFin != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("fechaPago"), fechaFin.atTime(LocalTime.MAX)));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        cq.orderBy(cb.desc(root.get("fechaPago")));

        return em.createQuery(cq).getResultList();
    }
}