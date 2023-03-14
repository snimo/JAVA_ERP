package com.srn.erp.compras.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Talonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpInfRecPendFact extends Operation {

	public TraerHelpInfRecPendFact() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dsInfRec = getDataSetInfRec();
		IDataSet dsInfRecDet = getDataSetInfRecDetDet();
		traerInfRec(dsInfRec, dsInfRecDet , mapaDatos);
		writeCliente(dsInfRec);
		writeCliente(dsInfRecDet);
	}

	private void traerInfRec(IDataSet dataSet, IDataSet datsetDet,MapDatos mapaDatos)
			throws BaseException {

		Integer nroExtDesde = null;
		Integer nroExtHasta = null;
		java.util.Date fecDesde = null;
		java.util.Date fecHasta = null;
		Talonario talonario = null;
		Proveedor proveedor = null;
		OrdenDeCompraCab oc = null;
		HashTableDatos condiciones = new HashTableDatos();

		if (mapaDatos.containsKey("nro_ext_desde")) {
			nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
			condiciones.put("NRO_DESDE", nroExtDesde);
		}
		if (mapaDatos.containsKey("nro_ext_hasta")) {
			nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
			condiciones.put("NRO_HASTA", nroExtHasta);
		}
		if (mapaDatos.containsKey("fec_emi_desde")) {
			fecDesde = mapaDatos.getDate("fec_emi_desde");
			condiciones.put("FEC_DESDE", fecDesde);
		}
		if (mapaDatos.containsKey("fec_emi_hasta")) {
			fecHasta = mapaDatos.getDate("fec_emi_hasta");
			condiciones.put("FEC_HASTA", fecHasta);
		}
		if (mapaDatos.containsKey("oid_talonario")) {
			talonario = Talonario.findByOidProxy(mapaDatos
					.getInteger("oid_talonario"), getSesion());
			condiciones.put(Talonario.NICKNAME, talonario);
		}
		if (mapaDatos.containsKey("oid_proveedor")) {
			proveedor = Proveedor.findByOidProxy(mapaDatos
					.getInteger("oid_proveedor"), getSesion());
			condiciones.put(Proveedor.NICKNAME, proveedor);
		}

		List listaInfRec = InformeRecepcion.getInformesRecepcionPendFact(
				condiciones, getSesion());
		Iterator iterInfRec = listaInfRec.iterator();
		while (iterInfRec.hasNext()) {
			InformeRecepcion informeRecepcion = (InformeRecepcion) iterInfRec
					.next();
			cargarRegistroInfRec(dataSet, informeRecepcion);
			
			Iterator iterDetalles = informeRecepcion.getDetallesInfRec().iterator();
			while (iterDetalles.hasNext()) {
				InformeRecepcionDet infRecDet = (InformeRecepcionDet) iterDetalles.next();
				cargarRegistroInfReDet(datsetDet,informeRecepcion,infRecDet);
			}
		}

	}

	private IDataSet getDataSetInfRec() {
		IDataSet dataset = new TDataSet();
		dataset.create("THelpInfRec");
		dataset.fieldDef(new Field("sel",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_co", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_prov", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetInfRecDetDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInfRecDet");
		dataset.fieldDef(new Field("oid_inf_rec_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_inf_rec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("cant_recibida_uc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_facturada_uc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pend_fact_uc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_oc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_oc", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistroInfRec(IDataSet dataset,
			InformeRecepcion informeRecepcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel",new Boolean(false));
		dataset.fieldValue("oid", informeRecepcion.getOIDInteger());
		dataset.fieldValue("oid_co", informeRecepcion.getOIDInteger());
		dataset.fieldValue("codigo", informeRecepcion.getCodigo());
		dataset.fieldValue("oid_proveedor", informeRecepcion.getProveedor()
				.getOIDInteger());
		dataset.fieldValue("cod_prov", informeRecepcion.getProveedor()
				.getCodigo());
		dataset.fieldValue("rs_prov", informeRecepcion.getProveedor()
				.getRazonsocial());
		dataset.fieldValue("nro_ext", informeRecepcion.getNroExt());
		dataset.fieldValue("fec_emision", informeRecepcion.getImputac());
		dataset.fieldValue("anulado", new Boolean(!informeRecepcion.isActivo()
				.booleanValue()));
	}

	private void cargarRegistroInfReDet(IDataSet dataset,
			InformeRecepcion informeRecepcion, InformeRecepcionDet infRecDet)
			throws BaseException {
		if (infRecDet.isAnulado().booleanValue()) return;
		if (!infRecDet.isPendFacturar().booleanValue()) return;
		dataset.append();
		dataset.fieldValue("oid_inf_rec_det", infRecDet.getOIDInteger());
		dataset.fieldValue("oid_inf_rec", informeRecepcion.getOIDInteger());
		dataset.fieldValue("oid_producto", infRecDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", infRecDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", infRecDet.getProducto().getDescripcion());
		dataset.fieldValue("cant_recibida_uc", infRecDet.getCant_rec_en_uc());
		dataset.fieldValue("cant_facturada_uc", infRecDet.getCantFactUC());
		dataset.fieldValue("pend_fact_uc", infRecDet.getCantPendFactUC());
		dataset.fieldValue("oid_oc", infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getOIDInteger());
		dataset.fieldValue("codigo_oc", infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getCodigo());
	}

}
