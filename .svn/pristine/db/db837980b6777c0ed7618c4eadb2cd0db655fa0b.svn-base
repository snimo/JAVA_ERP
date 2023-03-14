package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.EstadoIndividuoPredio;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.NovedadExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.da.DBEstadoIndividuoPredio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoIndividuoPredio extends FactoryObjetoLogico { 

  public FactoryEstadoIndividuoPredio() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoIndividuoPredio estadoindividuopredio = (EstadoIndividuoPredio) objLog;
    estadoindividuopredio.setOID(db.getInteger(DBEstadoIndividuoPredio.OID_EST_IND_PREDIO));
    estadoindividuopredio.setPredio(PredioExcluido.findByOidProxy(db.getInteger(DBEstadoIndividuoPredio.OID_PREDIO),getSesion()));
    estadoindividuopredio.setIndividuo(IndividuoExcluido.findByOidProxy(db.getInteger(DBEstadoIndividuoPredio.OID_INDIVIDUO),getSesion()));
    estadoindividuopredio.setEstado(EstadoExcluido.findByOidProxy(db.getInteger(DBEstadoIndividuoPredio.OID_ESTADO),getSesion()));
    estadoindividuopredio.setEstado_anterior(EstadoExcluido.findByOidProxy(db.getInteger(DBEstadoIndividuoPredio.OID_ESTADO_ANT),getSesion()));
    estadoindividuopredio.setFec_estado(db.getDate(DBEstadoIndividuoPredio.FEC_ESTADO));
    estadoindividuopredio.setFec_hora_estado(db.getDate(DBEstadoIndividuoPredio.FEC_HORA_ESTADO));
    estadoindividuopredio.setFec_estado_ant(db.getDate(DBEstadoIndividuoPredio.FEC_ESTADO_ANT));
    estadoindividuopredio.setFec_hor_estado_ant(db.getDate(DBEstadoIndividuoPredio.FEC_HOR_ESTADO_ANT));
    estadoindividuopredio.setNovedad(NovedadExcluido.findByOidProxy(db.getInteger(DBEstadoIndividuoPredio.OID_NOVEDAD),getSesion()));
    estadoindividuopredio.setActivo(db.getBoolean(DBEstadoIndividuoPredio.ACTIVO));

  }
}
