package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.CabAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.DetAsiLiquiTarj;
import com.srn.erp.conciTarjeta.da.DBDetAsiLiquiTarj;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDetAsiLiquiTarj extends FactoryObjetoLogico { 

  public FactoryDetAsiLiquiTarj() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DetAsiLiquiTarj detasiliquitarj = (DetAsiLiquiTarj) objLog;
    detasiliquitarj.setOID(db.getInteger(DBDetAsiLiquiTarj.OID_DET_ASI_LIQ));
    detasiliquitarj.setCabasiliqtarj(CabAsiLiquiTarj.findByOidProxy(db.getInteger(DBDetAsiLiquiTarj.OID_CAB_ASI_LIQ),getSesion()));
    detasiliquitarj.setOrden(db.getInteger(DBDetAsiLiquiTarj.ORDEN));
    detasiliquitarj.setCuenta(db.getString(DBDetAsiLiquiTarj.CUENTA));
    detasiliquitarj.setDesc_cuenta(db.getString(DBDetAsiLiquiTarj.DESC_CUENTA));
    detasiliquitarj.setCompo1(db.getString(DBDetAsiLiquiTarj.COMPO1));
    detasiliquitarj.setCompo2(db.getString(DBDetAsiLiquiTarj.COMPO2));
    detasiliquitarj.setDebe(db.getDouble(DBDetAsiLiquiTarj.DEBE));
    detasiliquitarj.setHaber(db.getDouble(DBDetAsiLiquiTarj.HABER));
    detasiliquitarj.setActivo(db.getBoolean(DBDetAsiLiquiTarj.ACTIVO));
    detasiliquitarj.setComentario(db.getString(DBDetAsiLiquiTarj.COMENTARIO));
    detasiliquitarj.setCodImpuesto(db.getString(DBDetAsiLiquiTarj.COD_IMPUESTO));
    detasiliquitarj.setPorcImpuesto(db.getDouble(DBDetAsiLiquiTarj.PORC_IMPUESTO));
    detasiliquitarj.setBaseImpuesto(db.getDouble(DBDetAsiLiquiTarj.BASE));
    

  }
}
