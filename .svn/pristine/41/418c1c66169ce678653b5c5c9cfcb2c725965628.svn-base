package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.PrecioCompraPorClasifArt;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAcuerdoLPProdGral extends Operation {

	HashTableDatos preciosCompraClasif = new HashTableDatos();
	ClasificadorEntidad clasifAgrupProductos = null;
	String descripcion , codigo;
	HashTableDatos listaValClasif = new HashTableDatos();
	

	public TraerAcuerdoLPProdGral() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		AcuerdoLP acuerdolp = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			acuerdolp = AcuerdoLP.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			acuerdolp = AcuerdoLP.findByCodigo(codigo, getSesion());
		}

		if (mapaDatos.containsKey("oid_clasif_ent_agrup"))
			clasifAgrupProductos = ClasificadorEntidad.findByOid(mapaDatos.getInteger("oid_clasif_ent_agrup"), this.getSesion());
		
		if (mapaDatos.containsKey("descripcion"))
			descripcion = mapaDatos.getString("descripcion");
		
		if (mapaDatos.containsKey("codigo"))
			codigo = mapaDatos.getString("codigo");		
		
		if (mapaDatos.containsKey("TClasificadorEntidad")) {
			IDataSet dsValClasif = mapaDatos.getDataSet("TClasificadorEntidad");
			dsValClasif.first();
			while (!dsValClasif.EOF()) {
				
				Integer oidClasifEnt = dsValClasif.getInteger("oid_clasif_ent");
				ClasificadorEntidad clasifEntidad = ClasificadorEntidad.findByOidProxy(oidClasifEnt,this.getSesion());
				
				if ((dsValClasif.getInteger("oid_valor_clasif")!=null) && 
						(dsValClasif.getInteger("oid_valor_clasif").intValue()>0)) {
					ValorClasificadorEntidad valorClasifEnt = 
						ValorClasificadorEntidad.findByOidProxy(dsValClasif.getInteger("oid_valor_clasif"),this.getSesion());
					listaValClasif.put(clasifEntidad, valorClasifEnt);
				}		
				
				dsValClasif.next();
			}
		}
		
		
		IDataSet datasetAcuerdoLP = getDataSetAcuerdoLP();
		IDataSet datasetAcuerdoLPProductos = this.getDataSetProductosDet();

		if (acuerdolp != null) {
			
			cargarRegistroAcuerdoLP(datasetAcuerdoLP,acuerdolp);
			
			java.util.Date fecha = Fecha.getFechaActual();
			if (mapaDatos.containsKey("fecha"))
				fecha = mapaDatos.getDate("fecha"); 
			
			Iterator iterPreciosCompras =
				acuerdolp.getPreciosVigentesAFecha(fecha,descripcion,codigo,null,listaValClasif).iterator();
			
			while (iterPreciosCompras.hasNext()) {
				PrecioCompraPorClasifArt preciosCompra = 
					(PrecioCompraPorClasifArt) iterPreciosCompras.next();
				PrecioCompraPorClasifArt proxPrecioCompra = 
					acuerdolp.getProximoPrecioCompraPostAFecha(preciosCompra.getValor_clasif_art(), fecha);
				
				cargarRegistroAcuerdoLPDetalle(datasetAcuerdoLPProductos, preciosCompra, proxPrecioCompra);
			}
			
		}

		writeCliente(datasetAcuerdoLP);
		writeCliente(datasetAcuerdoLPProductos);
	}

	private IDataSet getDataSetAcuerdoLP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAcuerdoLP");
		dataset.fieldDef(new Field("oid_acuerdo_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_acuerdo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 30));
		dataset.fieldDef(new Field("desc_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistroAcuerdoLP(IDataSet dataset,
			AcuerdoLP acuerdoLP)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_acuerdo_lp", acuerdoLP.getOIDInteger());
		dataset.fieldValue("oid_tipo_acuerdo", acuerdoLP.getTipo_acuerdo().getOIDInteger());
		dataset.fieldValue("oid_proveedor", acuerdoLP.getProveedor().getOIDInteger());
		dataset.fieldValue("cod_proveedor", acuerdoLP.getProveedor().getCodigo());
		dataset.fieldValue("desc_proveedor", acuerdoLP.getProveedor().getRazonsocial());
		dataset.fieldValue("activo", acuerdoLP.isActivo());
		dataset.fieldValue("descripcion", acuerdoLP.getDescripcion());
	}


	private IDataSet getDataSetProductosDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetProductos");
		dataset.fieldDef(new Field("oid_det_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_acuerdo_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("titulo", Field.STRING, 100));
		dataset.fieldDef(new Field("actual_fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("actual_cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("actual_oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("actual_oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("actual_precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nueva_fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("nueva_cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nueva_oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nueva_oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nueva_precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nueva_activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("actual_activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nueva_oid_precio_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("actual_oid_precio_clasif", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroAcuerdoLPDetalle(IDataSet dataset,
			PrecioCompraPorClasifArt actual,
			PrecioCompraPorClasifArt nuevo) throws BaseException {
		dataset.append();
		if (actual!=null) {
			dataset.fieldValue("oid_det_producto", actual.getOIDInteger());
			dataset.fieldValue("oid_producto",actual.getValor_clasif_art().getOIDInteger());
			dataset.fieldValue("cod_producto",actual.getValor_clasif_art().getCodigo());
			dataset.fieldValue("desc_producto",actual.getValor_clasif_art().getDescripcion());
			dataset.fieldValue("oid_acuerdo_lp",actual.getAcuerdo_lp().getOIDInteger());
			dataset.fieldValue("activo",new Boolean(true));
		}
		else {
			dataset.fieldValue("oid_det_producto", nuevo.getOIDInteger());
			dataset.fieldValue("oid_producto",nuevo.getValor_clasif_art().getOIDInteger());
			dataset.fieldValue("cod_producto",nuevo.getValor_clasif_art().getCodigo());
			dataset.fieldValue("desc_producto",nuevo.getValor_clasif_art().getDescripcion());
			dataset.fieldValue("oid_acuerdo_lp",nuevo.getAcuerdo_lp().getOIDInteger());
			dataset.fieldValue("activo",new Boolean(true));
		}
		
		
		if (clasifAgrupProductos==null)
			dataset.fieldValue("titulo","");
		else {
			if (actual!=null) {
				IValorClasificadorEntidad valorClasif = null;
				if ((actual.getValor_clasif_art()!=null) &&
					(actual.getValor_clasif_art().getExtensionProdGen()!=null)) {
					valorClasif = actual.getValor_clasif_art().getExtensionProdGen().getValorClasifEnt(this.clasifAgrupProductos);
					if (valorClasif!=null)
						dataset.fieldValue("titulo",valorClasif.getDescripcion());
					else
						dataset.fieldValue("titulo","");
					}
				else
					dataset.fieldValue("titulo","");
			}
			else
				dataset.fieldValue("titulo","");
		}
		
		if (actual!=null) {
			dataset.fieldValue("actual_fecha",actual.getFechaVigencia());
			dataset.fieldValue("actual_cantidad", actual.getCantidad());
			dataset.fieldValue("actual_oid_um", actual.getUnidad_medida().getOIDInteger());
			dataset.fieldValue("actual_oid_moneda", actual.getMoneda().getOIDInteger());
			dataset.fieldValue("actual_precio", actual.getPrecio());
		} else {
			dataset.fieldValue("actual_fecha",Fecha.FECHA_NULA());
			dataset.fieldValue("actual_cantidad", 0);
			dataset.fieldValue("actual_oid_um", 0);
			dataset.fieldValue("actual_oid_moneda", 0);
			dataset.fieldValue("actual_precio", 0);
		}
		
		if (nuevo!=null) {
			dataset.fieldValue("nueva_fecha", nuevo.getFechaVigencia()); 
			dataset.fieldValue("nueva_cantidad", nuevo.getCantidad());
			dataset.fieldValue("nueva_oid_um", nuevo.getUnidad_medida().getOIDInteger());
			dataset.fieldValue("nueva_oid_moneda", nuevo.getMoneda().getOIDInteger());
			dataset.fieldValue("nueva_precio", nuevo.getPrecio());
		} else {
			dataset.fieldValue("nueva_fecha", Fecha.FECHA_NULA());
			
			if (actual!=null) {
				dataset.fieldValue("nueva_cantidad", actual.getCantidad());
				dataset.fieldValue("nueva_oid_um", actual.getUnidad_medida().getOIDInteger());
				dataset.fieldValue("nueva_oid_moneda", actual.getMoneda().getOIDInteger());
			} else {
				dataset.fieldValue("nueva_cantidad", 0);
				dataset.fieldValue("nueva_oid_um", 0);
				dataset.fieldValue("nueva_oid_moneda", 0);
			}
			dataset.fieldValue("nueva_precio", 0);
		}
		
		dataset.fieldValue("nueva_activo", true);
		dataset.fieldValue("actual_activo", true);
		if (nuevo!=null)
			dataset.fieldValue("nueva_oid_precio_clasif", nuevo.getOIDInteger());
		else
			dataset.fieldValue("nueva_oid_precio_clasif", 0);
		if (actual!=null)
			dataset.fieldValue("actual_oid_precio_clasif", actual.getOIDInteger());
		else
			dataset.fieldValue("actual_oid_precio_clasif", 0);

	}

}
