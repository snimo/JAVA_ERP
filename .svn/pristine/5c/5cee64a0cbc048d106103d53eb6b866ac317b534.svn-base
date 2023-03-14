package com.srn.erp.stock.op;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.CostoProductoGral;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPrecioLPProvForm extends Operation {

	String comoObtenerCosto = null;
	UnidadMedida umCompra = null;
	Moneda moneda = null;
	Money costo = null;
	java.util.Date fecha = null;
	java.util.Date fechaVig = null;

	public TraerPrecioLPProvForm() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidProdProv = null;
		java.util.Date fechaActual = Fecha.getFechaActual();

		comoObtenerCosto = mapaDatos.getString("como_obtener_costo");

		if (CostoProductoGral.COMO_OBT_COSTO_LPP.equals(comoObtenerCosto))
			obtenerCostoLPProveedor(mapaDatos);
		else if (CostoProductoGral.COMO_OBT_COSTO_COSTOS_HIST.equals(comoObtenerCosto))
			obtenerCostoHistoricos(mapaDatos);

	}
	
	private void obtenerCostoHistoricos(MapDatos mapaDatos) throws BaseException {
		boolean encontroCosto = false;
		fecha = Fecha.getFechaDiaPosterior(Fecha.getFechaActual());
		IDataSet dsCostosHistoricos = mapaDatos.getDataSet("TCostosProdGral");
		dsCostosHistoricos.first();
		while (!dsCostosHistoricos.EOF()) {
			
			if ((dsCostosHistoricos.getDate("fec_ult_costo")!=null) && (dsCostosHistoricos.getDate("fec_ult_costo").before(fecha))) {
				

				if ((fechaVig == null) || (fechaVig.before(dsCostosHistoricos.getDate("fec_ult_costo")))) {
					umCompra = UnidadMedida.findByOidProxy(dsCostosHistoricos.getInteger("oid_um"), this.getSesion());
					moneda = Moneda.findByOidProxy(dsCostosHistoricos.getInteger("oid_moneda"), this.getSesion());
					costo = dsCostosHistoricos.getMoney("costo");
					fechaVig = dsCostosHistoricos.getDate("fec_ult_costo");
					encontroCosto = true;

				}
				
				
			}
			
			
			dsCostosHistoricos.next();
		}
		
		// Obtener el costo
		if (encontroCosto) {
			IDataSet ds = this.getDSCosto();
			cargarRegistro(ds);
			writeCliente(ds);
		}
		
		
		
		
	}

	private void obtenerCostoLPProveedor(MapDatos mapaDatos) throws BaseException {
		int prioridad = 1000000;
		fecha = Fecha.getFechaDiaPosterior(Fecha.getFechaActual());
		boolean encontroCosto = false;

		IDataSet dsProdProv = mapaDatos.getDataSet("TProductoProveedor");
		dsProdProv.first();
		while (!dsProdProv.EOF()) {

			if ((dsProdProv.getDate("fec_vig") != null) && (dsProdProv.getDate("fec_vig").before(fecha))) {

				if ((dsProdProv.getInteger("prioridad") != null) && (dsProdProv.getInteger("prioridad").intValue() > 0)) {

					if (dsProdProv.getInteger("prioridad").intValue() <= prioridad) {

						if ((fechaVig == null) || (fechaVig.before(dsProdProv.getDate("fec_vig")))) {
							prioridad = dsProdProv.getInteger("prioridad").intValue();
							umCompra = UnidadMedida.findByOidProxy(dsProdProv.getInteger("oid_um_cpra"), this.getSesion());
							moneda = Moneda.findByOidProxy(dsProdProv.getInteger("oid_moneda"), this.getSesion());
							costo = dsProdProv.getMoney("costo");
							fechaVig = dsProdProv.getDate("fec_vig");
							encontroCosto = true;

						}

					}
				}
			}
			dsProdProv.next();
		}
		
		// Obtener el costo
		if (encontroCosto) {
			IDataSet ds = this.getDSCosto();
			cargarRegistro(ds);
			writeCliente(ds);
		}
		
	}

	private IDataSet getDSCosto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCosto");
		dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("costo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fec_vig", Field.DATE, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_um", this.umCompra.getOIDInteger());
		dataset.fieldValue("oid_moneda", this.moneda.getOIDInteger());
		dataset.fieldValue("costo", this.costo);
		dataset.fieldValue("fec_vig", this.fechaVig);

	}

}
