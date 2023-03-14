package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.FiltroValLegCab;
import com.srn.erp.rrhh.da.DBFiltroValLegCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFiltroValLegCab extends FactoryObjetoLogico {

	public FactoryFiltroValLegCab() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		FiltroValLegCab filtrovallegcab = (FiltroValLegCab) objLog;
		filtrovallegcab.setOID(db.getInteger(DBFiltroValLegCab.OID_VAL_FILTRO_DET));
		filtrovallegcab.setFiltro_cab(FiltroLegCab.findByOidProxy(db.getInteger(DBFiltroValLegCab.OID_FILTRO_CAB), getSesion()));
		filtrovallegcab.setOid_valor(db.getInteger(DBFiltroValLegCab.OID_VALOR));
		filtrovallegcab.setTipo(db.getString(DBFiltroValLegCab.TIPO));
		filtrovallegcab.setActivo(db.getBoolean(DBFiltroValLegCab.ACTIVO));

	}
}
