package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.SeguridadEmpresaPredio;
import com.srn.erp.excluidos.da.DBSeguridadEmpresaPredio;
import com.srn.erp.general.bm.Empresa;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;

public class FactorySeguridadEmpresaPredio extends FactoryObjetoLogico { 

  public FactorySeguridadEmpresaPredio() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SeguridadEmpresaPredio seguridadempresapredio = (SeguridadEmpresaPredio) objLog;
    seguridadempresapredio.setOID(db.getInteger(DBSeguridadEmpresaPredio.OID_SEG_EMP_PREDIO));
    seguridadempresapredio.setPerfil(PerfilFuncional.findByOidProxy(db.getInteger(DBSeguridadEmpresaPredio.OID_PERFIL),getSesion()));
    seguridadempresapredio.setEmpresa(Empresa.findByOidProxy(db.getInteger(DBSeguridadEmpresaPredio.OID_EMPRESA),getSesion()));
    seguridadempresapredio.setActivo(db.getBoolean(DBSeguridadEmpresaPredio.ACTIVO));

  }
}
