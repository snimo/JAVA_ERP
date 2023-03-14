package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.bm.RequisicionDetAutorizacion;
import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.EtiquetaIdioma;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.LabelTranslator;
import com.srn.erp.general.bm.Sucursal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ImpresionRequi extends Operation {


	private LabelTranslator lt = null;
	
	public ImpresionRequi() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsRequi = getDataSetRequisicion();
		IDataSet dsRequiDet = getDataSetRequisicionDet();
		IDataSet dsLabels = getDataSetLabels();
		
		lt = new LabelTranslator(this.getSesion());
		lt.setNickName(RequisicionCab.NICKNAME);
		lt.setIdioma(Idioma.getIdiomaLocal(this.getSesion()));

		RequisicionCab requision = RequisicionCab.findByOid(mapaDatos.getInteger("oid_cco"), getSesion());
		lt.setIdioma(Idioma.getIdiomaLocal(this.getSesion()));

		cargarRegistroRequisicion(dsRequi, requision);
		
		Iterator iterRequisicionesDet = 
			requision.getRequisicionesDet().iterator();
		while (iterRequisicionesDet.hasNext()) {
			RequisicionDet requiDet = (RequisicionDet) iterRequisicionesDet.next();
			if (requiDet.isAnulada()) continue;
			cargarRegistroRequiDet(dsRequiDet, requiDet);
		}
		
		cargarEtiquetas(dsLabels);
		

		writeCliente(dsRequi);
		writeCliente(dsRequiDet);
		writeCliente(dsLabels);
	}
	
	private void cargarRegistroRequisicion(
			IDataSet dataset, 
			RequisicionCab requi) throws BaseException {
		
		dataset.append();
		dataset.fieldValue("oid_cco", requi.getOIDInteger());
		dataset.fieldValue("comprobante", requi.getCodigo());
		dataset.fieldValue("tc", requi.getTcExt());
		dataset.fieldValue("letra", requi.getLetra());
		dataset.fieldValue("lug_emi", requi.getNroLugEmision());
		dataset.fieldValue("nro_ext", requi.getNroExt());
		dataset.fieldValue("fecha", requi.getEmision());
		dataset.fieldValue("emitida_por", requi.getUsuario().getApellidoyNombre());
		dataset.fieldValue("sector", requi.getSectorCompra().getDescripcion());
		dataset.fieldValue("comentario", requi.getComentario());
		
		
		dataset.fieldValue("razon_social_empresa", Empresa.getEmpresa(getSesion()).getRazon_social());

		// Agregar Datos Sucursal
		Sucursal sucursal = Sucursal.getSucursal(getSesion());
		dataset.fieldValue("razon_social_sucursal", sucursal.getDescripcion());
		dataset.fieldValue("direccion_sucursal", sucursal.getCalle_y_nro());
		dataset.fieldValue("localidad_sucursal", sucursal.getLocalidad());
		if (sucursal.getProvincia() != null)
			dataset.fieldValue("provincia_sucursal", sucursal.getProvincia().getDescripcion());
		else
			dataset.fieldValue("provincia_sucursal", "");
		if (sucursal.getPais() != null)
			dataset.fieldValue("pais_sucursal", sucursal.getPais().getDescripcion());
		else
			dataset.fieldValue("pais_sucursal", "");
		dataset.fieldValue("telefonos_sucursal", sucursal.getTelefonos());

		dataset.fieldValue("oid_sucursal", sucursal.getOIDInteger());
		dataset.fieldValue("nro_ver_ext", requi.getComprobanteImpreso().getVersion_externa());
		dataset.fieldValue("path_logo", sucursal.getPathLogo());
		
		
	}

	private void cargarRegistroRequiDet(IDataSet dataset,
			RequisicionDet requiDet)
			throws BaseException {

			dataset.append();
			dataset.fieldValue("oid_cco_det", requiDet.getOIDInteger());
			dataset.fieldValue("oid_cco", requiDet.getRequisicion().getOIDInteger());
			dataset.fieldValue("nro", requiDet.getRenglon());
			dataset.fieldValue("cod_art", requiDet.getProducto().getCodigo());
			dataset.fieldValue("desc_art", requiDet.getProducto().getDescripcion());
			dataset.fieldValue("desc_adic", requiDet.getDesc_adic_sku());
			dataset.fieldValue("um", requiDet.getUnidad_medida_req().getCodigo());
			dataset.fieldValue("cantidad", requiDet.getCant_solicitada());
			dataset.fieldValue("fec_requerida", requiDet.getFec_requerida());
			dataset.fieldValue("solo_cotiz", requiDet.isSolo_cotizar());
			dataset.fieldValue("autorizado",RequisicionDetAutorizacion.getDescAutoriz(requiDet.getDecision_autoriz())); 
			dataset.fieldValue("referencia", requiDet.getReferencia());
			if (requiDet.getProveedor()!=null) {
				dataset.fieldValue("cod_proveedor", requiDet.getProveedor().getCodigo());
				dataset.fieldValue("rs_proveedor", requiDet.getProveedor().getRazonsocial());
			} else {
				dataset.fieldValue("cod_proveedor", "(Sin sugerencia)");
				dataset.fieldValue("rs_proveedor", "");				
			}
			
			if (requiDet.isSolo_cotizar())
				dataset.fieldValue("comprar_o_cotizar","Solamente Cotizar");
			else
				dataset.fieldValue("comprar_o_cotizar","Comprar los siguientes productos");
			if (requiDet.isAutorizado())
				dataset.fieldValue("esta_autorizado", "");
			else
				dataset.fieldValue("esta_autorizado", "(*)");
	}

	private IDataSet getDataSetRequisicion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRequiCab");
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("tc", Field.STRING, 10));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("emitida_por", Field.STRING, 255));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		dataset.fieldDef(new Field("sector", Field.STRING, 50));

		// Agregar datos Empresa
		dataset.fieldDef(new Field("razon_social_empresa", Field.STRING, 100));

		// Agregar Datos Sucursal
		dataset.fieldDef(new Field("razon_social_sucursal", Field.STRING, 100));
		dataset.fieldDef(new Field("direccion_sucursal", Field.STRING, 100));
		dataset.fieldDef(new Field("localidad_sucursal", Field.STRING, 100));
		dataset.fieldDef(new Field("provincia_sucursal", Field.STRING, 100));
		dataset.fieldDef(new Field("pais_sucursal", Field.STRING, 100));
		dataset.fieldDef(new Field("telefonos_sucursal", Field.STRING, 100));

		dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ver_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("path_logo", Field.STRING, 500));

		return dataset;
	}

	private IDataSet getDataSetRequisicionDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRequiDet");
		dataset.fieldDef(new Field("oid_cco_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_art", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_art", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_adic", Field.STRING, 5000));
		dataset.fieldDef(new Field("um", Field.STRING, 10));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fec_requerida", Field.DATE, 0));
		dataset.fieldDef(new Field("solo_cotiz", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("autorizado", Field.STRING, 20));
		dataset.fieldDef(new Field("referencia", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("comprar_o_cotizar", Field.STRING, 100));
		dataset.fieldDef(new Field("esta_autorizado", Field.STRING, 1));
		
		
		return dataset;
	}
	
	private IDataSet getDataSetLabels() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TLabels");
		dataset.fieldDef(new Field("etiqueta", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.MEMO, 0));		
		return dataset;
	}
	
	private void cargarEtiqueta(IDataSet ds,String etiqueta,String descripcion) throws BaseException {
		ds.append();
		ds.fieldValue("etiqueta",etiqueta);
		ds.fieldValue("descripcion",descripcion);
	}
	
	private void cargarEtiquetas(IDataSet ds) throws BaseException {
		Iterator iterEtiquetas = 
			EtiquetaIdioma.getEtiquetasComprobante(
					RequisicionCab.NICKNAME,this.getSesion()).iterator();
		while (iterEtiquetas.hasNext()) {
			EtiquetaIdioma etiquetaIdioma = (EtiquetaIdioma) iterEtiquetas.next();
			String descripcion = lt.getEtiqueta(etiquetaIdioma.getEtiqueta());
			cargarEtiqueta(ds,etiquetaIdioma.getEtiqueta(),descripcion);
		}
	}
	

}
