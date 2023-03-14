package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.CondMinRankeador;
import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.TipoNovedad;
import com.srn.erp.rrhh.da.DBCondMinRankeador;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondMinRankeador extends FactoryObjetoLogico {

	public FactoryCondMinRankeador() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		CondMinRankeador condminrankeador = (CondMinRankeador) objLog;
		condminrankeador.setOID(db.getInteger(DBCondMinRankeador.OID_COND_MIN_RANK));
		condminrankeador.setNro_novedad(db.getInteger(DBCondMinRankeador.NRO_NOVEDAD));
		condminrankeador.setRankear(RankearCab.findByOidProxy(db.getInteger(DBCondMinRankeador.OID_RANKEAR), getSesion()));
		condminrankeador.setTipo_novedad(TipoNovedad.findByOidProxy(db.getInteger(DBCondMinRankeador.OID_TIPO_NOV), getSesion()));
		condminrankeador.setMotivo(MotivoTipoNov.findByOidProxy(db.getInteger(DBCondMinRankeador.OID_MOTIVO), getSesion()));
		condminrankeador.setActivo(db.getBoolean(DBCondMinRankeador.ACTIVO));

	}
}
