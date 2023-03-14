package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.ImpresoraComun;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.general.da.DBImpresoraComun;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryImpresoraComun extends FactoryObjetoLogico {

  public FactoryImpresoraComun() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ImpresoraComun impresoracomun = (ImpresoraComun) objLog;
    impresoracomun.setOID(db.getInteger(DBImpresoraComun.OID_IMP_COMUN));
    impresoracomun.setCodigo(db.getString(DBImpresoraComun.CODIGO));
    impresoracomun.setDescripcion(db.getString(DBImpresoraComun.DESCRIPCION));
    impresoracomun.setImpresora_sistema(db.getString(DBImpresoraComun.IMPRESORA_SISTEMA));
    impresoracomun.setActivo(db.getBoolean(DBImpresoraComun.ACTIVO));
    impresoracomun.setUnidadOrganizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBImpresoraComun.UNI_ORG),getSesion()));
  }
}
