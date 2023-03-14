package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.CabModeloLiq;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.TarjModeloLiq;
import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;
import com.srn.erp.conciTarjeta.da.DBTarjModeloLiq;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTarjModeloLiq extends FactoryObjetoLogico { 

  public FactoryTarjModeloLiq() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TarjModeloLiq tarjmodeloliq = (TarjModeloLiq) objLog;
    tarjmodeloliq.setOID(db.getInteger(DBTarjModeloLiq.OID_TARJ_MOD_LIQ));
    tarjmodeloliq.setTarjeta(TarjetaConciTar.findByOidProxy(db.getInteger(DBTarjModeloLiq.OID_TAR_CONCI),getSesion()));
    tarjmodeloliq.setEmpresa(EmpresaConciTar.findByOidProxy(db.getInteger(DBTarjModeloLiq.OID_EMPRESA),getSesion()));
    tarjmodeloliq.setModelo_liquidacion(CabModeloLiq.findByOidProxy(db.getInteger(DBTarjModeloLiq.OID_MODELO_LIQ),getSesion()));
    tarjmodeloliq.setActivo(db.getBoolean(DBTarjModeloLiq.ACTIVO));

  }
}
