package com.srn.erp.cip.op;

import java.text.DecimalFormat;
import java.util.Iterator;

import com.srn.erp.cip.bm.PermisoVisita;
import com.srn.erp.cip.bm.TarjetaLegajo;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLegajosEnPredio extends Operation {

	public TraerLegajosEnPredio() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetLegajoEnPredio();
		
		java.util.Date fecHorActual = UtilCIP.getFechaHoraActual(this.getSesion());
		Iterator iterLegajos = Legajo.getLegajosEnPredio(this.getSesion()).iterator();
		while (iterLegajos.hasNext()) {
			Legajo legajo = (Legajo) iterLegajos.next();
			cargarRegistro(ds, legajo , fecHorActual);
		}
		
		writeCliente(ds);
	}

	private IDataSet getDataSetLegajoEnPredio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLegajosEnPredio");
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_tarjeta", Field.STRING, 50));
		dataset.fieldDef(new Field("ult_mov", Field.STRING, 100));
		dataset.fieldDef(new Field("tiempo_perm", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Legajo aLegajo , java.util.Date aFecHorActual) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_legajo", aLegajo.getOIDInteger());
		dataset.fieldValue("nro_legajo", aLegajo.getNro_legajo());
		dataset.fieldValue("ape_y_nom", aLegajo.getApellidoyNombre());
		
		TarjetaLegajo tarjetaLegajo = (TarjetaLegajo) aLegajo.getTarjetaLegajoOrden1();
		if (tarjetaLegajo!=null)
			dataset.fieldValue("nro_tarjeta", tarjetaLegajo.getNro_tarjeta());
		else
			dataset.fieldValue("nro_tarjeta", "");
		dataset.fieldValue("ult_mov", aLegajo.getFecHorUltEntSalPredio());
		DecimalFormat fHora = new DecimalFormat("######00");
		DecimalFormat fMin = new DecimalFormat("00");
		String tiempoPermanencia = "";
		// Obtener el Tiempo de permamencia en el predio
		if ((aLegajo.getSentidoPaso()!=null) && (aLegajo.getSentidoPaso().equals(PermisoVisita.SENTIDO_E))) {
			if (aLegajo.getFecUltPaso()!=null) {
				long minutos = Fecha.fechasDiferenciaEnMinutos(aLegajo.getFecUltPaso(),aFecHorActual);
				int horas = (int) (minutos / 60);
				long min = (horas*60) - minutos;
				tiempoPermanencia = fHora.format(horas) + " h "+fMin.format(min)+" m"; 
			}
		}
		dataset.fieldValue("tiempo_perm", tiempoPermanencia);
	}

}
