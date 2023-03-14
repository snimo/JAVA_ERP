package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Estructura;
import com.srn.erp.contabilidad.bm.EstructuraCompo;
import com.srn.erp.contabilidad.da.DBEstructuraCompo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstructuraCompo extends FactoryObjetoLogico {

  public FactoryEstructuraCompo() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstructuraCompo estructuracompo = (EstructuraCompo) objLog;
    estructuracompo.setOID(db.getInteger(DBEstructuraCompo.OID_ESTRUC_COMPO));
    estructuracompo.setEstructura(Estructura.findByOidProxy(db.getInteger(DBEstructuraCompo.OID_ESTRUC),getSesion()));
    estructuracompo.setSecu(db.getInteger(DBEstructuraCompo.SECU));
    estructuracompo.setComponente(Componente.findByOidProxy(db.getInteger(DBEstructuraCompo.OID_COMPO),getSesion()));
    estructuracompo.setActivo(db.getBoolean(DBEstructuraCompo.ACTIVO));
    if ((estructuracompo.getComponente()!=null) && 
    	(db.getInteger(DBEstructuraCompo.OID_VALOR_DEFAULT)!=null) &&
    	(db.getInteger(DBEstructuraCompo.OID_VALOR_DEFAULT).intValue()>0)
    	) {
    	estructuracompo.setValorDefault(estructuracompo.getComponente().getValorCompo(db.getInteger(DBEstructuraCompo.OID_VALOR_DEFAULT)));
    } else
    	estructuracompo.setValorDefault(null);

  }
}
