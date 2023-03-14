package com.srn.erp.cip.op;

import java.text.DecimalFormat;
import java.util.Iterator;

import com.srn.erp.cip.bm.PermisoVisita;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.cip.bm.Visita;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerVisitasEnPredio extends Operation {

	public TraerVisitasEnPredio() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetVisitasEnPredio();
		
		Iterator iterVisita = Visita.getVisitasEnPredio(this.getSesion()).iterator();
		java.util.Date fecHor = UtilCIP.getFechaHoraActual(this.getSesion());
		while (iterVisita.hasNext()) {
			Visita visita = (Visita) iterVisita.next();
			cargarRegistro(ds, visita , fecHor);
		}
		
		writeCliente(ds);
	}

	private IDataSet getDataSetVisitasEnPredio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TVisitasEnPredio");
		dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_documento", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		dataset.fieldDef(new Field("empresa", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_tarjeta", Field.STRING, 100));
		dataset.fieldDef(new Field("grupo", Field.STRING, 100)); 
		dataset.fieldDef(new Field("motivo", Field.STRING, 100)); 
		dataset.fieldDef(new Field("zona", Field.STRING, 100));
		dataset.fieldDef(new Field("categ_acc_int", Field.STRING, 100));
		dataset.fieldDef(new Field("ult_mov", Field.STRING, 100));
		dataset.fieldDef(new Field("tiempo_perm", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Visita visita , java.util.Date fecHoraActual) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_visita", visita.getOID());
		dataset.fieldValue("nro_documento", visita.getNroDocumento());
		dataset.fieldValue("ape_y_nom", visita.getApeyNom());
		if (visita.getEmpresaCIP()!=null)
			dataset.fieldValue("empresa", visita.getEmpresaCIP().getRazon_social());
		else
			dataset.fieldValue("empresa", "");
		TarjetaCIP tarjeta = visita.getTarjetaAsignada();
		if (tarjeta!=null)
			dataset.fieldValue("nro_tarjeta", tarjeta.getNro_tarjeta());
		else
			dataset.fieldValue("nro_tarjeta", "");
		if (visita.getGrupoVisita()!=null)
			dataset.fieldValue("grupo", visita.getGrupoVisita().getDescripcion());
		else
			dataset.fieldValue("grupo", "");
		if (visita.getMotivoVisita()!=null)
			dataset.fieldValue("motivo", visita.getMotivoVisita().getDescripcion());
		else
			dataset.fieldValue("motivo", "");
		if (visita.getZonaActual()!=null)
			dataset.fieldValue("zona", visita.getZonaActual().getDescripcion());
		else
			dataset.fieldValue("zona", "");
		if (visita.getCategoriaAcceso()!=null)
			dataset.fieldValue("categ_acc_int" , visita.getCategoriaAcceso().getDescripcion());
		else
			dataset.fieldValue("categ_acc_int" , "");
		dataset.fieldValue("ult_mov", 	visita.getFecHorUltEntSalPredio());
		String tiempoPermanencia = "";
		
		DecimalFormat fHora = new DecimalFormat("######00");
		DecimalFormat fMin = new DecimalFormat("00");
		// Obtener el Tiempo de permamencia en el predio
		if ((visita.getSentido()!=null) && (visita.getSentido().equals(PermisoVisita.SENTIDO_E))) {
			if (visita.getFecHorUltMov()!=null) {
				long minutos = Fecha.fechasDiferenciaEnMinutos(visita.getFecHorUltMov(),fecHoraActual);
				int horas = (int) (minutos / 60);
				long min = (horas*60) - minutos;
				tiempoPermanencia = fHora.format(horas) + " h "+fMin.format(min)+" m"; 
			}
		}
		dataset.fieldValue("tiempo_perm", tiempoPermanencia);
	}

}
