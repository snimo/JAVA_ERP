package com.srn.erp.excluidos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.excluidos.bm.TipoBarba;
import com.srn.erp.excluidos.da.DBTipoBarba;

public class FactoryTipoBarba extends FactoryObjetoLogico {

	public FactoryTipoBarba() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		TipoBarba tipobarba = (TipoBarba) objLog;
		tipobarba.setOID(db.getInteger(DBTipoBarba.OID_TIPO_BARBA));
		tipobarba.setCodigo(db.getString(DBTipoBarba.CODIGO));
		tipobarba.setDescripcion(db.getString(DBTipoBarba.DESCRIPCION));
		tipobarba.setActivo(db.getBoolean(DBTipoBarba.ACTIVO));

	}
}
