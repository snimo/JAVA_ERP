package com.srn.erp.estadisticaRaciones.op;

import java.util.Iterator;

import com.srn.erp.estadisticaRaciones.bm.EmpresaRaciones;
import com.srn.erp.estadisticaRaciones.bm.EstadisticaRaciones;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadisticaRaciones extends Operation {

	public TraerEstadisticaRaciones() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		
		HashTableDatos empresa = new HashTableDatos();
		
		Iterator iterEmpRaciones = EmpresaRaciones.getEmpresas(this.getSesion()).iterator();
		while (iterEmpRaciones.hasNext()) {
			EmpresaRaciones empresaRaciones = (EmpresaRaciones) iterEmpRaciones.next();
			empresa.put(empresaRaciones.getCodigo(), empresaRaciones.getDescripcion());
		}
		
		java.util.Date fecDesde = mapaDatos.getDate("fecha_desde");
		java.util.Date fecHasta = mapaDatos.getDate("fecha_hasta");
		
		Iterator iterRaciones = 
				EstadisticaRaciones.getEstadisticaRaciones(fecDesde, fecHasta, this.getSesion()).iterator();
		
		IDataSet ds = getDataSetEstadisticaRaciones();
		
		while (iterRaciones.hasNext()) {
			EstadisticaRaciones estadRaciones = (EstadisticaRaciones) iterRaciones.next();
			String razonSocial = getDescripcion(empresa,estadRaciones.getEmpresa()); 
			cargarRegistroEstadisticaRaciones(ds, estadRaciones , razonSocial);
		}
		
		writeCliente(ds);
		
	}
	
	private String getDescripcion(HashTableDatos empresas , String codigo) throws BaseException {
		if (codigo==null) return "";
		return (String)empresas.get(codigo);
	}

	private IDataSet getDataSetEstadisticaRaciones() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstadisticaRaciones");
		dataset.fieldDef(new Field("EMPRESA", Field.STRING, 255));
		dataset.fieldDef(new Field("FECHA", Field.DATE, 0));
		dataset.fieldDef(new Field("TIPO_RACION", Field.STRING, 50));
		dataset.fieldDef(new Field("TIPO", Field.STRING, 50));
		dataset.fieldDef(new Field("CANTIDAD", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ANIO", Field.INTEGER, 0));
		dataset.fieldDef(new Field("MES", Field.INTEGER, 0));
		dataset.fieldDef(new Field("DIA", Field.STRING, 2));
		return dataset;
	}

	private void cargarRegistroEstadisticaRaciones(IDataSet dataset, EstadisticaRaciones estadisticaraciones , String razonSocial) throws BaseException {
		dataset.append();
		dataset.fieldValue("EMPRESA", razonSocial);
		dataset.fieldValue("FECHA", estadisticaraciones.getFecha());
		if (estadisticaraciones.getTiporacion().equals("1"))
			dataset.fieldValue("TIPO_RACION", "DESAYUNO");
		else
			if (estadisticaraciones.getTiporacion().equals("2"))
				dataset.fieldValue("TIPO_RACION", "ALMUERZO");			
			else
				if (estadisticaraciones.getTiporacion().equals("3"))
					dataset.fieldValue("TIPO_RACION", "POSTRE");
				else
					dataset.fieldValue("TIPO_RACION", "?");
		if (estadisticaraciones.getTipo().equals("I"))
			dataset.fieldValue("TIPO", "Interno");
		else
			dataset.fieldValue("TIPO", "Externo");
		dataset.fieldValue("CANTIDAD", estadisticaraciones.getCantidad());
		dataset.fieldValue("ANIO", estadisticaraciones.getAnio());
		dataset.fieldValue("MES", estadisticaraciones.getMes());
		dataset.fieldValue("DIA", estadisticaraciones.getDia());
	}
}
