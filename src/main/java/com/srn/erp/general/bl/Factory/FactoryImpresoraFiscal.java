package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.ImpresoraFiscal;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.general.da.DBImpresoraFiscal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryImpresoraFiscal extends FactoryObjetoLogico {

  public FactoryImpresoraFiscal() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ImpresoraFiscal impresorafiscal = (ImpresoraFiscal) objLog;
    impresorafiscal.setOID(db.getInteger(DBImpresoraFiscal.OID_IMP_FISCAL));
    impresorafiscal.setCodigo(db.getString(DBImpresoraFiscal.CODIGO));
    impresorafiscal.setDescripcion(db.getString(DBImpresoraFiscal.DESCRIPCION));
    impresorafiscal.setCompo_imp_fiscal(db.getString(DBImpresoraFiscal.COMPO_IMP_FISCAL));
    impresorafiscal.setActivo(db.getBoolean(DBImpresoraFiscal.ACTIVO));
    impresorafiscal.setUnidadOrganizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBImpresoraFiscal.OID_UNI_ORG),getSesion()));
    impresorafiscal.setPuerto(db.getInteger(DBImpresoraFiscal.PUERTO));
    impresorafiscal.setBaudios(db.getInteger(DBImpresoraFiscal.BAUDIOS));
    impresorafiscal.setDriver(db.getString(DBImpresoraFiscal.DRIVER));
    impresorafiscal.setComportamiento(db.getString(DBImpresoraFiscal.COMPO_IMPRESION));
    impresorafiscal.setPathGenArchivo(db.getString(DBImpresoraFiscal.PATH_GEN_ARCH_IMP));
    
    
  }
}
