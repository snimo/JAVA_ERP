package com.srn.erp.ventas.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PrecioPorEstrucLP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ImpresionListaPreciosVta extends Operation {

	ClasificadorEntidad clasifEnt = null;
	ClasificadorEntidad clasifFiltro = null;
	List valoresClasifFiltro = new ArrayList();
	
	public ImpresionListaPreciosVta() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsLPCab = this.getDataSetLPCab();
		IDataSet dsLPDet = this.getDataSetLPDet(); 

		Integer oidLP = mapaDatos.getInteger("oid_lp");
		ListaPrecios lp = ListaPrecios.findByOid(oidLP, this.getSesion());
		
		if (lp == null) throw new ExceptionValidation(null,"Debe ingresar la lista de precios");
		
		if (mapaDatos.containsKey("oid_clasificador"))
			clasifEnt = ClasificadorEntidad.findByOid(mapaDatos.getInteger("oid_clasificador"), this.getSesion());
		
		if (mapaDatos.containsKey("oid_clasif_filtro")) {
			clasifFiltro = ClasificadorEntidad.findByOid(mapaDatos.getInteger("oid_clasif_filtro"), this.getSesion());
			IDataSet dsValClasifFil = mapaDatos.getDataSet("TValoresClasificador");
			dsValClasifFil.first();
			while (!dsValClasifFil.EOF()) {
				if (dsValClasifFil.getBoolean("sel")) {
					ValorClasificadorEntidad valClasif =
						ValorClasificadorEntidad.findByOidProxy(dsValClasifFil.getInteger("oid_valor_clasif"), this.getSesion()); 
						valoresClasifFiltro.add(valClasif);
				}
				dsValClasifFil.next();
			}
			
		}
		
		cargarListaCab(dsLPCab,lp);
		Iterator iterPreciosClasifArt = 
			lp.getPreciosClasifArtPorLP(valoresClasifFiltro).iterator();
		while (iterPreciosClasifArt.hasNext()) {
			PrecioPorEstrucLP precioPorEstruc = (PrecioPorEstrucLP) iterPreciosClasifArt.next();
			if (!precioPorEstruc.getValorClasifProdGral().isActivo()) continue;
			cargarListaDet(dsLPDet, lp, precioPorEstruc, clasifEnt);
		}
		
		writeCliente(dsLPCab);
		writeCliente(dsLPDet);
		
	}


	private IDataSet getDataSetLPCab() {
			IDataSet dataset = new TDataSet();
			dataset.create("TListaPreciosCab");
			
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
			dataset.fieldDef(new Field("sucursal_telefonos", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_oid_provincia", Field.INTEGER, 0));
			dataset.fieldDef(new Field("sucursal_cod_provincia", Field.STRING, 50));
			dataset.fieldDef(new Field("sucursal_desc_provincia", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_oid_pais", Field.INTEGER, 0));
			dataset.fieldDef(new Field("sucursal_cod_pais", Field.STRING, 50));
			dataset.fieldDef(new Field("sucursal_desc_pais", Field.STRING, 100));
			dataset.fieldDef(new Field("path_logo_sucursal", Field.STRING, 100));
			
			
			
			// Datos de la empresa
			dataset.fieldDef(new Field("oid_lp", Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_lp", Field.STRING, 50));
			dataset.fieldDef(new Field("desc_lp", Field.STRING, 100));
			dataset.fieldDef(new Field("fec_vig_desde", Field.DATE, 0));
			dataset.fieldDef(new Field("fec_vig_hasta", Field.DATE, 0));
			dataset.fieldDef(new Field("leyenda_iva", Field.STRING, 100));
			return dataset;
	}
	
	private IDataSet getDataSetLPDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TListaPreciosDet");
		dataset.fieldDef(new Field("oid_lp_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("titulo", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_prod_gral", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prod_gral", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_prod_gral", Field.STRING, 255));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("um", Field.STRING, 20));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("moneda", Field.STRING, 20));
		return dataset;
	}
	
	
	private void cargarListaCab(IDataSet ds, ListaPrecios listaPrecios) throws BaseException {
		ds.append();
		
		enviarDatosEmpresa(ds);
		enviarDatosSucursal(ds);
		
		ds.fieldValue("oid_lp", listaPrecios.getOIDInteger());
		ds.fieldValue("cod_lp", listaPrecios.getCodigo());
		ds.fieldValue("desc_lp", listaPrecios.getDescripcion());
		ds.fieldValue("fec_vig_desde", listaPrecios.getFec_vig_desde());
		ds.fieldValue("fec_vig_hasta", listaPrecios.getFec_vig_hasta());
		if (listaPrecios.isIncluyeIVA())
			ds.fieldValue("leyenda_iva", "(LOS PRECIOS INDICADOS INCLUYEN IVA)");
		else
			ds.fieldValue("leyenda_iva", "(LOS PRECIOS INDICADOS NO INCLUYEN IVA)");
	}
	
	private void cargarListaDet(IDataSet ds, 
			ListaPrecios listaPrecios,
			PrecioPorEstrucLP precioDet,
			ClasificadorEntidad clasifEntTitulos) throws BaseException {
		ds.append();
		ds.fieldValue("oid_lp_det", precioDet.getOIDInteger());
		ds.fieldValue("oid_lp", listaPrecios.getOIDInteger());
		
		ValorClasifEntProdGen valorClasifProdGen =
			precioDet.getValorClasifProdGral();
		IValorClasificadorEntidad valorClasif =
			valorClasifProdGen.getValorClasifEnt(clasifEntTitulos);
		if (valorClasif!=null)
			ds.fieldValue("titulo", valorClasif.getDescripcion());
		else
			ds.fieldValue("titulo", "");
		ds.fieldValue("oid_prod_gral", valorClasifProdGen.getOIDInteger());
		ds.fieldValue("cod_prod_gral", valorClasifProdGen.getCodigo());
		ds.fieldValue("desc_prod_gral", valorClasifProdGen.getDescripcion());
		ds.fieldValue("cantidad", precioDet.getCantidad());
		ds.fieldValue("um", precioDet.getUnidad_medida().getLabelImpresion());
		ds.fieldValue("precio", precioDet.getPrecio());
		ds.fieldValue("moneda", precioDet.getMoneda().getSimbolo());
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
		dataset.fieldValue("sucursal_telefonos", sucursal.getTelefonos());
		
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
		
		dataset.fieldValue("path_logo_sucursal", sucursal.getPathLogo());
		
		

	}
	
	
	

}
	