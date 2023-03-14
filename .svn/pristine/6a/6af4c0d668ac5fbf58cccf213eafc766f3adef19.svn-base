package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.da.DBEstadoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoExcluido extends FactoryObjetoLogico { 

  public FactoryEstadoExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoExcluido estadoexcluido = (EstadoExcluido) objLog;
    estadoexcluido.setOID(db.getInteger(DBEstadoExcluido.OID_ESTADO));
    estadoexcluido.setCodigo(db.getString(DBEstadoExcluido.CODIGO));
    estadoexcluido.setDescripcion(db.getString(DBEstadoExcluido.DESCRIPCION));
    estadoexcluido.setPeso(db.getInteger(DBEstadoExcluido.PESO));
    estadoexcluido.setColor(db.getString(DBEstadoExcluido.COLOR));
    estadoexcluido.setActivo(db.getBoolean(DBEstadoExcluido.ACTIVO));
    estadoexcluido.setProponerNro(db.getBoolean(DBEstadoExcluido.PROPONER_NRO));
    estadoexcluido.setUltNroPropuesto(db.getInteger(DBEstadoExcluido.ULT_NRO_PROPU));
    estadoexcluido.setNroActaObligatorio(db.getBoolean(DBEstadoExcluido.NRO_ACTA_OBLI));
    estadoexcluido.setPermiteModifNro(db.getBoolean(DBEstadoExcluido.PERMITE_MODIF_NRO));
    estadoexcluido.setConservaNro(db.getBoolean(DBEstadoExcluido.CONSERVA_NRO));
    estadoexcluido.setPublicarEnFiltro(db.getBoolean(DBEstadoExcluido.PUBLICAR_EN_FILTRO));
    estadoexcluido.setRestriccionAcceso(db.getBoolean(DBEstadoExcluido.RESTRICCION_ACCESO));
  }
}
