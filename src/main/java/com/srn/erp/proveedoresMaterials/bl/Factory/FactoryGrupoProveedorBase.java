package com.srn.erp.proveedoresMaterials.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.proveedoresMaterials.bm.GrupoProveedorBase;
import com.srn.erp.proveedoresMaterials.da.DBGrupoProveedorBase;

public class FactoryGrupoProveedorBase extends FactoryObjetoLogico {

	public FactoryGrupoProveedorBase() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		GrupoProveedorBase grupoproveedorbase = (GrupoProveedorBase) objLog;
		grupoproveedorbase.setOID(db.getInteger(DBGrupoProveedorBase.ID));
		grupoproveedorbase.setNombre(db.getString(DBGrupoProveedorBase.NOMBRE));

	}
}
