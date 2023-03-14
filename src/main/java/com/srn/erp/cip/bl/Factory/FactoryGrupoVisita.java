package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.GrupoVisita;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.da.DBGrupoVisita;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoVisita extends FactoryObjetoLogico { 

  public FactoryGrupoVisita() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoVisita grupovisita = (GrupoVisita) objLog;
    grupovisita.setOID(db.getInteger(DBGrupoVisita.OID_GRUPO_VISITA));
    grupovisita.setCodigo(db.getString(DBGrupoVisita.CODIGO));
    grupovisita.setDescripcion(db.getString(DBGrupoVisita.DESCRIPCION));
    grupovisita.setActivo(db.getBoolean(DBGrupoVisita.ACTIVO));
    grupovisita.setAntiPassBack(db.getBoolean(DBGrupoVisita.ANTIPASSBACK));
    grupovisita.setGrupoPuertaIngreso(GrupoPuerta.findByOidProxy(db.getInteger(DBGrupoVisita.OID_GRU_PUE_ING), this.getSesion()));
    grupovisita.setGrupoPuertaEgreso(GrupoPuerta.findByOidProxy(db.getInteger(DBGrupoVisita.OID_GRU_PUE_EGR), this.getSesion()));
    grupovisita.setVisitaA(Legajo.findByOidProxy(db.getInteger(DBGrupoVisita.OID_VISITA_A), this.getSesion()));
    grupovisita.setAutoriza(Legajo.findByOidProxy(db.getInteger(DBGrupoVisita.OID_AUTORIZA), this.getSesion()));
    grupovisita.setPermisoSemanal(PermisoSemanalCIP.findByOidProxy(db.getInteger(DBGrupoVisita.OID_PERMISO_SEM), this.getSesion()));
    grupovisita.setAplicVigencia(db.getBoolean(DBGrupoVisita.APLIC_VIGENCIA));
    grupovisita.setFecDesdeVig(db.getDate(DBGrupoVisita.FEC_DESDE_VIG));
    grupovisita.setFecHastaVig(db.getDate(DBGrupoVisita.FEC_HASTA_VIG));
    grupovisita.setCategAcceso(CategAccesoCIP.findByOidProxy(db.getInteger(DBGrupoVisita.OID_CATEG_ACC_INT), this.getSesion()));
  }
}
