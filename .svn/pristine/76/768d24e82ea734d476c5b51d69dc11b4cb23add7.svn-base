package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.CantSancionesPorTitu;
import com.srn.erp.rrhh.bm.DesgloseCalifGral;
import com.srn.erp.rrhh.bm.ListaDesgloseCalifGral;
import com.srn.erp.rrhh.bm.MesCronoDesa;
import com.srn.erp.rrhh.bm.MotivosNoAprob;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComposiCalif extends Operation {

	public TraerComposiCalif() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsCab = this.getDataSetCabCalif();
		IDataSet dsDet = this.getDataSetDetCalif();

		CalculadorMoney ajuste = new CalculadorMoney(new Money(0));

		IDataSet dsFiltros = mapaDatos.getDataSet("TFiltros");
		dsFiltros.first();
		while (!dsFiltros.EOF()) {

			Legajo legajo = Legajo.findByOidProxy(dsFiltros.getInteger("oid_legajo"), this.getSesion());
			AccCronoDesa accion = AccCronoDesa.findByOidProxy(dsFiltros.getInteger("oid_accion"), this.getSesion());
			String codigoMes = dsFiltros.getString("codigo_mes");
			Integer anio = dsFiltros.getInteger("anio");
			String descMes = MesCronoDesa.getDescMes(MesCronoDesa.getNroMes(codigoMes));

			cargarCabClasif(dsCab, legajo, accion, anio, codigoMes, descMes);

			ListaDesgloseCalifGral listaDesgloseCalifGral = new ListaDesgloseCalifGral();

			CantSancionesPorTitu cantSancionesPorTitu = new CantSancionesPorTitu();
			MotivosNoAprob motivosNoAprob = new MotivosNoAprob();

			int ranking = legajo.getRankingDesarrollo(listaDesgloseCalifGral, cantSancionesPorTitu, motivosNoAprob, accion, anio, codigoMes, false , false , 0 , 0);
			ajuste.sumar(new Money(ranking));
			
			Iterator iterLista = listaDesgloseCalifGral.getLista().iterator();
			while (iterLista.hasNext()) {
				DesgloseCalifGral desgloseCalifGral = (DesgloseCalifGral) iterLista.next();
				cargarDesglose(dsDet, desgloseCalifGral);
				if (desgloseCalifGral.getTotPuntosPond()!=null)
					ajuste.restar(desgloseCalifGral.getTotPuntosPond());
			}
			
			
			cargarAjuste(dsDet,ajuste.getResultMoney());

			dsFiltros.next();
		}
		
		

		writeCliente(dsCab);
		writeCliente(dsDet);

	}
	
	private void cargarAjuste(IDataSet ds,Money ajuste) throws BaseException {
		if (ajuste.doubleValue()!=0) {
			ds.append();
			ds.fieldValue("agrupador", "Ajuste por Redondeo");
			ds.fieldValue("fecha", UtilCIP.getFechaHoraActual(this.getSesion()));
			ds.fieldValue("motivo", "Ajuste por redondeo");
			ds.fieldValue("puntaje", ajuste);
			ds.fieldValue("cantidad", "");
			ds.fieldValue("ponderacion", "");
			ds.fieldValue("tot_punt_pond", ajuste);
			ds.fieldValue("orden", 100000);
		}
	}

	private IDataSet getDataSetCabCalif() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCabCalif");
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_cronograma", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_cronograma", Field.STRING, 100));
		dataset.fieldDef(new Field("anio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("mes", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_mes", Field.STRING, 100));
		return dataset;
	}

	private void cargarCabClasif(IDataSet dsCab, Legajo legajo, AccCronoDesa accion, Integer anio, String mes, String descMes) throws BaseException {
		dsCab.append();
		dsCab.fieldValue("oid_legajo", legajo.getOIDInteger());
		dsCab.fieldValue("nro_legajo", legajo.getNro_legajo());
		dsCab.fieldValue("ape_y_nom", legajo.getApellidoyNombre());
		dsCab.fieldValue("oid_cronograma", accion.getCronograma().getOIDInteger());
		dsCab.fieldValue("desc_cronograma", accion.getCronograma().getDescripcion());
		dsCab.fieldValue("anio", anio);
		dsCab.fieldValue("mes", mes);
		dsCab.fieldValue("desc_mes", descMes);

	}

	private IDataSet getDataSetDetCalif() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetCalif");
		dataset.fieldDef(new Field("agrupador", Field.STRING, 100));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 500));
		dataset.fieldDef(new Field("puntaje", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("ponderacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tot_punt_pond", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarDesglose(IDataSet ds, DesgloseCalifGral desglose) throws BaseException {
		ds.append();
		ds.fieldValue("agrupador", desglose.getAgrupador());
		ds.fieldValue("fecha", desglose.getFecha());
		ds.fieldValue("motivo", desglose.getMotivo());
		ds.fieldValue("puntaje", desglose.getPuntaje());
		ds.fieldValue("cantidad", desglose.getCantidad());
		ds.fieldValue("ponderacion", desglose.getPonderacion());
		ds.fieldValue("tot_punt_pond", desglose.getTotPuntosPond());
		ds.fieldValue("orden", desglose.getOrden());
	}

}
