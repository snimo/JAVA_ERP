package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AcuerdoLPDetalleDto;
import com.srn.erp.compras.bm.AcuerdoLPDetalleDtoCant;
import com.srn.erp.compras.da.DBAcuerdoLPDetalleDtoCant;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAcuerdoLPDetalleDtoCant extends FactoryObjetoLogico { 

  public FactoryAcuerdoLPDetalleDtoCant() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AcuerdoLPDetalleDtoCant acuerdolpdetalledtocant = (AcuerdoLPDetalleDtoCant) objLog;
    acuerdolpdetalledtocant.setOID(db.getInteger(DBAcuerdoLPDetalleDtoCant.OID_DTO_CANT));
    acuerdolpdetalledtocant.setAcu_lp_det_dto(AcuerdoLPDetalleDto.findByOidProxy(db.getInteger(DBAcuerdoLPDetalleDtoCant.OID_ACU_LP_DET_DTO),getSesion()));
    acuerdolpdetalledtocant.setCant_desde(db.getDouble(DBAcuerdoLPDetalleDtoCant.CANT_DESDE));
    acuerdolpdetalledtocant.setCant_hasta(db.getDouble(DBAcuerdoLPDetalleDtoCant.CANT_HASTA));
    acuerdolpdetalledtocant.setDto_1(db.getDouble(DBAcuerdoLPDetalleDtoCant.DTO_1));
    acuerdolpdetalledtocant.setDto_2(db.getDouble(DBAcuerdoLPDetalleDtoCant.DTO_2));
    acuerdolpdetalledtocant.setDto_3(db.getDouble(DBAcuerdoLPDetalleDtoCant.DTO_3));
    acuerdolpdetalledtocant.setDto_4(db.getDouble(DBAcuerdoLPDetalleDtoCant.DTO_4));
    acuerdolpdetalledtocant.setDto_5(db.getDouble(DBAcuerdoLPDetalleDtoCant.DTO_5));
    acuerdolpdetalledtocant.setEn_cascada(db.getBoolean(DBAcuerdoLPDetalleDtoCant.EN_CASCADA));
    acuerdolpdetalledtocant.setActivo(db.getBoolean(DBAcuerdoLPDetalleDtoCant.ACTIVO));

  }
}
