package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.bm.ConfConsGenStock;
import com.srn.erp.stock.bm.ConfConsGenStockFil;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFilConsGenStock extends Operation {

	public TraerFilConsGenStock() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		ConfConsGenStock confConsGenStock = ConfConsGenStock.findByOid(mapaDatos.getInteger("oid_conf_cons_gen"), this.getSesion());
		
		IDataSet dsFiltroPorDesc = this.getDataSetFiltroPorDescripcion();
		IDataSet dsFiltroPorCodigo = this.getDataSetFiltroPorCodigo();
		
		Iterator iterConfStockFiltrosPorDesc = 
			confConsGenStock.getConfStockFiltrosPorDesc().iterator();
		while (iterConfStockFiltrosPorDesc.hasNext()) {
			ConfConsGenStockFil confConsGenStockFil = (ConfConsGenStockFil) iterConfStockFiltrosPorDesc.next();
			cargarRegistroFiltroPorDesc(dsFiltroPorDesc, 
					ClasificadorEntidad.NICKNAME, 
					confConsGenStockFil.getClasificador_entidad().getNroClasif(),
					confConsGenStockFil.getClasificador_entidad().getOIDInteger(),
					confConsGenStockFil.getClasificador_entidad().getDescripcion(),
					confConsGenStockFil.getOrdenPorDesc(),
					confConsGenStockFil.getClasificador_entidad().getNickname());
			
		}
		
		if (confConsGenStock.isFiltrarProdStockPorDesc())
			cargarRegistroFiltroPorDesc(dsFiltroPorDesc, 
					Producto.NICKNAME, 
					new Integer(0),
					new Integer(0),
					"Producto Stock",
					new Integer(0),
					"");
		
		Iterator iterConfStockFiltrosPorCod = 
			confConsGenStock.getConfStockFiltrosPorCodigo().iterator();
		while (iterConfStockFiltrosPorCod.hasNext()) {
			ConfConsGenStockFil confConsGenStockFil = (ConfConsGenStockFil) iterConfStockFiltrosPorCod.next();
			cargarRegistroFiltroPorCod(dsFiltroPorCodigo,
					ClasificadorEntidad.NICKNAME, 
					confConsGenStockFil.getClasificador_entidad().getNroClasif(),
					confConsGenStockFil.getClasificador_entidad().getOIDInteger(),
					confConsGenStockFil.getClasificador_entidad().getDescripcion(),
					confConsGenStockFil.getOrdenPorCodigo(),
					confConsGenStockFil.getClasificador_entidad().getNickname()
					);
		}
		
		if (confConsGenStock.isFiltrarProdStockPorCodigo())
			cargarRegistroFiltroPorCod(dsFiltroPorCodigo, 
					Producto.NICKNAME, 
					new Integer(0),
					new Integer(0),
					"Producto Stock",
					new Integer(0),
					"");
		
		
		
			
		
		writeCliente(dsFiltroPorDesc);
		writeCliente(dsFiltroPorCodigo);
		

	}

	private IDataSet getDataSetFiltroPorDescripcion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TBuscarPorDescripcion");
		dataset.fieldDef(new Field("tipo", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_clasif_ent", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nickname", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetFiltroPorCodigo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TBuscarPorCodigo");
		dataset.fieldDef(new Field("tipo", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_clasif_ent", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_valor", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_valor", Field.STRING, 255));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nickname", Field.STRING, 50));
		return dataset;
	}
	

	private void cargarRegistroFiltroPorDesc(
			IDataSet dataset, 
			String tipo,
			Integer nroClasifEnt,
			Integer oidClasifEnt, 
			String descClasif,
			Integer orden,
			String nickName)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("tipo", tipo);
		dataset.fieldValue("nro_clasif_ent", nroClasifEnt);
		dataset.fieldValue("oid_clasif_ent", oidClasifEnt);
		dataset.fieldValue("desc_clasif_ent", descClasif);
		dataset.fieldValue("descripcion", "");
		dataset.fieldValue("orden", orden);
		dataset.fieldValue("nickname", nickName);
	}
	
	private void cargarRegistroFiltroPorCod(
			IDataSet dataset, 
			String tipo,
			Integer nroClasifEnt,
			Integer oidClasifEnt, 
			String descClasif,
			Integer orden,
			String nickname)
	throws BaseException {
		dataset.append();
		dataset.fieldValue("tipo", tipo);
		dataset.fieldValue("nro_clasif_ent", nroClasifEnt);
		dataset.fieldValue("oid_clasif_ent", oidClasifEnt);
		dataset.fieldValue("desc_clasif_ent", descClasif);
		dataset.fieldValue("oid_valor", "");
		dataset.fieldValue("cod_valor", "");
		dataset.fieldValue("desc_valor", "");
		dataset.fieldValue("orden", orden);
		dataset.fieldValue("nickname", nickname);

	}
	
	
	

}
