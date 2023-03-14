package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.Proveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarNroRtoProv extends Operation {

	public ValidarNroRtoProv() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Proveedor proveedor = 
			Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"), this.getSesion());
		String rtoProv = mapaDatos.getString("rto");
		
		InformeRecepcion infRec = proveedor.getInformeRecepcion(rtoProv);
		
			
		if (!mapaDatos.containsKey("NO_VERIFICAR_DUPLICADO")) {
		  if (infRec!=null)
			  throw new ExceptionValidation(null,"Remito de Proveedor ya ingresado.");
		}
		
		IDataSet ds = this.getDataSetInformeRecepcion();
		if (infRec!=null) {
		  cargarRegistroInformeRecepcion(ds, infRec);
		}
		writeCliente(ds);
		
	}
	
	private IDataSet getDataSetInformeRecepcion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValInformeRecepcion");
		dataset.fieldDef(new Field("oid_inf_rec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc",Field.STRING, 50));
		dataset.fieldDef(new Field("letra",Field.STRING, 5));
		dataset.fieldDef(new Field("oid_lug_emi",Field.INTEGER, 0));
		dataset.fieldDef(new Field("lug_emi",Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_prov",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov",Field.STRING, 50));
		dataset.fieldDef(new Field("rs_prov",Field.STRING, 100));
		dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("remito_prov",Field.STRING, 50));
		dataset.fieldDef(new Field("comentario",Field.STRING, 255));
		dataset.fieldDef(new Field("oid_oc",Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_oc",Field.STRING, 50));
		
		
		return dataset;
	}
	
	private void cargarRegistroInformeRecepcion(IDataSet dataset,
				 InformeRecepcion informeRecepcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_inf_rec", informeRecepcion.getOIDInteger());
		dataset.fieldValue("oid_talonario", informeRecepcion.getTalonario().getOIDInteger());
		dataset.fieldValue("oid_tc",informeRecepcion.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_tc",informeRecepcion.getTipoCompro().getCodigo());
		dataset.fieldValue("letra",informeRecepcion.getLetra());
		dataset.fieldValue("oid_lug_emi",informeRecepcion.getLugarEmision().getOIDInteger());
		dataset.fieldValue("lug_emi",informeRecepcion.getNroLugEmision());
		dataset.fieldValue("nro_ext",informeRecepcion.getNroExt());
		dataset.fieldValue("fec_emision", informeRecepcion.getImputac());
		dataset.fieldValue("oid_prov",informeRecepcion.getProveedor().getOIDInteger());
		dataset.fieldValue("cod_prov",informeRecepcion.getProveedor().getCodigo());
		dataset.fieldValue("rs_prov",informeRecepcion.getProveedor().getRazonsocial());
		dataset.fieldValue("activo",informeRecepcion.isActivo());
		dataset.fieldValue("remito_prov",informeRecepcion.getRemito_prov());
		dataset.fieldValue("comentario",informeRecepcion.getComentario());
		OrdenDeCompraCab oc = informeRecepcion.getOrdenDeCompra();
		if (oc!=null) {
		  dataset.fieldValue("oid_oc", oc.getOIDInteger());
		  dataset.fieldValue("codigo_oc", oc.getNroExt());
		} else {
		  dataset.fieldValue("oid_oc", new Integer(0));
		  dataset.fieldValue("codigo_oc", "");
		}
		
	}
	

}
