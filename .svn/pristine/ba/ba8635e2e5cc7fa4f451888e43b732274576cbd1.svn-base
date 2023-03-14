package com.srn.erp.proveedoresMaterials.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.proveedoresMaterials.bm.GrupoProveedor;
import com.srn.erp.proveedoresMaterials.da.DBGrupoProveedor;

public class FactoryGrupoProveedor extends FactoryObjetoLogico {

	public FactoryGrupoProveedor() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		GrupoProveedor grupoproveedor = (GrupoProveedor) objLog;
		grupoproveedor.setOID(db.getInteger(DBGrupoProveedor.OID_GRUPO_PROVEEDOR));
		grupoproveedor.setCodigo(db.getString(DBGrupoProveedor.CODIGO));
		grupoproveedor.setDescripcion(db.getString(DBGrupoProveedor.DESCRIPCION));
		grupoproveedor.setGrupoute(db.getInteger(DBGrupoProveedor.OID_GRUPO_UTE));
		grupoproveedor.setGrupobinbaires(db.getInteger(DBGrupoProveedor.OID_GRUPO_BINBAIRES));
		grupoproveedor.setGrupoalavera(db.getInteger(DBGrupoProveedor.OID_GRUPO_ALAVERA));
		grupoproveedor.setGrupomagic(db.getInteger(DBGrupoProveedor.OID_GRUPO_MAGIC));
		grupoproveedor.setActivo(db.getBoolean(DBGrupoProveedor.ACTIVO));

	}
}
