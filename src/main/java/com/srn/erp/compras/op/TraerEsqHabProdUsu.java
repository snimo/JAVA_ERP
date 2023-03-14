package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.EsqHabProdUsu;
import com.srn.erp.compras.bm.EsquemaHabilitacionProducto;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEsqHabProdUsu extends Operation {

	public TraerEsqHabProdUsu() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		EsquemaHabilitacionProducto esqHabProd = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			esqHabProd = EsquemaHabilitacionProducto
					.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			esqHabProd = EsquemaHabilitacionProducto.findByCodigo(codigo,
					getSesion());
		}

		IDataSet dsEsqHabProd = this.getDataSetEsquema();
		IDataSet dsProdHabUsu = this.getDataSetUsuariosHab();
		IDataSet dsValorClasif = getDataSetValorClasif();

		if (esqHabProd != null) {
			this.cargarEsquema(dsEsqHabProd, esqHabProd);
			Iterator iterDetalles = esqHabProd.getDetalles().iterator();
			while (iterDetalles.hasNext()) {
				EsqHabProdUsu esqHabProdUsu = (EsqHabProdUsu) iterDetalles
						.next();
				cargarRegistroUsuHab(dsProdHabUsu, esqHabProdUsu);
			}
			
			
	        Iterator iterValoresClasif = null;
	        if (esqHabProd.getClasificador()!=null) {
	        	iterValoresClasif = esqHabProd.getClasificador().getValoresClasificador(null,null).iterator();
	        	while (iterValoresClasif.hasNext()) {
	        		ValorClasificadorEntidad valorClasificadorEntidad =
	        			(ValorClasificadorEntidad) iterValoresClasif.next();
	        		cargarValorClasif(dsValorClasif,valorClasificadorEntidad);
	        	}
	        }
			

		}

		writeCliente(dsEsqHabProd);
		writeCliente(dsProdHabUsu);
		writeCliente(dsValorClasif);

	}

	private IDataSet getDataSetEsquema() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEsquemaHabProd");
		dataset.fieldDef(new Field("oid_esq_hab_prod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("ambito_esquema", Field.BOOLEAN, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarEsquema(IDataSet dataset,
			EsquemaHabilitacionProducto esqHabProd) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_esq_hab_prod", esqHabProd.getOIDInteger());
		dataset.fieldValue("codigo", esqHabProd.getCodigo());
		dataset.fieldValue("descripcion", esqHabProd.getDescripcion());
		dataset.fieldValue("ambito_esquema", esqHabProd.getAmbito_esquema());
		dataset.fieldValue("activo", esqHabProd.isActivo());
		dataset.fieldValue("oid_clasif_ent", esqHabProd.getClasificador()
				.getOIDInteger());
	}

	private IDataSet getDataSetUsuariosHab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEsquemaHabProdUsu");
		dataset.fieldDef(new Field("oid_esq_hab_usu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_esq_hab_prod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_usuario", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_usuario", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroUsuHab(IDataSet dataset,
			EsqHabProdUsu esqHabProdUsu) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_esq_hab_usu", esqHabProdUsu.getOIDInteger());
		dataset.fieldValue("oid_esq_hab_prod", esqHabProdUsu
				.getEsquema_habilitacion().getOIDInteger());
		dataset.fieldValue("oid_val_clasif_ent", esqHabProdUsu
				.getValor_clasificador().getOIDInteger());
		dataset.fieldValue("oid_usuario", esqHabProdUsu.getUsuario()
				.getOIDInteger());
		dataset.fieldValue("cod_usuario", esqHabProdUsu.getUsuario()
				.getCodigo());
		dataset.fieldValue("desc_usuario", esqHabProdUsu.getUsuario()
				.getApellidoyNombre());
		dataset.fieldValue("activo", new Boolean(true));
	}

	private IDataSet getDataSetValorClasif() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValorClasificador");
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_item", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 30));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_item_padre", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 30));
		dataset.fieldDef(new Field("codigo_desde", Field.STRING, 50));
		dataset.fieldDef(new Field("codigo_hasta", Field.STRING, 50));
		return dataset;
	}

	private void cargarValorClasif(IDataSet dataset,
			ValorClasificadorEntidad valorClasifEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_val_clasif_ent", valorClasifEnt.getOIDInteger());
		dataset.fieldValue("oid_clasif_ent", valorClasifEnt.getClasificador_entidad().getOIDInteger());
		dataset.fieldValue("oid_item", valorClasifEnt.getOid_item());
		dataset.fieldValue("codigo", valorClasifEnt.getCodigo());
		dataset.fieldValue("descripcion", valorClasifEnt.getDescripcion());
		dataset.fieldValue("oid_item_padre", valorClasifEnt.getOid_item_padre());
		dataset.fieldValue("activo", valorClasifEnt.isActivo());
		dataset.fieldValue("orden", valorClasifEnt.getOrden());
		dataset.fieldValue("tipo", valorClasifEnt.getTipo());
		dataset.fieldValue("codigo_desde", valorClasifEnt.getCodigoDesde());
		dataset.fieldValue("codigo_hasta", valorClasifEnt.getCodigoHasta());
	}

}
