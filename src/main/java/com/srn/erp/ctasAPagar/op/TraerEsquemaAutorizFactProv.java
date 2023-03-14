package com.srn.erp.ctasAPagar.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactMonto;
import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactProv;
import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactSector;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEsquemaAutorizFactProv extends Operation {

	public TraerEsquemaAutorizFactProv() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		EsquemaAutorizFactProv esquemaautorizfactprov = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			esquemaautorizfactprov = EsquemaAutorizFactProv.findByOid(oid, getSesion());
		}
		else {
			String codigo = mapaDatos.getString("codigo");
			esquemaautorizfactprov = EsquemaAutorizFactProv.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetEsquemaAutorizFactProv = getDataSetEsquemaAutorizFactProv();
		IDataSet datasetEsquemaAutorizFactMon = getDataSetEsquemaAutorizFactMonto();
		IDataSet datasetEsquemaAutorizFactSec = getDataSetEsquemaAutorizFactSector();

		if (esquemaautorizfactprov != null) {
			cargarRegistroEsquemaAutorizFactProv(datasetEsquemaAutorizFactProv, esquemaautorizfactprov.getOIDInteger(),
					esquemaautorizfactprov.getCodigo(), esquemaautorizfactprov.getDescripcion(), esquemaautorizfactprov
							.getMoneda(), esquemaautorizfactprov.isActivo());
			Iterator iterEsqAutorizFactMonto = esquemaautorizfactprov.getEsquemasMontos().iterator();
			while (iterEsqAutorizFactMonto.hasNext()) {
				EsquemaAutorizFactMonto esqAutorizFactMonto = (EsquemaAutorizFactMonto) iterEsqAutorizFactMonto.next();
				cargarRegistroEsquemaAutorizFactMonto(datasetEsquemaAutorizFactMon, esqAutorizFactMonto.getOIDInteger(),
						esqAutorizFactMonto.getEsquema_autoriz_factura(), esqAutorizFactMonto.getOrden(), esqAutorizFactMonto
								.getMonto_desde(), esqAutorizFactMonto.getMonto_hasta(), esqAutorizFactMonto.isActivo());

				Iterator iterEsquemasSectores = esqAutorizFactMonto.getEsquemasSectores().iterator();
				while (iterEsquemasSectores.hasNext()) {
					EsquemaAutorizFactSector esquemaAutorizFactSector = (EsquemaAutorizFactSector) iterEsquemasSectores.next();
					cargarRegistroEsquemaAutorizFactSector(datasetEsquemaAutorizFactSec,
							esquemaAutorizFactSector.getOIDInteger(), esqAutorizFactMonto, esquemaAutorizFactSector
									.getSector_compra(), esquemaAutorizFactSector.getRol_autotizador(), esquemaAutorizFactSector
									.getTipo_autoriz(), esquemaAutorizFactSector.isActivo());

				}

			}

		}

		writeCliente(datasetEsquemaAutorizFactProv);
		writeCliente(datasetEsquemaAutorizFactMon);
		writeCliente(datasetEsquemaAutorizFactSec);
	}

	private IDataSet getDataSetEsquemaAutorizFactProv() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEsquemaAutorizFactProv");
		dataset.fieldDef(new Field("oid_esq_aut_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_moneda", Field.STRING, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEsquemaAutorizFactProv(IDataSet dataset, Integer oid_esq_aut_fact, String codigo,
			String descripcion, Moneda oid_moneda, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_esq_aut_fact", oid_esq_aut_fact);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("oid_moneda", oid_moneda.getOIDInteger());
		dataset.fieldValue("activo", activo);
	}

	private IDataSet getDataSetEsquemaAutorizFactMonto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEsquemaAutorizFactMonto");
		dataset.fieldDef(new Field("oid_esq_aut_mon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_esq_aut_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("monto_desde", Field.INTEGER, 0));
		dataset.fieldDef(new Field("monto_hasta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEsquemaAutorizFactMonto(IDataSet dataset, Integer oid_esq_aut_mon,
			EsquemaAutorizFactProv oid_esq_aut_fact, Integer orden, Money monto_desde, Money monto_hasta,Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_esq_aut_mon", oid_esq_aut_mon);
		dataset.fieldValue("oid_esq_aut_fact", oid_esq_aut_fact.getOIDInteger());
		dataset.fieldValue("orden", orden);
		dataset.fieldValue("monto_desde", monto_desde);
		dataset.fieldValue("monto_hasta", monto_hasta);
		dataset.fieldValue("activo", activo);
	}

	private IDataSet getDataSetEsquemaAutorizFactSector() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEsquemaAutorizFactSector");
		dataset.fieldDef(new Field("oid_esq_aut_sec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_esq_aut_mon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_sector_compra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rol_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_autoriz", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEsquemaAutorizFactSector(IDataSet dataset, Integer oid_esq_aut_sec,
			EsquemaAutorizFactMonto oid_esq_aut_mon, SectorCompra oid_sector_compra, RolAutorizadorCompras oid_rol_autoriz,
			String tipo_autoriz, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_esq_aut_sec", oid_esq_aut_sec);
		dataset.fieldValue("oid_esq_aut_mon", oid_esq_aut_mon.getOIDInteger());
		dataset.fieldValue("oid_sector_compra", oid_sector_compra.getOIDInteger());
		dataset.fieldValue("oid_rol_autoriz", oid_rol_autoriz.getOIDInteger());
		dataset.fieldValue("tipo_autoriz", tipo_autoriz);
		dataset.fieldValue("activo", activo);
	}

}
