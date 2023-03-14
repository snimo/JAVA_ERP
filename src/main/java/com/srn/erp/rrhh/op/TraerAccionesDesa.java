package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.CronogramaDesa;
import com.srn.erp.rrhh.bm.MesCronoDesa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAccionesDesa extends Operation {

	public TraerAccionesDesa() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetAccionesDesa();
		
		String mes = null;
		CronogramaDesa cronograma = CronogramaDesa.findByOid(mapaDatos.getInteger("oid_cronograma"),this.getSesion());
		if (mapaDatos.containsKey("mes"))
			mes = mapaDatos.getString("mes");
		Iterator iterAcciones = cronograma.getAcciones().iterator();
		while (iterAcciones.hasNext()) {
			AccCronoDesa accCronoDesa = (AccCronoDesa) iterAcciones.next();
			if (mes!=null) {			
				MesCronoDesa mesCronoDesa =
					MesCronoDesa.getMesCronoDesa(accCronoDesa, mes, this.getSesion());
				if (mesCronoDesa!=null)
					cargarRegistroAccionesDesa(ds,cronograma,accCronoDesa);
			} else {
				cargarRegistroAccionesDesa(ds,cronograma,accCronoDesa);	
			}
		}
		
		writeCliente(ds);
		
	}

	private IDataSet getDataSetAccionesDesa() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAccionesCronograma");
		dataset.fieldDef(new Field("oid_cronograma", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_accion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("seleccionar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroAccionesDesa(IDataSet dataset, CronogramaDesa cronograma, AccCronoDesa accion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cronograma", cronograma.getOIDInteger());
		dataset.fieldValue("oid_accion", accion.getOIDInteger());
		
		StringBuffer descripcion = new StringBuffer("");
		
		if (accion.getAccion()!=null)
			descripcion.append(accion.getAccion()+" ");
		
		if (accion.getSector()!=null)
			descripcion.append(accion.getSector()+" ");		
		
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("seleccionar", false);
		dataset.fieldValue("orden", accion.getOrden());
	}

}
