package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveAnteojoExcluido extends Operation {

	public SaveAnteojoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TAnteojoExcluido");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			AnteojoExcluido anteojoexcluido = AnteojoExcluido.findByOid(dataset.getInteger("oid_anteojo"), getSesion());
			anteojoexcluido.setOID(dataset.getInteger("oid_anteojo"));
			anteojoexcluido.setCodigo(dataset.getString("codigo"));
			anteojoexcluido.setDescripcion(dataset.getString("descripcion"));
			anteojoexcluido.setActivo(dataset.getBoolean("activo"));
			addTransaccion(anteojoexcluido);
			dataset.next();
		}
	}

}
