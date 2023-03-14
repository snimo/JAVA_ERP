package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AcuerdoLPDetalle;
import com.srn.erp.compras.bm.AcuerdoLPDetalleDto;
import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.da.DBAcuerdoLPDetalleDto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAcuerdoLPDetalleDto extends FactoryObjetoLogico { 

  public FactoryAcuerdoLPDetalleDto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AcuerdoLPDetalleDto acuerdolpdetalledto = (AcuerdoLPDetalleDto) objLog;
    acuerdolpdetalledto.setOID(db.getInteger(DBAcuerdoLPDetalleDto.OID_ACU_LP_DET_DTO));
    acuerdolpdetalledto.setAcuerdo_lp_detalle(AcuerdoLPDetalle.findByOidProxy(db.getInteger(DBAcuerdoLPDetalleDto.OID_ACU_LP_DET),getSesion()));
    acuerdolpdetalledto.setCondicion_pago(CondicionCompra.findByOidProxy(db.getInteger(DBAcuerdoLPDetalleDto.OID_COND_COMPRA),getSesion()));
    acuerdolpdetalledto.setDto_1(db.getDouble(DBAcuerdoLPDetalleDto.DTO_1));
    acuerdolpdetalledto.setDto_2(db.getDouble(DBAcuerdoLPDetalleDto.DTO_2));
    acuerdolpdetalledto.setDto_3(db.getDouble(DBAcuerdoLPDetalleDto.DTO_3));
    acuerdolpdetalledto.setDto_4(db.getDouble(DBAcuerdoLPDetalleDto.DTO_4));
    acuerdolpdetalledto.setDto_5(db.getDouble(DBAcuerdoLPDetalleDto.DTO_5));
    acuerdolpdetalledto.setTipo_dto(db.getString(DBAcuerdoLPDetalleDto.TIPO_DTO));
    acuerdolpdetalledto.setEn_cascada(db.getBoolean(DBAcuerdoLPDetalleDto.EN_CASCADA));
    acuerdolpdetalledto.setActivo(db.getBoolean(DBAcuerdoLPDetalleDto.ACTIVO));

  }
}
