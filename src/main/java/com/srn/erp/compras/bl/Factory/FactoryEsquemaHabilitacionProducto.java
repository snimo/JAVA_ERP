package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.EsquemaHabilitacionProducto;
import com.srn.erp.compras.da.DBEsquemaHabilitacionProducto;
import com.srn.erp.general.bm.ClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEsquemaHabilitacionProducto extends FactoryObjetoLogico {

	public FactoryEsquemaHabilitacionProducto() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		EsquemaHabilitacionProducto esquemahabilitacionproducto = (EsquemaHabilitacionProducto) objLog;
		esquemahabilitacionproducto.setOID(db.getInteger(DBEsquemaHabilitacionProducto.OID_ESQ_HAB_PROD));
		esquemahabilitacionproducto.setCodigo(db.getString(DBEsquemaHabilitacionProducto.CODIGO));
		esquemahabilitacionproducto.setDescripcion(db.getString(DBEsquemaHabilitacionProducto.DESCRIPCION));
		esquemahabilitacionproducto.setAmbito_esquema(db.getString(DBEsquemaHabilitacionProducto.AMBITO_ESQUEMA));
		esquemahabilitacionproducto.setActivo(db.getBoolean(DBEsquemaHabilitacionProducto.ACTIVO));
		esquemahabilitacionproducto.setClasificador(ClasificadorEntidad.findByOidProxy(db
				.getInteger(DBEsquemaHabilitacionProducto.OID_CLASIF_ENT), getSesion()));

	}
}
