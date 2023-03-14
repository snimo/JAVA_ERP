package com.srn.erp.cip.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategEvenAccesoLeg;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCategHabAccIntLeg extends Operation {

	public TraerCategHabAccIntLeg() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		int orden = 0;
		IDataSet ds 					= this.getDataSetAccesosInternos();
		List titulosAccIntLimEventuales = new ArrayList();
		List titulosAccIntSumEventuales = new ArrayList();
		List titulosAccIntFijos		    = new ArrayList();

		Legajo legajo = Legajo.findByCodigo(mapaDatos.getString("legajo"), this.getSesion());
		if (legajo != null) {

			Iterator iterCategEvenAccesoLeg = 
				CategEvenAccesoLeg.getCategAccEventuales(legajo, UtilCIP.getFechaHoraActual(this.getSesion()) , this.getSesion()).iterator();
			while (iterCategEvenAccesoLeg.hasNext()) {
				CategEvenAccesoLeg categEvenAccesoLeg = (CategEvenAccesoLeg) iterCategEvenAccesoLeg.next();
				if (categEvenAccesoLeg.isLimitarA()) {
					titulosAccIntLimEventuales.add(categEvenAccesoLeg);
										
					String horaDesde = Fecha.getFormatoHoraMin(categEvenAccesoLeg.getFecha_desde());
					String horaHasta = Fecha.getFormatoHoraMin(categEvenAccesoLeg.getFecha_hasta());
					
					java.util.Date fecTruncDesde = Fecha.getFechaTruncada(categEvenAccesoLeg.getFecha_desde());
					java.util.Date fecTruncHasta = Fecha.getFechaTruncada(categEvenAccesoLeg.getFecha_hasta());
					
					
					if (fecTruncDesde.equals(fecTruncHasta))
						cargarRegistro(ds, orden, "Acceso habilitado de "+horaDesde+" a "+horaHasta+" a "+ categEvenAccesoLeg.getDescCategorias(),categEvenAccesoLeg);
					else
						cargarRegistro(ds, orden, "Acceso habilitado de "+horaDesde+" a "+horaHasta+" a "+ categEvenAccesoLeg.getDescCategorias()+" hasta el "+Fecha.getddmmyyyy(fecTruncHasta),categEvenAccesoLeg);
				} 
			}
			
			if (titulosAccIntLimEventuales.size()==0) {
				iterCategEvenAccesoLeg = 
					CategEvenAccesoLeg.getCategAccEventuales(legajo, UtilCIP.getFechaHoraActual(this.getSesion()) , this.getSesion()).iterator();
				while (iterCategEvenAccesoLeg.hasNext()) {
					CategEvenAccesoLeg categEvenAccesoLeg = (CategEvenAccesoLeg) iterCategEvenAccesoLeg.next();
					if (categEvenAccesoLeg.isLimitarA()) {
					} else {
						
						
						String horaDesde = Fecha.getFormatoHoraMin(categEvenAccesoLeg.getFecha_desde());
						String horaHasta = Fecha.getFormatoHoraMin(categEvenAccesoLeg.getFecha_hasta());
						
						java.util.Date fecTruncDesde = Fecha.getFechaTruncada(categEvenAccesoLeg.getFecha_desde());
						java.util.Date fecTruncHasta = Fecha.getFechaTruncada(categEvenAccesoLeg.getFecha_hasta());
						
						
						if (fecTruncDesde.equals(fecTruncHasta))
							cargarRegistro(ds, orden, "Acceso habilitado de "+horaDesde+" a "+horaHasta+" a " + categEvenAccesoLeg.getDescCategorias(),categEvenAccesoLeg);
						else
							cargarRegistro(ds, orden, "Acceso habilitado de "+horaDesde+" a "+horaHasta+" a " + categEvenAccesoLeg.getDescCategorias()+" hasta el "+Fecha.getddmmyyyy(fecTruncHasta),categEvenAccesoLeg);
					}
				}			
			}
			
			if (titulosAccIntLimEventuales.size()==0) {
				StringBuffer descCategorias = new StringBuffer("");
				Iterator iterCategLegajo = CategAccesoCIP.getCategAccesosByLegajo(legajo,this.getSesion()).iterator();
				while (iterCategLegajo.hasNext()) {
					CategAccesoCIP categAccesoCIP = (CategAccesoCIP) iterCategLegajo.next();
					if (descCategorias.length()>0)
						descCategorias.append(", "+categAccesoCIP.getDescripcion());
					else
						descCategorias.append(categAccesoCIP.getDescripcion());
				}
				if (descCategorias.length()>0) {
					++orden;
					cargarRegistro(ds, orden, "Acceso habilitado a "+descCategorias.toString(),null);
				}
			}
			
		}
			
		
		writeCliente(ds);
	}

	private IDataSet getDataSetAccesosInternos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAccesosInternos");
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo", Field.MEMO, 0));
		dataset.fieldDef(new Field("eliminar", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_categ_eve_leg", Field.INTEGER, 0)); 
		return dataset;
	}

	private void cargarRegistro(IDataSet ds, Integer orden, String motivo, CategEvenAccesoLeg categEvenAccesoLeg)
			throws BaseException {
		ds.append();
		ds.fieldValue("orden", orden);
		ds.fieldValue("motivo", motivo);
		ds.fieldValue("eliminar", "Eliminar");
		if (categEvenAccesoLeg!=null)
			ds.fieldValue("oid_categ_eve_leg", categEvenAccesoLeg.getOIDInteger());
		else
			ds.fieldValue("oid_categ_eve_leg", "");
	}

}
