package com.agenda.api.repository.custom;

import com.agenda.api.entity.ComprobantePago;
import com.agenda.api.entity.enums.TipoComprobante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ComprobanteRepositoryCustomImpl implements ComprobanteRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ComprobantePago> listarComprobantesConFiltros(Long idCliente, TipoComprobante tipo, LocalDateTime inicio, LocalDateTime fin) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ComprobantePago> cq = cb.createQuery(ComprobantePago.class);
        Root<ComprobantePago> root = cq.from(ComprobantePago.class);
        List<Predicate> predicates = new ArrayList<>();

        if (idCliente != null) {
            predicates.add(cb.equal(root.get("idCliente"), idCliente));
        }
        if (tipo != null) {
            predicates.add(cb.equal(root.get("tipoDocumento"), tipo));
        }
        if (inicio != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("fechaPago"), inicio));
        }
        if (fin != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("fechaPago"), fin));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        cq.orderBy(cb.desc(root.get("fechaPago")));

        return em.createQuery(cq).getResultList();
    }
}