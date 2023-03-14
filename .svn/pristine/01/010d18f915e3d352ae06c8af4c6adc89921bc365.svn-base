package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveComplexionExcluido extends Operation {

	public SaveComplexionExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TComplexionExcluido");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			ComplexionExcluido complexionexcluido = ComplexionExcluido.findByOid(dataset.getInteger("oid_complexion"), getSesion());
			complexionexcluido.setOID(dataset.getInteger("oid_complexion"));
			complexionexcluido.setCodigo(dataset.getString("codigo"));
			complexionexcluido.setDescripcion(dataset.getString("descripcion"));
			complexionexcluido.setActivo(dataset.getBoolean("activo"));
			addTransaccion(complexionexcluido);
			dataset.next();
		}
	}

}
