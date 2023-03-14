package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.AutorizacionOC;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsultaAutorizOC extends Operation {

	HashTableDatos	condiciones	= new HashTableDatos();

	public TraerConsultaAutorizOC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		cargarParametros(mapaDatos);
		traerConsultaEstadosOC();
	}

	public void traerConsultaEstadosOC() throws BaseException {

		IDataSet dataSetConsulta = this.getDataSetConsultaAutorizOC();
		IDataSet dsConsDet = this.getDataSetMotivosAutorizOC();
		
		Iterator iterConsOC = OrdenDeCompraCab.getOrdenDeCompraCab(condiciones, getSesion()).iterator();
		while (iterConsOC.hasNext()) {
			OrdenDeCompraCab ordenDeCompraCab = (OrdenDeCompraCab) iterConsOC.next();
			cargarRegistroAutorizOC(dataSetConsulta, ordenDeCompraCab);
			Iterator iterAutorizacionOC = ordenDeCompraCab.getAutorizacionesOC().iterator();
			while (iterAutorizacionOC.hasNext()) {
				AutorizacionOC autorizacionOC = (AutorizacionOC)iterAutorizacionOC.next();
				cargarRegistroMotivoAutorizOC(dsConsDet,autorizacionOC);
			}
			
		}

		writeCliente(dataSetConsulta);
		writeCliente(dsConsDet);

	}

	private void cargarParametros(MapDatos mapaDatos) throws BaseException {

		if (mapaDatos.containsKey("fec_emi_desde")) {
			java.util.Date fecEmiDesde = mapaDatos.getDate("fec_emi_desde");
			condiciones.put("FEC_EMI_DESDE", fecEmiDesde);
		}
		if (mapaDatos.containsKey("fec_emi_hasta")) {
			java.util.Date fecEmiHasta = mapaDatos.getDate("fec_emi_hasta");
			condiciones.put("FEC_EMI_HASTA", fecEmiHasta);
		}
		if (mapaDatos.containsKey("nro_desde"))
			condiciones.put("NRO_DESDE", mapaDatos.getInteger("nro_desde"));
		if (mapaDatos.containsKey("nro_hasta"))
			condiciones.put("NRO_HASTA", mapaDatos.getInteger("nro_hasta"));

		if (mapaDatos.containsKey("oid_talonario")) {
			Integer oidTalonario = mapaDatos.getInteger("oid_talonario");
			Talonario talonario = Talonario.findByOidProxy(oidTalonario, getSesion());
			condiciones.put(Talonario.NICKNAME, talonario);
		}

		if (mapaDatos.containsKey("oid_producto")) {
			Integer oidProducto = mapaDatos.getInteger("oid_producto");
			Producto producto = Producto.findByOidProxy(oidProducto, getSesion());
			condiciones.put(Producto.NICKNAME, producto);
		}

		if (mapaDatos.containsKey("oid_prov")) {
			Integer oidProveedor = mapaDatos.getInteger("oid_prov");
			Proveedor proveedor = Proveedor.findByOidProxy(oidProveedor, getSesion());
			condiciones.put(Proveedor.NICKNAME, proveedor);
		}

		if (mapaDatos.containsKey("codigo_oc")) {
			
			OrdenDeCompraCab oc = 
				OrdenDeCompraCab.getOrdeDeCompra(mapaDatos.getString("codigo_oc"), this.getSesion());
			
			if (oc!=null)
				condiciones.put(OrdenDeCompraCab.NICKNAME, oc);
		}

		if (mapaDatos.containsKey("filtro_oc")) {
			String filtro_oc = mapaDatos.getString("filtro_oc");
			condiciones.put("FILTRO_OC", filtro_oc);
		}

		if (mapaDatos.containsKey("estado_autoriz")) {
			Integer estado_autoriz = mapaDatos.getInteger("estado_autoriz");
			condiciones.put("ESTADO_AUTORIZACION", estado_autoriz);
		}

	}

	private IDataSet getDataSetConsultaAutorizOC() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsAutorizOC");

		dataset.fieldDef(new Field("seleccionar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_oc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_oc", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("total_oc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rz_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_sector", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cond_pago", Field.STRING, 100));
		dataset.fieldDef(new Field("via_despacho", Field.STRING, 100));
		dataset.fieldDef(new Field("cond_compra", Field.STRING, 100));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("estado_autorizacion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("roles_autorizadores", Field.STRING, 500));
		return dataset;
	}
	
	private IDataSet getDataSetMotivosAutorizOC() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivosAutorizOC");
		dataset.fieldDef(new Field("oid_autoriz_oc", Field.INTEGER , 0));
		dataset.fieldDef(new Field("seleccionar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_oc", Field.INTEGER , 0));
		dataset.fieldDef(new Field("desc_motivo", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_rol_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_alta", Field.DATE, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_estado_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_estado_autoriz", Field.STRING, 50));
		dataset.fieldDef(new Field("usuario",Field.STRING, 50));
		dataset.fieldDef(new Field("fec_autoriz", Field.DATE, 0));
		return dataset;
	}
	
	private void cargarRegistroMotivoAutorizOC(IDataSet dataset, AutorizacionOC autorizacionOC) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_autoriz_oc", autorizacionOC.getOIDInteger());
		dataset.fieldValue("seleccionar", new Boolean(false));
		dataset.fieldValue("oid_oc", autorizacionOC.getOrden_de_compra().getOIDInteger());
		dataset.fieldValue("desc_motivo", autorizacionOC.getDesc_motivo());
		dataset.fieldValue("oid_rol_autoriz", autorizacionOC.getRol_autorizador().getOIDInteger());
		dataset.fieldValue("fec_alta", autorizacionOC.getFec_alta());
		dataset.fieldValue("comentario", autorizacionOC.getComentario());
		dataset.fieldValue("oid_estado_autoriz", autorizacionOC.getDecision_autoriz());
		dataset.fieldValue("desc_estado_autoriz",autorizacionOC.getLeyendaDecisionAutoriz());
		
		if (autorizacionOC.getUsuario()!=null)
			dataset.fieldValue("usuario",autorizacionOC.getUsuario().getApellidoyNombre());
		else
			dataset.fieldValue("usuario","");
		if (autorizacionOC.getFec_dec_autoriz()!=null)
			dataset.fieldValue("fec_autoriz", autorizacionOC.getFec_dec_autoriz());
		else
			dataset.fieldValue("fec_autoriz", Fecha.FECHA_NULA());
		
	}

	private void cargarRegistroAutorizOC(IDataSet dataset, OrdenDeCompraCab oc) throws BaseException {

		dataset.append();
		dataset.fieldValue("seleccionar", new Boolean(false));
		dataset.fieldValue("oid_oc", oc.getOIDInteger());
		dataset.fieldValue("codigo_oc", oc.getCodigo());
		dataset.fieldValue("nro_ext", oc.getNroExt());
		dataset.fieldValue("oid_moneda", oc.getMoneda().getOIDInteger());
		dataset.fieldValue("total_oc", oc.getTotMontoOC());
		dataset.fieldValue("fecha", oc.getEmision());
		dataset.fieldValue("oid_proveedor", oc.getProveedor().getOIDInteger());
		dataset.fieldValue("cod_proveedor", oc.getProveedor().getCodigo());
		dataset.fieldValue("rz_proveedor", oc.getProveedor().getRazonsocial());
		if (oc.getSectorCompra()!=null)
			dataset.fieldValue("oid_sector", oc.getSectorCompra().getOIDInteger());
		else
			dataset.fieldValue("oid_sector", 0);
		if (oc.getCond_pago_1() != null)
			dataset.fieldValue("cond_pago", oc.getCond_pago_1().getDescripcion());
		else
			dataset.fieldValue("cond_pago", "");
		if (oc.getVia_despacho() != null)
			dataset.fieldValue("via_despacho", oc.getVia_despacho().getDescripcion());
		else
			dataset.fieldValue("via_despacho", "");
		if (oc.getCond_compra_importacion() != null)
			dataset.fieldValue("cond_compra", oc.getCond_compra_importacion().getDescripcion());
		else
			dataset.fieldValue("cond_compra", "");
		dataset.fieldValue("comentario", oc.getComentario());
		dataset.fieldValue("anulado", new Boolean(!oc.isActivo().booleanValue()));
		dataset.fieldValue("estado_autorizacion", oc.getEstado_autorizacion());
		dataset.fieldValue("roles_autorizadores", oc.getAutorizadoresOC());
	}
}
