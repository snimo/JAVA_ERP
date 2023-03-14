package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpRemitos extends Operation {

	public TraerHelpRemitos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer nroExtDesde = null;
		Integer nroExtHasta = null;
		java.util.Date fecDesde = null;
		java.util.Date fecHasta = null;
		Talonario talonario = null;
		Proveedor proveedor = null;
		Sujeto sujeto = null;
		Producto producto = null;
		String tipoRemito = null;
		HashTableDatos condiciones = new HashTableDatos();
		String tipo = null;
		PedidoCab pedido = null;

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
			talonario = Talonario.findByOidProxy(mapaDatos.getInteger("oid_talonario"), getSesion());
			condiciones.put(Talonario.NICKNAME, talonario);
		}
		if (mapaDatos.containsKey("oid_proveedor")) {
			proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"), getSesion());
			condiciones.put(Proveedor.NICKNAME, proveedor);
		}
		
		if (mapaDatos.containsKey("oid_cco_ped")) {
			pedido = PedidoCab.findByOidProxy(mapaDatos.getInteger("oid_cco_ped"), getSesion());
			condiciones.put(PedidoCab.NICKNAME, pedido);
		}
		
		if (mapaDatos.containsKey("oid_sujeto")) {
			sujeto = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_sujeto"), getSesion());
			condiciones.put(Sujeto.NICKNAME, sujeto);
		}
		if (mapaDatos.containsKey("oid_producto")) {
			producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"), getSesion());
			condiciones.put(Producto.NICKNAME, producto);
		}
		if (mapaDatos.containsKey("tipo_remito")) {
			tipoRemito = mapaDatos.getString("tipo_remito");
			condiciones.put("tipo_remito",tipoRemito);
		}
		
		if (mapaDatos.containsKey("TIPO")) {
			tipo = mapaDatos.getString("TIPO");
			condiciones.put("tipo",tipo);
		}
		
		if (mapaDatos.containsKey("pend_recep")) {
			condiciones.put("pend_recep","");
		}
		

		IDataSet datasetRemito = this.getDataSetRemito();
		traerRemitos(datasetRemito, condiciones);
		writeCliente(datasetRemito);
	}

	private void traerRemitos(IDataSet dataSet, HashTableDatos condiciones) throws BaseException {
		Iterator iterRemitos = RemitoCab.getRemitosByCondiciones(condiciones, getSesion()).iterator();
		while (iterRemitos.hasNext()) {
			RemitoCab remitoCab = (RemitoCab) iterRemitos.next();
			cargarRegistroRemito(dataSet, remitoCab);
		}
	}

	private IDataSet getDataSetRemito() {
		IDataSet dataset = new TDataSet();
		dataset.create("THelpRemitosClientes");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_co", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 50));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroRemito(IDataSet dataset, RemitoCab remitoCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", remitoCab.getOIDInteger());
		dataset.fieldValue("oid_co", remitoCab.getOIDInteger());
		dataset.fieldValue("codigo", remitoCab.getCodigo());
		dataset.fieldValue("nro_ext", remitoCab.getNroExt());
		dataset.fieldValue("fec_emision", remitoCab.getEmision());
		if (remitoCab.getSujeto() != null) {
			dataset.fieldValue("oid_sujeto", remitoCab.getSujeto().getOIDInteger());
			dataset.fieldValue("cod_sujeto", remitoCab.getSujeto().getCodigo());
			dataset.fieldValue("rs_sujeto", remitoCab.getSujeto().getRazon_social());
		}
		else if (remitoCab.getProveedor() != null) {
			dataset.fieldValue("oid_sujeto", remitoCab.getProveedor().getOIDInteger());
			dataset.fieldValue("cod_sujeto", remitoCab.getProveedor().getCodigo());
			dataset.fieldValue("rs_sujeto", remitoCab.getProveedor().getRazonsocial());
		}
		else if (remitoCab.getDepo_destino() != null) {
			dataset.fieldValue("oid_sujeto", remitoCab.getDepo_destino().getOIDInteger());
			dataset.fieldValue("cod_sujeto", remitoCab.getDepo_destino().getCodigo());
			dataset.fieldValue("rs_sujeto", remitoCab.getDepo_destino().getDescripcion());
		}
		else {
			dataset.fieldValue("oid_sujeto", 0);
			dataset.fieldValue("cod_sujeto", "");
			dataset.fieldValue("rs_sujeto", "");
		}
		dataset.fieldValue("anulado", new Boolean(!remitoCab.isActivo().booleanValue()));
	}

}
