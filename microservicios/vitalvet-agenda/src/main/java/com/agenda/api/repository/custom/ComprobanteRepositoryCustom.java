package com.agenda.api.repository.custom;

import com.agenda.api.entity.ComprobantePago;
import com.agenda.api.entity.enums.TipoComprobante;
import java.time.LocalDateTime;
import java.util.List;

public interface ComprobanteRepositoryCustom {
    List<ComprobantePago> listarComprobantesConFiltros(Long idCliente, TipoComprobante tipo, LocalDateTime inicio, LocalDateTime fin);
}