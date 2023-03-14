package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.CtaBancoLiqTarj;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.da.DBCtaBancoLiqTarj;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCtaBancoLiqTarj extends FactoryObjetoLogico { 

  public FactoryCtaBancoLiqTarj() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CtaBancoLiqTarj ctabancoliqtarj = (CtaBancoLiqTarj) objLog;
    ctabancoliqtarj.setOID(db.getInteger(DBCtaBancoLiqTarj.OID_CTA_BANCO));
    ctabancoliqtarj.setCodigo(db.getString(DBCtaBancoLiqTarj.CODIGO));
    ctabancoliqtarj.setDescripcion(db.getString(DBCtaBancoLiqTarj.DESCRIPCION));
    ctabancoliqtarj.setCod_interfaz(db.getString(DBCtaBancoLiqTarj.COD_INTERFAZ));
    ctabancoliqtarj.setActivo(db.getBoolean(DBCtaBancoLiqTarj.ACTIVO));
    ctabancoliqtarj.setEmpresa(EmpresaConciTar.findByOidProxy(db.getInteger(DBCtaBancoLiqTarj.OID_EMPRESA), this.getSesion()));

  }
}
