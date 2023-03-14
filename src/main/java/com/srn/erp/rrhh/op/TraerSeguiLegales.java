package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.legales.bm.NegociacionLegales;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSeguiLegales extends Operation {

	ClasificadorEntidad clasifEmpresa = null;
	ClasificadorEntidad clasifSector = null;
	ClasificadorEntidad clasifPuesto = null;
	ClasificadorEntidad clasifEstado = null;

	public TraerSeguiLegales() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());

		IDataSet ds = this.getDataSet();

		HashTableDatos legajosProc = new HashTableDatos();

		Iterator iterNegociociosLeg = NegociacionLegales.getNegociacionesEnSeguimiento(this.getSesion()).iterator();
		while (iterNegociociosLeg.hasNext()) {
			NegociacionLegales negocioacion = (NegociacionLegales) iterNegociociosLeg.next();
			if (negocioacion.getLegajo()!=null) {
				legajosProc.put(negocioacion.getLegajo().getOIDInteger(), "");
				carga(ds, negocioacion.getLegajo(), negocioacion);
			}
		}
		
		

		Iterator iterLegajos = Legajo.getLegajosEnSeguiLegales(this.getSesion()).iterator();
		while (iterLegajos.hasNext()) {
			Legajo legajo = (Legajo) iterLegajos.next();
			String encontro  = (String) legajosProc.get(legajo.getOIDInteger());
			if (encontro==null)
				carga(ds, legajo , null);
		}
		
		writeCliente(ds);

	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLegajosSegui");
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 255));
		dataset.fieldDef(new Field("procedencia", Field.STRING, 255));
		dataset.fieldDef(new Field("puesto", Field.STRING, 255));
		dataset.fieldDef(new Field("sector", Field.STRING, 255));
		dataset.fieldDef(new Field("fec_ant_rec", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_ing_rea", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_egreso", Field.DATE, 0));
		dataset.fieldDef(new Field("segui_legales", Field.STRING, 2));
		dataset.fieldDef(new Field("segui_cartas", Field.STRING, 2));
		dataset.fieldDef(new Field("fec_neg", Field.DATE, 0));
		dataset.fieldDef(new Field("obs_neg", Field.MEMO, 0));
		dataset.fieldDef(new Field("monto_neg", Field.CURRENCY, 0));
		return dataset;
	}

	private void carga(IDataSet ds, Legajo legajo , NegociacionLegales negociacion) throws BaseException {
		ds.append();
		ds.fieldValue("oid_legajo", legajo.getOIDInteger());
		ds.fieldValue("legajo", legajo.getNro_legajo());
		ds.fieldValue("ape_y_nom", legajo.getApellidoyNombre());

		ValorClasificadorEntidad valorClasifEmp = legajo.getValorClasifEnt(clasifEmpresa);
		String empresa = "";
		if (valorClasifEmp != null)
			empresa = valorClasifEmp.getDescripcion();

		ValorClasificadorEntidad valorClasifPue = legajo.getValorClasifEnt(clasifPuesto);
		String puesto = "";
		if (valorClasifPue != null)
			puesto = valorClasifPue.getDescripcion();

		ValorClasificadorEntidad valorClasifSec = legajo.getValorClasifEnt(clasifSector);
		String sector = "";
		if (valorClasifSec != null)
			sector = valorClasifSec.getDescripcion();

		ds.fieldValue("procedencia", empresa);
		ds.fieldValue("puesto", puesto);
		ds.fieldValue("sector", sector);
		ds.fieldValue("fec_ant_rec", legajo.getFecAntReconocimiento());
		ds.fieldValue("fec_ing_rea", legajo.getFecIngreso());
		ds.fieldValue("fec_egreso", legajo.getFecRetiro());
		if (legajo.isSeguiLegales())
			ds.fieldValue("segui_legales", "Si");
		else
			ds.fieldValue("segui_legales", "No");
		if (legajo.isSeguiCartasDocu())
			ds.fieldValue("segui_cartas", "Si");
		else
			ds.fieldValue("segui_cartas", "No");
		
		if (negociacion!=null) {
			ds.fieldValue("fec_neg", negociacion.getFecha());
			ds.fieldValue("obs_neg", negociacion.getObservacion());
			ds.fieldValue("monto_neg", negociacion.getMonto());
		} else {
			ds.fieldValue("fec_neg", "");
			ds.fieldValue("obs_neg", "");
			ds.fieldValue("monto_neg", "");			
		}
		
		
	}

}
