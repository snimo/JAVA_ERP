package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizDetPorProv;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.bm.SolicitudCotizProveedor;
import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.EtiquetaIdioma;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.LabelTranslator;
import com.srn.erp.general.bm.Sucursal;

import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ImpresionSolCotizProv extends Operation {
	
	private LabelTranslator lt = null;
	int secu = 0;
	private Idioma idioma = null;
	
	
	public ImpresionSolCotizProv() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		idioma = Idioma.getIdiomaLocal(this.getSesion());
		
		impresionEstandar(mapaDatos);			
	
	}
	
	public void impresionEstandar(MapDatos mapaDatos) throws BaseException {

		IDataSet dsSolCotizCab = getDataSetSolCotizCab();
		IDataSet dsSolCotizDet = getDataSetCotizacionDet();
		IDataSet dsLabels = getDataSetLabels();

		
		lt = new LabelTranslator(this.getSesion());
		lt.setNickName(SolicitudCotizProvCab.NICKNAME);
		lt.setIdioma(idioma);				
		
		SolicitudCotizProvCab solCotizProvCab = SolicitudCotizProvCab.findByOid(mapaDatos.getInteger("oid_cco"), getSesion());
		Proveedor proveedor = Proveedor.findByOid(mapaDatos.getInteger("oid_proveedor"), getSesion());
		
		if ((proveedor!=null) && (proveedor.getIdioma()!=null))
			lt.setIdioma(proveedor.getIdioma());

		cargarSolCotizProvCab(dsSolCotizCab,solCotizProvCab,proveedor);
		
		SolicitudCotizProveedor solCotizProv = 
			SolicitudCotizProveedor.getSolicitudCotizProveedor(solCotizProvCab,proveedor,this.getSesion());
			
		Iterator iterSolCotizDetProv = 
			solCotizProv.getSolicitudesCotizDetPorProveedores().iterator();
		while (iterSolCotizDetProv.hasNext()) {
			SolicitudCotizDetPorProv solCotizDetPorProv = (SolicitudCotizDetPorProv) iterSolCotizDetProv.next();
			cargarRegistroSolCotizDet(dsSolCotizDet, solCotizDetPorProv);
			
			
		}
			
		
		cargarEtiquetas(dsLabels);

		writeCliente(dsSolCotizCab);
		writeCliente(dsSolCotizDet);
		writeCliente(dsLabels);
	}
	
	private IDataSet getDataSetSolCotizCab() {
			IDataSet dataset = new TDataSet();
			dataset.create("TSolCotizCab");
			
			// Datos de la empresa
			dataset.fieldDef(new Field("empresa_oid", Field.INTEGER, 0));
			dataset.fieldDef(new Field("empresa_codigo", Field.STRING, 100));
			dataset.fieldDef(new Field("empresa_razon_social", Field.STRING, 100));
			dataset.fieldDef(new Field("empresa_direccion", Field.STRING, 100));
			dataset.fieldDef(new Field("empresa_localidad", Field.STRING, 100));
			dataset.fieldDef(new Field("empresa_cp", Field.STRING, 100));
			dataset.fieldDef(new Field("empresa_oid_provincia", Field.INTEGER, 0));
			dataset.fieldDef(new Field("empresa_cod_provincia", Field.STRING, 50));
			dataset.fieldDef(new Field("empresa_desc_provincia", Field.STRING, 100));
			dataset.fieldDef(new Field("empresa_oid_pais", Field.INTEGER, 0));
			dataset.fieldDef(new Field("empresa_cod_pais", Field.STRING, 50));
			dataset.fieldDef(new Field("empresa_desc_pais", Field.STRING, 100));
			
			// Datos de la Sucursal
			dataset.fieldDef(new Field("sucursal_oid", Field.INTEGER, 0));
			dataset.fieldDef(new Field("sucursal_codigo", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_razon_social", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_direccion", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_localidad", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_cp", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_oid_provincia", Field.INTEGER, 0));
			dataset.fieldDef(new Field("sucursal_cod_provincia", Field.STRING, 50));
			dataset.fieldDef(new Field("sucursal_desc_provincia", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_oid_pais", Field.INTEGER, 0));
			dataset.fieldDef(new Field("sucursal_cod_pais", Field.STRING, 50));
			dataset.fieldDef(new Field("sucursal_desc_pais", Field.STRING, 100));
								
			// Datos de la Sucursal
			
			dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
			dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_tc", Field.STRING, 20));
			dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
			dataset.fieldDef(new Field("rz_proveedor", Field.STRING, 255));
			dataset.fieldDef(new Field("letra", Field.STRING, 1));
			dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
			dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
			dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
			dataset.fieldDef(new Field("path_logo_sucursal", Field.STRING, 255));

			dataset.fieldDef(new Field("comentario",  Field.MEMO, 0));
			dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
			dataset.fieldDef(new Field("fec_ent_sol", Field.DATE, 0));
			dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
			dataset.fieldDef(new Field("leyenda_anulado", Field.STRING, 255));
			
			
			return dataset;
	}
	
	private IDataSet getDataSetCotizacionDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSolCotizDet");
		dataset.fieldDef(new Field("oid_cotiz_det_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_sol_cotiz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_art", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_art", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_art", Field.STRING, 255));
		dataset.fieldDef(new Field("desc_adic", Field.MEMO, 0));
		dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um", Field.STRING, 50));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fec_entrega", Field.DATE, 0));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		
		return dataset;
	}
	
	private void enviarDatosEmpresa(IDataSet dataset) throws BaseException {
	
		
		Empresa empresa = Empresa.findByOidProxy(this.getSesion().getLogin().getOidEmpresa(),this.getSesion());
		
		
		dataset.fieldValue("empresa_oid", empresa.getOIDInteger());
		dataset.fieldValue("empresa_codigo", empresa.getCodigo());
		dataset.fieldValue("empresa_razon_social", empresa.getRazon_social());
		dataset.fieldValue("empresa_direccion", empresa.getCalle_y_nro());
		dataset.fieldValue("empresa_localidad", empresa.getLocalidad());
		dataset.fieldValue("empresa_cp", empresa.getCodigo_postal());
		
		if (empresa.getProvincia()!=null) {
			dataset.fieldValue("empresa_oid_provincia", empresa.getProvincia().getOIDInteger());
			dataset.fieldValue("empresa_cod_provincia", empresa.getProvincia().getCodigo());
			dataset.fieldValue("empresa_desc_provincia", empresa.getProvincia().getDescripcion());
		} else {
			dataset.fieldValue("empresa_oid_provincia", 0);
			dataset.fieldValue("empresa_cod_provincia", "");
			dataset.fieldValue("empresa_desc_provincia", "");
		}
		
		if (empresa.getPais()!=null) {
			dataset.fieldValue("empresa_oid_pais", empresa.getPais().getOIDInteger());
			dataset.fieldValue("empresa_cod_pais", empresa.getPais().getCodigo());
			dataset.fieldValue("empresa_desc_pais", empresa.getPais().getDescripcion());
		} else {
			dataset.fieldValue("empresa_oid_pais", 0);
			dataset.fieldValue("empresa_cod_pais", "");
			dataset.fieldValue("empresa_desc_pais", "");
		}
		
	}
	
	private void enviarDatosSucursal(IDataSet dataset) throws BaseException {

		Sucursal sucursal = Sucursal.findByOidProxy(this.getSesion().getLogin().getOidSucursal(),this.getSesion());
		
		
		dataset.fieldValue("sucursal_oid", sucursal.getOIDInteger());
		dataset.fieldValue("sucursal_codigo", sucursal.getCodigo());
		dataset.fieldValue("sucursal_razon_social", sucursal.getDescripcion());
		dataset.fieldValue("sucursal_direccion", sucursal.getCalle_y_nro());
		dataset.fieldValue("sucursal_localidad", sucursal.getLocalidad());
		dataset.fieldValue("sucursal_cp", sucursal.getCodigo_postal());
		
		if (sucursal.getProvincia()!=null) {
			dataset.fieldValue("sucursal_oid_provincia", sucursal.getProvincia().getOIDInteger());
			dataset.fieldValue("sucursal_cod_provincia", sucursal.getProvincia().getCodigo());
			dataset.fieldValue("sucursal_desc_provincia", sucursal.getProvincia().getDescripcion());
		} else {
			dataset.fieldValue("sucursal_oid_provincia", 0);
			dataset.fieldValue("sucursal_cod_provincia", "");
			dataset.fieldValue("sucursal_desc_provincia", "");
		}
		
		if (sucursal.getPais()!=null) {
			dataset.fieldValue("sucursal_oid_pais", sucursal.getPais().getOIDInteger());
			dataset.fieldValue("sucursal_cod_pais", sucursal.getPais().getCodigo());
			dataset.fieldValue("sucursal_desc_pais", sucursal.getPais().getDescripcion());
		} else {
			dataset.fieldValue("sucursal_oid_pais", 0);
			dataset.fieldValue("sucursal_cod_pais", "");
			dataset.fieldValue("sucursal_desc_pais", "");
		}

	}
	
	
	private void cargarSolCotizProvCab(IDataSet dataset,
			                           SolicitudCotizProvCab solCotizProvCab,
			                           Proveedor proveedor) throws BaseException {
		dataset.append();
		
		
		Iterator iterSolCotizProv = 
			solCotizProvCab.getCotizacionesProveedores().iterator();
		while (iterSolCotizProv.hasNext()) {
			SolicitudCotizProveedor solCotizProv = (SolicitudCotizProveedor) iterSolCotizProv.next();
			
			if (solCotizProv.getProveedor().getOID()!=proveedor.getOID()) continue;

			enviarDatosEmpresa(dataset);
			enviarDatosSucursal(dataset);
			
			dataset.fieldValue("oid_cco", solCotizProvCab.getOIDInteger());
			dataset.fieldValue("oid_talonario",solCotizProvCab.getTalonario().getOIDInteger());
			dataset.fieldValue("cod_tc",solCotizProvCab.getTcExt());
			dataset.fieldValue("oid_tc", solCotizProvCab.getTipoCompro().getOIDInteger());
			dataset.fieldValue("cod_proveedor", solCotizProv.getProveedor().getCodigo());
			dataset.fieldValue("rz_proveedor", solCotizProv.getProveedor().getRazonsocial());
			dataset.fieldValue("letra", solCotizProvCab.getLetra());
			dataset.fieldValue("lug_emi", solCotizProvCab.getLugarEmision().getLugemi());
			dataset.fieldValue("nro_ext", solCotizProvCab.getNroExt());
			dataset.fieldValue("oid_proveedor", solCotizProv.getProveedor().getOIDInteger());
			dataset.fieldValue("path_logo_sucursal", solCotizProvCab.getSucursal().getPathLogo());

			dataset.fieldValue("comentario",  solCotizProvCab.getObs_detalladas());
			dataset.fieldValue("fec_emision", solCotizProvCab.getEmision());
			dataset.fieldValue("fec_ent_sol", solCotizProvCab.getFec_tope_ent_sol());
			dataset.fieldValue("activo", solCotizProvCab.isActivo());
			
			if (solCotizProvCab.isActivo().booleanValue() == false)
				  dataset.fieldValue("leyenda_anulado" , "ANULADO");
				else
				  dataset.fieldValue("leyenda_anulado" , "");
			
			
		}
		
		
		
	}
	
	private void cargarRegistroSolCotizDet(IDataSet dataset,
										   SolicitudCotizDetPorProv solCotizDetPorProv) throws BaseException {
		
		
		if (!solCotizDetPorProv.isCotizar()) return;
		
		if (solCotizDetPorProv.getSolicitud_cotiz_det().isAnulado()) return;
		
		
		dataset.append();
		dataset.fieldValue("oid_cotiz_det_prov", solCotizDetPorProv.getOIDInteger());
		dataset.fieldValue("nro_renglon", ++secu);
		dataset.fieldValue("oid_cco_sol_cotiz", solCotizDetPorProv.getSolicitudCotizacion().getOIDInteger());
		dataset.fieldValue("oid_art", solCotizDetPorProv.getSolicitud_cotiz_det().getProducto().getOIDInteger());
		dataset.fieldValue("cod_art", solCotizDetPorProv.getSolicitud_cotiz_det().getProducto().getCodigo());
		dataset.fieldValue("desc_art", solCotizDetPorProv.getSolicitud_cotiz_det().getProducto().getDescripcion());
		
		StringBuffer descAdicional = new StringBuffer("");
		if (solCotizDetPorProv.getSolicitud_cotiz_det().getObs_sol_cotiz()!=null)
			descAdicional.append(solCotizDetPorProv.getSolicitud_cotiz_det().getObs_sol_cotiz()+Util.ENTER());
		
		if (solCotizDetPorProv.getObs_art_prov()!=null) 
			descAdicional.append(solCotizDetPorProv.getObs_art_prov());
			
		dataset.fieldValue("desc_adic", descAdicional.toString());
		dataset.fieldValue("oid_um", solCotizDetPorProv.getOid_um_cpra().getOIDInteger());
		dataset.fieldValue("cod_um", solCotizDetPorProv.getOid_um_cpra().getCodigo());
		dataset.fieldValue("cantidad", solCotizDetPorProv.getCant_a_cotizar());
		
		dataset.fieldValue("fec_entrega", solCotizDetPorProv.getSolicitud_cotiz_det().getFec_entrega());
		dataset.fieldValue("comentario", solCotizDetPorProv.getSolicitud_cotiz_det().getObs_sol_cotiz());
		
		
	}
	
	private void cargarEtiquetas(IDataSet ds) throws BaseException {
		Iterator iterEtiquetas = 
			EtiquetaIdioma.getEtiquetasComprobante(
					SolicitudCotizProvCab.NICKNAME,this.getSesion()).iterator();
		while (iterEtiquetas.hasNext()) {
			EtiquetaIdioma etiquetaIdioma = (EtiquetaIdioma) iterEtiquetas.next();
			String descripcion = lt.getEtiqueta(etiquetaIdioma.getEtiqueta());
			cargarEtiqueta(ds,etiquetaIdioma.getEtiqueta(),descripcion);
		}
	}
	
	
	private void cargarEtiqueta(IDataSet ds,String etiqueta,String descripcion) throws BaseException {
		ds.append();
		ds.fieldValue("etiqueta",etiqueta);
		ds.fieldValue("descripcion",descripcion);
	}
	
	private IDataSet getDataSetLabels() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TLabels");
		dataset.fieldDef(new Field("etiqueta", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.MEMO, 0));		
		return dataset;
	}
	

}
	