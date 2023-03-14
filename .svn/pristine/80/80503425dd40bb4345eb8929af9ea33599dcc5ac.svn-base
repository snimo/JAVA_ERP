package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.AtributoEntidadSeleccionado;
import com.srn.erp.contabilidad.bm.CriterioSelCuenta;
import com.srn.erp.contabilidad.da.DBAtributoEntidadSeleccionado;
import com.srn.erp.general.bm.DefinicionAtributoEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAtributoEntidadSeleccionado extends FactoryObjetoLogico { 

  public FactoryAtributoEntidadSeleccionado() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AtributoEntidadSeleccionado atributoentidadseleccionado = (AtributoEntidadSeleccionado) objLog;
    atributoentidadseleccionado.setOID(db.getInteger(DBAtributoEntidadSeleccionado.OID_ATRI_ENT_SEL));
    atributoentidadseleccionado.setCriterio_seleccion_cta(CriterioSelCuenta.findByOidProxy(db.getInteger(DBAtributoEntidadSeleccionado.OID_CRI_SEL_CTA),getSesion()));
    atributoentidadseleccionado.setAtributo_entidad(DefinicionAtributoEntidad.findByOidProxy(db.getInteger(DBAtributoEntidadSeleccionado.OID_ATRI_ENT),getSesion()));
    atributoentidadseleccionado.setOrden(db.getInteger(DBAtributoEntidadSeleccionado.ORDEN));
  }
}
