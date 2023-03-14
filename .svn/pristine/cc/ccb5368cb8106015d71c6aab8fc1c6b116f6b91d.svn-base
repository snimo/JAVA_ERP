package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerComplexionExcluido extends Operation {

	public TraerComplexionExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		ComplexionExcluido complexionexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			complexionexcluido = ComplexionExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			complexionexcluido = ComplexionExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetComplexionExcluido = getDataSetComplexionExcluido();
		if (complexionexcluido != null) 
			cargarRegistroComplexionExcluido(datasetComplexionExcluido, complexionexcluido);
		
		writeCliente(datasetComplexionExcluido);
	}

	private IDataSet getDataSetComplexionExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TComplexionExcluido");
		dataset.fieldDef(new Field("oid_complexion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroComplexionExcluido(IDataSet dataset, ComplexionExcluido complexion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_complexion", complexion.getOIDInteger());
		dataset.fieldValue("codigo", complexion.getCodigo());
		dataset.fieldValue("descripcion", complexion.getDescripcion());
		dataset.fieldValue("activo", complexion.isActivo());
	}
}
