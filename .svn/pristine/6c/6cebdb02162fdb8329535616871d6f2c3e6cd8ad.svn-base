package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.CotizacionProveedorCab;
import com.srn.erp.compras.bm.CotizacionProveedorDet;
import com.srn.erp.compras.bm.MotivoDecisionAdjudicacion;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizDetPorProv;
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

public class TraerConsultaCotizProv extends Operation {

	HashTableDatos condiciones = new HashTableDatos();

	public TraerConsultaCotizProv() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		cargarParametros(mapaDatos);
		traerConsulta();
	}

	public void traerConsulta() throws BaseException {

		IDataSet dataSetConsulta = getDataSetConsultaCotizProv();
		IDataSet dataSetCotizDet = getDataSetCotizacionProveedorDet();

		Iterator iterCotizProv = CotizacionProveedorCab.getCotizacionesProvCab(condiciones, getSesion()).iterator();
		while (iterCotizProv.hasNext()) {
			CotizacionProveedorCab cotizProvCab = (CotizacionProveedorCab) iterCotizProv.next();
			cargarRegistroCotizProv(dataSetConsulta, cotizProvCab);
			
			Iterator iterDetCotiz = 
				cotizProvCab.getDetallesCotizaciones().iterator();
			while (iterDetCotiz.hasNext()) {
				CotizacionProveedorDet cotizProvDet = (CotizacionProveedorDet) iterDetCotiz.next();
				cargarRegistroCotizacionProveedorDet(dataSetCotizDet, cotizProvCab, cotizProvDet);
			}

		}

		writeCliente(dataSetConsulta);
		writeCliente(dataSetCotizDet);

	}

	private void cargarParametros(MapDatos mapaDatos) throws BaseException {

		if (mapaDatos.containsKey("oid_proveedor")) {
			Proveedor proveedor = Proveedor.findByOid(mapaDatos.getInteger("oid_proveedor"), getSesion());
			condiciones.put(Proveedor.NICKNAME, proveedor);
		}
		if (mapaDatos.containsKey("oid_producto")) {
			Producto producto = Producto.findByOid(mapaDatos.getInteger("oid_producto"), getSesion());
			condiciones.put(Producto.NICKNAME, producto);
		}
		if (mapaDatos.containsKey("fec_emi_desde")) {
			java.util.Date fecEmiDesde = mapaDatos.getDate("fec_emi_desde");
			condiciones.put("FEC_EMI_DESDE", fecEmiDesde);
		}
		if (mapaDatos.containsKey("fec_emi_hasta")) {
			java.util.Date fecEmiHasta = mapaDatos.getDate("fec_emi_hasta");
			condiciones.put("FEC_EMI_HASTA", fecEmiHasta);
		}
		if (mapaDatos.containsKey("estado_cotiz")) {
			Integer estadoCotizacion = mapaDatos.getInteger("estado_cotiz");
			condiciones.put("ESTADO_COTIZACION", estadoCotizacion);
		}
		if (mapaDatos.containsKey("fec_vigente")) {
			java.util.Date fecVigente = mapaDatos.getDate("fec_vigente");
			condiciones.put("FEC_VIG_AL", fecVigente);
		}
		if (mapaDatos.containsKey("oid_talonario")) {
			Talonario talonario = Talonario.findByOid(mapaDatos.getInteger("oid_talonario"), getSesion());
			condiciones.put(Talonario.NICKNAME, talonario);
		}
		
		if (mapaDatos.containsKey("oid_motivo")) {
			MotivoDecisionAdjudicacion motivo = MotivoDecisionAdjudicacion.findByOid(mapaDatos.getInteger("oid_motivo"), getSesion());
			condiciones.put(MotivoDecisionAdjudicacion.NICKNAME, motivo);
		}
		
		
		if (mapaDatos.containsKey("nro_desde")) {
			Integer nroDesde = mapaDatos.getInteger("nro_desde");
			condiciones.put("NRO_DESDE", nroDesde);
		}
		if (mapaDatos.containsKey("nro_hasta")) {
			Integer nroHasta = mapaDatos.getInteger("nro_hasta");
			condiciones.put("NRO_HASTA", nroHasta);
		}

		if (mapaDatos.containsKey("oid_cco")) {
			Integer oidcco = mapaDatos.getInteger("oid_cco");
			condiciones.put("OID_CCO", oidcco);
		}
		
		if (mapaDatos.containsKey("abierto_cerrado")) {
			condiciones.put("abierto_cerrado", mapaDatos.getString("abierto_cerrado"));
		}
		

	}

	private IDataSet getDataSetConsultaCotizProv() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsEstadoCotizProv");
		dataset.fieldDef(new Field("oid_cotiz_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_cotiz_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_vig_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_vig_hasta", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_estado_cotiz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_estado_adju", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_usu_est_adju", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre_usu_est_adju", Field.STRING, 50));
		dataset.fieldDef(new Field("abierto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
		
		return dataset;
	}

	private void cargarRegistroCotizProv(IDataSet dataset, CotizacionProveedorCab cotizProvCab) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_cotiz_prov", cotizProvCab.getOIDInteger());
		dataset.fieldValue("codigo_cotiz_prov", cotizProvCab.getCodigo());
		dataset.fieldValue("nro_ext", cotizProvCab.getNroExt());
		dataset.fieldValue("fec_emision", cotizProvCab.getEmision());
		dataset.fieldValue("fec_vig_desde", cotizProvCab.getVigencia_desde());
		dataset.fieldValue("fec_vig_hasta", cotizProvCab.getVigencia_hasta());
		dataset.fieldValue("oid_prov", cotizProvCab.getProveedor().getOIDInteger());
		dataset.fieldValue("cod_prov", cotizProvCab.getProveedor().getCodigo());
		dataset.fieldValue("rs_prov", cotizProvCab.getProveedor().getRazonsocial());
		dataset.fieldValue("anulado", new Boolean(!cotizProvCab.isActivo().booleanValue()));
		if (cotizProvCab.getMotivoDecisionAdjudicacion()!=null)
			dataset.fieldValue("oid_motivo",cotizProvCab.getMotivoDecisionAdjudicacion().getOIDInteger());
		else
			dataset.fieldValue("oid_motivo",new Integer(0));
		dataset.fieldValue("oid_estado_cotiz", cotizProvCab.getEstadoAdjudicacion());
		if (cotizProvCab.getFechaEstadoAdjudicacion() != null)
			dataset.fieldValue("fec_estado_adju", cotizProvCab.getFechaEstadoAdjudicacion());
		else
			dataset.fieldValue("fec_estado_adju", Fecha.FECHA_NULA());
		if (cotizProvCab.getUsuarioAdjudicacion() != null) {
			dataset.fieldValue("oid_usu_est_adju", cotizProvCab.getUsuarioAdjudicacion().getOIDInteger());
			dataset.fieldValue("nombre_usu_est_adju", cotizProvCab.getUsuarioAdjudicacion().getApellidoyNombre());
		} else {
			dataset.fieldValue("oid_usu_est_adju", 0);
			dataset.fieldValue("nombre_usu_est_adju", "");
		}
		
		if (cotizProvCab.isCotizacionAbierta())
			dataset.fieldValue("abierto", 1);
		else
			dataset.fieldValue("abierto", 0);
		dataset.fieldValue("oid_proveedor", cotizProvCab.getProveedor().getOIDInteger());
		dataset.fieldValue("cod_proveedor", cotizProvCab.getProveedor().getCodigo());
		dataset.fieldValue("oid_moneda", cotizProvCab.getMoneda().getOIDInteger());
		if (cotizProvCab.getCond_pago_1()!=null)
			dataset.fieldValue("oid_cond_pago", cotizProvCab.getCond_pago_1().getOIDInteger());
		else if (cotizProvCab.getCond_pago_2()!=null)
			dataset.fieldValue("oid_cond_pago", cotizProvCab.getCond_pago_2().getOIDInteger());
		else 
			dataset.fieldValue("oid_cond_pago", "");
	}

	private IDataSet getDataSetCotizacionProveedorDet() {
		IDataSet dataset = new TDataSet();

		dataset.create("TCotizacionProveedorDet");
		dataset.fieldDef(new Field("oid_cotiz_prov_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cotiz_prov_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cotiz_det_prov", Field.INTEGER, 0));

		// Por la Solicitud a Proveedores
		dataset.fieldDef(new Field("nro_item_sol_cotiz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_art_sol_cotiz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_art_sol_cotiz", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_art_sol_cotiz", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_adic_art", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_um_sol_cotiz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_sol_cotiz", Field.STRING, 20));
		dataset.fieldDef(new Field("cantidad_sol_cotiz", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fecha_ent_sol_cotiz", Field.DATE, 0));
		dataset.fieldDef(new Field("desc_adic_sol_cotiz", Field.STRING, 255));
		dataset.fieldDef(new Field("anulado_sol_cotiz", Field.BOOLEAN, 0));

		// Datos del Presupuesto del Proveedor
		dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_presu", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fec_ent", Field.DATE, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_cond_pago_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("dto_cond_pago_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_cond_pago_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("dto_cond_pago_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroCotizacionProveedorDet(IDataSet dataset, CotizacionProveedorCab cotizProvCab,
			CotizacionProveedorDet cotizProvDet) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_cotiz_prov_det", cotizProvDet.getOIDInteger());
		dataset.fieldValue("oid_cotiz_prov_cab", cotizProvCab.getOIDInteger());
		if (cotizProvDet.getCotizacion_det_prov() != null)
			dataset.fieldValue("oid_cotiz_det_prov", cotizProvDet.getCotizacion_det_prov().getOIDInteger());
		else
			dataset.fieldValue("oid_cotiz_det_prov", 0);
		dataset.fieldValue("nro_item_sol_cotiz", cotizProvDet.getNroItem());
		cargarDatosSolCotizDet(dataset, cotizProvDet.getProducto(), cotizProvDet.getCotizacion_det_prov());

		dataset.fieldValue("oid_um", cotizProvDet.getUnidad_medida().getOIDInteger());
		dataset.fieldValue("cant_presu", cotizProvDet.getCant_presu());
		dataset.fieldValue("oid_moneda", cotizProvDet.getMoneda().getOIDInteger());
		dataset.fieldValue("precio", cotizProvDet.getPrecio());
		dataset.fieldValue("fec_ent", Fecha.getddmmyyyy(cotizProvDet.getFec_ent()));
		if (cotizProvDet.getComentario() != null)
			dataset.fieldValue("comentario", cotizProvDet.getComentario());
		else
			dataset.fieldValue("comentario", "");
		if (cotizProvDet.getCond_pago_1() != null)
			dataset.fieldValue("oid_cond_pago_1", cotizProvDet.getCond_pago_1().getOIDInteger());
		else
			dataset.fieldValue("oid_cond_pago_1", 0);
		if (cotizProvDet.getDto_cond_pago_1() != null)
			dataset.fieldValue("dto_cond_pago_1", cotizProvDet.getDto_cond_pago_1());
		else
			dataset.fieldValue("dto_cond_pago_1", 0);
		if (cotizProvDet.getCond_pago_2() != null)
			dataset.fieldValue("oid_cond_pago_2", cotizProvDet.getCond_pago_2().getOIDInteger());
		else
			dataset.fieldValue("oid_cond_pago_2", 0);
		if (cotizProvDet.getDto_cond_pago_2() != null)
			dataset.fieldValue("dto_cond_pago_2", cotizProvDet.getDto_cond_pago_2());
		else
			dataset.fieldValue("dto_cond_pago_2", 0);

		dataset.fieldValue("anulado", cotizProvDet.isAnulado());
	}
	
	  private void cargarDatosSolCotizDet(IDataSet dataset,Producto producto,SolicitudCotizDetPorProv cotiz_det_prov) throws BaseException {
		  if (cotiz_det_prov!=null) {
		    dataset.fieldValue("oid_art_sol_cotiz",producto.getOIDInteger());	
		    dataset.fieldValue("cod_art_sol_cotiz",producto.getCodigo());
		    dataset.fieldValue("desc_art_sol_cotiz",producto.getDescripcion());
		    if (cotiz_det_prov.getSolicitud_cotiz_det()!=null) {
		       if (cotiz_det_prov.getSolicitud_cotiz_det().getDesc_adic_sku()!=null)	
		          dataset.fieldValue("desc_adic_art",cotiz_det_prov.getSolicitud_cotiz_det().getDesc_adic_sku());
		       else
		    	  dataset.fieldValue("desc_adic_art",""); 
		    }
		    else
		       dataset.fieldValue("desc_adic_art","");	
		    dataset.fieldValue("oid_um_sol_cotiz",cotiz_det_prov.getOid_um_cpra().getOIDInteger());
		    dataset.fieldValue("cod_um_sol_cotiz",cotiz_det_prov.getOid_um_cpra().getCodigo());
		    dataset.fieldValue("cantidad_sol_cotiz",cotiz_det_prov.getCant_a_cotizar());
		    dataset.fieldValue("fecha_ent_sol_cotiz",Fecha.getddmmyyyy(cotiz_det_prov.getSolicitud_cotiz_det().getFec_entrega()));
		    dataset.fieldValue("desc_adic_sol_cotiz",cotiz_det_prov.getObs_art_prov());
		    dataset.fieldValue("anulado_sol_cotiz",new Boolean(false));
		  }
		  else {
		    dataset.fieldValue("oid_art_sol_cotiz",producto.getOIDInteger());	
		    dataset.fieldValue("cod_art_sol_cotiz",producto.getCodigo());
		    dataset.fieldValue("desc_art_sol_cotiz",producto.getDescripcion());
			dataset.fieldValue("desc_adic_art","");
			dataset.fieldValue("oid_um_sol_cotiz",0);
			dataset.fieldValue("cod_um_sol_cotiz","");
			dataset.fieldValue("cantidad_sol_cotiz",0);
			dataset.fieldValue("fecha_ent_sol_cotiz",Fecha.FECHA_NULA());
			dataset.fieldValue("desc_adic_sol_cotiz","");			  
			dataset.fieldValue("anulado_sol_cotiz",new Boolean(false));
		  }
	  }
  
	

}
