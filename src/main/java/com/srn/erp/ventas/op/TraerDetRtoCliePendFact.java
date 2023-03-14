package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetRtoCliePendFact extends Operation {

  public TraerDetRtoCliePendFact() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

  	Integer oidRemito   = mapaDatos.getInteger("oid_remito");
  	RemitoCab remitoCab = RemitoCab.findByOid(oidRemito,this.getSesion());
  	
  	IDataSet dsRemitoCab = this.getDataSetRemitoCab();
  	IDataSet dsRemitoDet = this.getDataSetRemitoDet();
  	
  	cargarRegistroRemitoCab(dsRemitoCab, remitoCab);
  	
  	Iterator iterRemitosDet = remitoCab.getDetalles().iterator();
  	while (iterRemitosDet.hasNext()) {
  		RemitoDet remitoDet = (RemitoDet) iterRemitosDet.next();
  		if (remitoDet.isPendienteFacturar())
  			 cargarRegistroRemitoDet(dsRemitoDet,remitoDet);
  	}
  	
  	
    writeCliente(dsRemitoCab);
    writeCliente(dsRemitoDet);
    
  }

	private IDataSet getDataSetRemitoDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRemitoDet");
		dataset.fieldDef(new Field("oid_remito_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_remito_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_desp", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_fact", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_pend_fact", Field.CURRENCY, 0));		
		dataset.fieldDef(new Field("oid_um_desp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_cco_ped_det", Field.INTEGER, 0));
		return dataset;
	}	

	private IDataSet getDataSetRemitoCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRemitoCab");
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc", Field.STRING, 20));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("compo_rto", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
		dataset.fieldDef(new Field("rz_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_remito_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("destinatario", Field.STRING, 50));
		dataset.fieldDef(new Field("destino", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_depo_dest", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_uni_edi_dest", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_uni_org_dest", Field.STRING, 0));
		dataset.fieldDef(new Field("pend_fact", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("calle_y_nro", Field.STRING, 50));
		dataset.fieldDef(new Field("localidad", Field.STRING, 50));
		dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rz_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_provincia", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_lp", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_mon_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_caja_def", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_forma_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_vendedor", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext_ped", Field.INTEGER, 0));
		
		
		
		return dataset;
	}
	
	private void cargarRegistroRemitoDet(IDataSet dataset, RemitoDet remitoDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_remito_det", remitoDet.getOIDInteger());
		dataset.fieldValue("oid_remito_cab", remitoDet.getRemito_cab().getOIDInteger());
		dataset.fieldValue("oid_producto", remitoDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", remitoDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", remitoDet.getProducto().getDescripcion());
		dataset.fieldValue("cant_desp", remitoDet.getCant_desp());
		dataset.fieldValue("cant_fact", remitoDet.getCant_fact());
		dataset.fieldValue("cant_pend_fact", remitoDet.getCantPendFact());
		dataset.fieldValue("oid_um_desp", remitoDet.getUnidad_desp().getOIDInteger());
		dataset.fieldValue("comentario", remitoDet.getComentario());
		dataset.fieldValue("activo", remitoDet.isActivo());
		if (remitoDet.getPedidoDet()!=null) {
		  dataset.fieldValue("precio", remitoDet.getPedidoDet().getPrecio());
		  dataset.fieldValue("porc_bonif_1", remitoDet.getPedidoDet().getBonif1());
		} else {
		  dataset.fieldValue("precio", 0);
		  dataset.fieldValue("porc_bonif_1", 0);
		}
		if (remitoDet.getPedidoDet()!=null)
			dataset.fieldValue("oid_cco_ped_det", remitoDet.getPedidoDet().getOID());
		else
			dataset.fieldValue("oid_cco_ped_det", 0);
	}
	
	
	

	private void cargarRegistroRemitoCab(IDataSet dataset, RemitoCab remitoCab) throws BaseException {
		dataset.append();

		if (remitoCab.getTalonario()!=null)
			dataset.fieldValue("oid_talonario", remitoCab.getTalonario().getOIDInteger());
		else
			dataset.fieldValue("oid_talonario", new Integer(0));
		dataset.fieldValue("oid_tc", remitoCab.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_tc", remitoCab.getTipoCompro().getCodigo());
		dataset.fieldValue("letra", remitoCab.getLetra());
		dataset.fieldValue("oid_lug_emi", remitoCab.getLugarEmision().getOIDInteger());
		dataset.fieldValue("nro_lug_emi", remitoCab.getLugarEmision().getLugemi());
		dataset.fieldValue("nro_ext", remitoCab.getNroExt());
		dataset.fieldValue("fecha", remitoCab.getEmision());
		if (remitoCab.getTipoConfMov()!=null)
			dataset.fieldValue("oid_tipo_conf_mov", remitoCab.getTipoConfMov().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_conf_mov", new Integer(0));
		dataset.fieldValue("compo_rto", remitoCab.getComportamiento());
		if (remitoCab.getSujeto() != null) {
			dataset.fieldValue("oid_sujeto", remitoCab.getSujeto().getOIDInteger());
			dataset.fieldValue("cod_sujeto", remitoCab.getSujeto().getCodigo());
			dataset.fieldValue("rz_sujeto", remitoCab.getSujeto().getRazon_social());
		}
		else {
			if (remitoCab.getProveedor() != null) {
				dataset.fieldValue("oid_sujeto", remitoCab.getProveedor().getOIDInteger());
				dataset.fieldValue("cod_sujeto", remitoCab.getProveedor().getCodigo());
				dataset.fieldValue("rz_sujeto", remitoCab.getProveedor().getRazonsocial());
			}
			else {
				dataset.fieldValue("oid_sujeto", 0);
				dataset.fieldValue("cod_sujeto", "");
				dataset.fieldValue("rz_sujeto", "");
			}
		}

		dataset.fieldValue("oid_remito_cab", remitoCab.getOIDInteger());

		dataset.fieldValue("destinatario", remitoCab.getDestinatario());
		dataset.fieldValue("destino", remitoCab.getDestino());
		if (remitoCab.getDepo_destino() != null)
			dataset.fieldValue("oid_depo_dest", remitoCab.getDepo_destino().getOIDInteger());
		else
			dataset.fieldValue("oid_depo_dest", 0);
		if (remitoCab.getUni_edi_dest() != null)
			dataset.fieldValue("oid_uni_edi_dest", remitoCab.getUni_edi_dest().getOIDInteger());
		else
			dataset.fieldValue("oid_uni_edi_dest", 0);
		if (remitoCab.getUni_org_dest() != null)
			dataset.fieldValue("oid_uni_org_dest", remitoCab.getUni_org_dest().getOIDInteger());
		else
			dataset.fieldValue("oid_uni_org_dest", 0);
		dataset.fieldValue("pend_fact", remitoCab.isPend_fact());
		if (remitoCab.getCalle_y_nro() != null)
			dataset.fieldValue("calle_y_nro", remitoCab.getCalle_y_nro());
		else
			dataset.fieldValue("calle_y_nro", "");
		dataset.fieldValue("localidad", remitoCab.getLocalidad());
		dataset.fieldValue("codigo_postal", remitoCab.getCodigo_postal());

		if (remitoCab.getProvincia() != null)
			dataset.fieldValue("oid_provincia", remitoCab.getProvincia().getOIDInteger());
		else
			dataset.fieldValue("oid_provincia", 0);

		if (remitoCab.getPais() != null)
			dataset.fieldValue("oid_pais", remitoCab.getPais().getOIDInteger());
		else
			dataset.fieldValue("oid_pais", 0);

		if (remitoCab.getProveedor() != null) {
			dataset.fieldValue("oid_proveedor", remitoCab.getProveedor().getOIDInteger());
			dataset.fieldValue("cod_proveedor", remitoCab.getProveedor().getCodigo());
			dataset.fieldValue("rz_proveedor", remitoCab.getProveedor().getRazonsocial());
		}
		else {
			if (remitoCab.getSujeto() != null) {
				dataset.fieldValue("oid_proveedor", remitoCab.getSujeto().getOIDInteger());
				dataset.fieldValue("cod_proveedor", remitoCab.getSujeto().getCodigo());
				dataset.fieldValue("rz_proveedor", remitoCab.getSujeto().getRazon_social());
			}
			else {
				dataset.fieldValue("oid_proveedor", 0);
				dataset.fieldValue("cod_proveedor", "");
				dataset.fieldValue("rz_proveedor", "");
			}
		}
		dataset.fieldValue("activo", remitoCab.isActivo());
		
		if (remitoCab.getProvincia()!=null)
			dataset.fieldValue("cod_provincia", remitoCab.getProvincia().getCodigo());
		else
			dataset.fieldValue("cod_provincia", "");
		
		
		Moneda monedaLocal = Moneda.getMonedaCursoLegal(this.getSesion());
		
		if (remitoCab.getPedidos().size()>0) {
			// Tomar el primer pedido
			PedidoCab primerPedido = (PedidoCab) remitoCab.getPedidos().get(0);
			dataset.fieldValue("oid_lp", primerPedido.getLista_precios().getOIDInteger());
			dataset.fieldValue("cod_lp", primerPedido.getLista_precios().getCodigo());
			if (primerPedido.getMonedaFact().getOIDInteger()!=null)
				dataset.fieldValue("oid_mon_fact", primerPedido.getMonedaFact().getOIDInteger());
			else
				dataset.fieldValue("oid_mon_fact", monedaLocal.getOIDInteger());
			dataset.fieldValue("oid_forma_pago", primerPedido.getCondicionPago().getOIDInteger());
			dataset.fieldValue("oid_vendedor", primerPedido.getVendedor().getOIDInteger());
			dataset.fieldValue("cod_vendedor", primerPedido.getVendedor().getCodigo());
			dataset.fieldValue("oid_caja_def" , Caja.getCajaDefFactRemito(this.getSesion()).getOIDInteger() );
			dataset.fieldValue("oid_cco_ped", primerPedido.getOIDInteger());
			dataset.fieldValue("nro_ext_ped", primerPedido.getNroExt());
			
		} else {
			dataset.fieldValue("oid_lp", 0);
			dataset.fieldValue("cod_lp", "");
			dataset.fieldValue("oid_mon_fact", monedaLocal.getOIDInteger());
			dataset.fieldValue("oid_forma_pago", 0);
			dataset.fieldValue("oid_vendedor", 0);
			dataset.fieldValue("cod_vendedor", "");
			dataset.fieldValue("oid_caja_def" , Caja.getCajaDefFactRemito(this.getSesion()).getOIDInteger() );
			dataset.fieldValue("oid_cco_ped", 0);
			dataset.fieldValue("nro_ext_ped", 0);
			
		}
		
		
		


	}
	
	
	
}
