package com.srn.erp.impuestos.op;

import java.util.Iterator;

import com.srn.erp.impuestos.bm.TratamientosArchImpu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTratArchImpuestos extends Operation {

	public TraerTratArchImpuestos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = getDataSet();
		
		Iterator iterCodigos = 
			TratamientosArchImpu.getListaTratamientos().keySet().iterator();
		while (iterCodigos.hasNext()) {
			String codigo = (String) iterCodigos.next();
			String descripcion = (String) TratamientosArchImpu.getListaTratamientos().get(codigo);
			ds.append();
			ds.fieldValue("codigo",codigo);
			ds.fieldValue("descripcion",descripcion);
		}
		
	  writeCliente(ds);		
		
	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTratArchImpu");
		dataset.fieldDef(new Field("codigo", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		return dataset;
	}
	
	
	
	
}
