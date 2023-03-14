package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.EstadosExcluidosUltNroActa;
import com.srn.erp.excluidos.bm.EstadosExcluidosUltNroActaRev;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerUltNroActaEstados extends Operation {

	public TraerUltNroActaEstados() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = this.getDataUltNroActa();
		IDataSet ds1 = this.getDataUltNroActaRev();

		Iterator iterEstadosExcluidos = EstadosExcluidosUltNroActa.getAllUltNrosEstados(this.getSesion()).iterator();

		while (iterEstadosExcluidos.hasNext()) {
			EstadosExcluidosUltNroActa estadoExcluidoUltNroActa = (EstadosExcluidosUltNroActa) iterEstadosExcluidos.next();
			cargarRegistro(ds, 
					estadoExcluidoUltNroActa.getOIDInteger(), 
					estadoExcluidoUltNroActa.getDescripcion(),
					estadoExcluidoUltNroActa.getUlt_nro());
		}
		
		Iterator iterEstadosExcluidosRev = EstadosExcluidosUltNroActaRev.getAllUltNrosEstados(this.getSesion()).iterator();

		while (iterEstadosExcluidosRev.hasNext()) {
			EstadosExcluidosUltNroActaRev estadoExcluidoUltNroActaRev = (EstadosExcluidosUltNroActaRev) iterEstadosExcluidosRev.next();
			cargarRegistro(ds1, estadoExcluidoUltNroActaRev.getOIDInteger(), estadoExcluidoUltNroActaRev.getDescripcion(),
					estadoExcluidoUltNroActaRev.getUlt_nro());
		}		

		writeCliente(ds);
		writeCliente(ds1);
		
	}

	private IDataSet getDataUltNroActa() {
		IDataSet dataset = new TDataSet();
		dataset.create("TUltNroActa");
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("ult_nro", Field.INTEGER, 0));
		return dataset;
	}
	
	private IDataSet getDataUltNroActaRev() {
		IDataSet dataset = new TDataSet();
		dataset.create("TUltNroActaRev");
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("ult_nro", Field.INTEGER, 0));
		return dataset;
	}
	

	private void cargarRegistro(IDataSet dataset, Integer oidEstado, String descripcion, Integer ultNro) {
		dataset.append();
		dataset.fieldValue("oid_estado", oidEstado);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("ult_nro", ultNro);
	}
	
	private void cargarRegistroRev(IDataSet dataset, Integer oidEstado, String descripcion, Integer ultNro) {
		dataset.append();
		dataset.fieldValue("oid_estado", oidEstado);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("ult_nro", ultNro);
	}	
	
}
