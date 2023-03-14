package com.srn.erp.excluidos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.excluidos.bm.AnteojoExcluido;
import com.srn.erp.excluidos.da.DBAnteojoExcluido;

public class FactoryAnteojoExcluido extends FactoryObjetoLogico {

	public FactoryAnteojoExcluido() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		AnteojoExcluido anteojoexcluido = (AnteojoExcluido) objLog;
		anteojoexcluido.setOID(db.getInteger(DBAnteojoExcluido.OID_ANTEOJO));
		anteojoexcluido.setCodigo(db.getString(DBAnteojoExcluido.CODIGO));
		anteojoexcluido.setDescripcion(db.getString(DBAnteojoExcluido.DESCRIPCION));
		anteojoexcluido.setActivo(db.getBoolean(DBAnteojoExcluido.ACTIVO));

	}
}
