package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.ConfConsGenStock;
import com.srn.erp.stock.bm.ConfConsGenStockDepo;
import com.srn.erp.stock.bm.ConfConsGenStockEst;
import com.srn.erp.stock.bm.ConfConsGenStockFil;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConfConsGenStock extends Operation {

	public TraerConfConsGenStock() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		ConfConsGenStock confconsgenstock = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			confconsgenstock = ConfConsGenStock.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			confconsgenstock = ConfConsGenStock.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetConfConsGenStock = getDataSetConfConsGenStock();
		IDataSet datasetConfDepositos = getDataSetConfConsGenStockDepo();
		IDataSet datasetConfEstados = getDataSetConfConsGenStockEst();
		IDataSet datasetConfFiltros = getDataSetConfConsGenStockFil();

		if (confconsgenstock != null) {
			cargarRegistroConfConsGenStock(datasetConfConsGenStock, confconsgenstock);

			Iterator iterConfDepositos = confconsgenstock.getConfDepositos().iterator();
			while (iterConfDepositos.hasNext()) {
				ConfConsGenStockDepo confConsGenStockDepo = (ConfConsGenStockDepo) iterConfDepositos.next();
				if (!confConsGenStockDepo.isActivo())
					continue;
				cargarRegistroConfConsGenStockDepo(datasetConfDepositos, confConsGenStockDepo);

			}
			
			Iterator iterConfEstados = confconsgenstock.getConfEstados().iterator();
			while (iterConfEstados.hasNext()) {
				ConfConsGenStockEst confConsGenStockEst = (ConfConsGenStockEst) iterConfEstados.next();
				if (!confConsGenStockEst.isActivo())
					continue;
				cargarRegistroConfConsGenStockEst(datasetConfEstados, confConsGenStockEst);

			}
			
			Iterator iterConfFiltros = confconsgenstock.getConfFiltros().iterator();
			while (iterConfFiltros.hasNext()) {
				ConfConsGenStockFil confConsGenStockFil = (ConfConsGenStockFil) iterConfFiltros.next();
				if (!confConsGenStockFil.isActivo())
					continue;
				cargarRegistroConfConsGenStockFil(datasetConfFiltros, confConsGenStockFil);

			}
			

		}

		
		writeCliente(datasetConfConsGenStock);
		writeCliente(datasetConfDepositos);
		writeCliente(datasetConfEstados);
		writeCliente(datasetConfFiltros);
		

	}

	private IDataSet getDataSetConfConsGenStock() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConfConsGenStock");
		dataset.fieldDef(new Field("oid_conf_cons_stk", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("tipo_valor_fila", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_clasif_ent_agrup", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_clasif_ent_agrup", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_clasif_ent_agrup", Field.STRING, 255));
		dataset.fieldDef(new Field("totalizar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_clasif_ent_fila", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_clasif_ent_fila", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_clasif_ent_fila", Field.STRING, 255));
		dataset.fieldDef(new Field("fil_prod_stk_cod", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fil_prod_stk_des", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("consolidar_stock", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ver_col_tot_fila", Field.BOOLEAN, 0));
		

		return dataset;
	}

	private void cargarRegistroConfConsGenStock(IDataSet dataset, ConfConsGenStock confConsGenStock) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_conf_cons_stk", confConsGenStock.getOIDInteger());
		dataset.fieldValue("codigo", confConsGenStock.getCodigo());
		dataset.fieldValue("descripcion", confConsGenStock.getDescripcion());
		dataset.fieldValue("activo", confConsGenStock.isActivo());
		dataset.fieldValue("tipo_valor_fila", confConsGenStock.getTipo_valor_fila());
		if (confConsGenStock.getClasif_ent_grupo() != null) {
			dataset.fieldValue("oid_clasif_ent_agrup", confConsGenStock.getClasif_ent_grupo().getOIDInteger());
			dataset.fieldValue("cod_clasif_ent_agrup", confConsGenStock.getClasif_ent_grupo().getCodigo());
			dataset.fieldValue("desc_clasif_ent_agrup", confConsGenStock.getClasif_ent_grupo().getDescripcion());
		} else {
			dataset.fieldValue("oid_clasif_ent_agrup", "");
			dataset.fieldValue("cod_clasif_ent_agrup", "");
			dataset.fieldValue("desc_clasif_ent_agrup", "");
		}
		dataset.fieldValue("totalizar", confConsGenStock.isTotalizar());
		if (confConsGenStock.getClasif_ent_fila() != null) {
			dataset.fieldValue("oid_clasif_ent_fila", confConsGenStock.getClasif_ent_fila().getOIDInteger());
			dataset.fieldValue("cod_clasif_ent_fila", confConsGenStock.getClasif_ent_fila().getCodigo());
			dataset.fieldValue("desc_clasif_ent_fila", confConsGenStock.getClasif_ent_fila().getDescripcion());
		} else {
			dataset.fieldValue("oid_clasif_ent_fila", "");
			dataset.fieldValue("cod_clasif_ent_fila", "");
			dataset.fieldValue("desc_clasif_ent_fila", "");
		}
		dataset.fieldValue("fil_prod_stk_cod", confConsGenStock.isFiltrarProdStockPorCodigo());
		dataset.fieldValue("fil_prod_stk_des", confConsGenStock.isFiltrarProdStockPorDesc());
		dataset.fieldValue("consolidar_stock", confConsGenStock.isConsolidarStock());
		dataset.fieldValue("ver_col_tot_fila", confConsGenStock.isVerColTotFila());
	}

	private IDataSet getDataSetConfConsGenStockDepo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConfConsGenStockDepo");
		dataset.fieldDef(new Field("oid_dep_conf_cons_stk", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conf_cons_stk", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroConfConsGenStockDepo(IDataSet dataset, ConfConsGenStockDepo confConsGenStockDepo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_dep_conf_cons_stk", confConsGenStockDepo.getOIDInteger());
		dataset.fieldValue("oid_deposito", confConsGenStockDepo.getDeposito().getOIDInteger());
		dataset.fieldValue("oid_conf_cons_stk", confConsGenStockDepo.getConf_cons_stk().getOIDInteger());
		dataset.fieldValue("activo", confConsGenStockDepo.isActivo());
		dataset.fieldValue("orden", confConsGenStockDepo.getOrden());
	}

	private IDataSet getDataSetConfConsGenStockEst() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConfConsGenStockEst");
		dataset.fieldDef(new Field("oid_est_conf_cons_stk", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_estado_stock", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conf_cons_stk", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroConfConsGenStockEst(IDataSet dataset, ConfConsGenStockEst confConsGenStockEst) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_est_conf_cons_stk", confConsGenStockEst.getOIDInteger());
		dataset.fieldValue("oid_estado_stock", confConsGenStockEst.getEstado_stock().getOIDInteger());
		dataset.fieldValue("oid_conf_cons_stk", confConsGenStockEst.getConf_cons_stk().getOIDInteger());
		dataset.fieldValue("activo", confConsGenStockEst.isActivo());
		dataset.fieldValue("orden", confConsGenStockEst.getOrden());
	}
	
	  private IDataSet getDataSetConfConsGenStockFil() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TConfConsGenStockFil");
		    dataset.fieldDef(new Field("oid_fil_conf_cons", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("oid_conf_cons_stk", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("cod_clasif_ent", Field.STRING, 50));
		    dataset.fieldDef(new Field("desc_clasif_ent", Field.STRING, 100));
		    dataset.fieldDef(new Field("filtra_por_codigo", Field.BOOLEAN, 0)); 
		    dataset.fieldDef(new Field("filtra_por_desc", Field.BOOLEAN, 0)); 
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
		    return dataset;
	  }

		  private void cargarRegistroConfConsGenStockFil(IDataSet dataset, 
		                         ConfConsGenStockFil confConsGenStockFil) throws BaseException {
		    dataset.append(); 
		    dataset.fieldValue("oid_fil_conf_cons", confConsGenStockFil.getOIDInteger());
		    dataset.fieldValue("oid_conf_cons_stk", confConsGenStockFil.getConf_cons_stock().getOIDInteger());
		    dataset.fieldValue("oid_clasif_ent", confConsGenStockFil.getClasificador_entidad().getOIDInteger());
		    dataset.fieldValue("cod_clasif_ent", confConsGenStockFil.getClasificador_entidad().getCodigo());
		    dataset.fieldValue("desc_clasif_ent", confConsGenStockFil.getClasificador_entidad().getDescripcion());
		    dataset.fieldValue("filtra_por_codigo", confConsGenStockFil.isFiltra_por_codigo());
		    dataset.fieldValue("filtra_por_desc", confConsGenStockFil.isFiltra_por_desc());
		    dataset.fieldValue("activo", confConsGenStockFil.isActivo());
		  }	

}
