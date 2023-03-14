package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.EsquemaAutorizCompras;
import com.srn.erp.compras.da.DBEsquemaAutorizCompras;
import com.srn.erp.general.bm.ClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEsquemaAutorizCompras extends FactoryObjetoLogico {

	public FactoryEsquemaAutorizCompras() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db)
			throws BaseException {
		EsquemaAutorizCompras esquemaautorizcompras = (EsquemaAutorizCompras) objLog;
		esquemaautorizcompras.setOID(db.getInteger(DBEsquemaAutorizCompras.OID_ESQ_AUTORIZ));
		esquemaautorizcompras.setCodigo(db.getString(DBEsquemaAutorizCompras.CODIGO));
		esquemaautorizcompras.setDescripcion(db.getString(DBEsquemaAutorizCompras.DESCRIPCION));
		esquemaautorizcompras.setAmbito_esquema(db.getString(DBEsquemaAutorizCompras.AMBITO_ESQUEMA));
		esquemaautorizcompras.setActivo(db.getBoolean(DBEsquemaAutorizCompras.ACTIVO));
		esquemaautorizcompras.setClasificadorEntidad(ClasificadorEntidad.findByOidProxy(db.getInteger(DBEsquemaAutorizCompras.OID_CLASIF_ENT),getSesion()));
		esquemaautorizcompras.setUsarClasificador(db.getBoolean(DBEsquemaAutorizCompras.USAR_CLASIFICADOR).booleanValue());
		esquemaautorizcompras.setNombreNickName(db.getString(DBEsquemaAutorizCompras.NICKNAME));

	}
}
