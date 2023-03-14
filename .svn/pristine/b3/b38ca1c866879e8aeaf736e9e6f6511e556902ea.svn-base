package com.srn.erp.estadisticaRaciones.bl.Factory;

import com.srn.erp.estadisticaRaciones.bm.EmpresaRaciones;
import com.srn.erp.estadisticaRaciones.da.DBEmpresaRaciones;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEmpresaRaciones extends FactoryObjetoLogico { 

  public FactoryEmpresaRaciones() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EmpresaRaciones empresaraciones = (EmpresaRaciones) objLog;
    empresaraciones.setOid(1);
    empresaraciones.setCodigo(db.getString(DBEmpresaRaciones.CODIGO));
    empresaraciones.setDescripcion(db.getString(DBEmpresaRaciones.DESCRIPCION));
    empresaraciones.setActivo(true);
  }
  
}
