package com.srn.erp.stock.op;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.bm.ConfConsGenStock;
import com.srn.erp.stock.bm.ConfConsGenStockDepo;
import com.srn.erp.stock.bm.ConfConsGenStockEst;
import com.srn.erp.stock.bm.ConfConsGenStockFil;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfConsGenStock extends Operation { 

  public SaveConfConsGenStock() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TConfConsGenStock"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ConfConsGenStock confconsgenstock = ConfConsGenStock.findByOid(dataset.getInteger("oid_conf_cons_stk"),getSesion());
        confconsgenstock.setOID(dataset.getInteger("oid_conf_cons_stk"));
        confconsgenstock.setCodigo(dataset.getString("codigo"));
        confconsgenstock.setDescripcion(dataset.getString("descripcion"));
        confconsgenstock.setActivo(dataset.getBoolean("activo"));
        confconsgenstock.setTipo_valor_fila(dataset.getString("tipo_valor_fila"));
        confconsgenstock.setClasif_ent_grupo(ClasificadorEntidad.findByOidProxy(dataset.getInteger("oid_clasif_ent_agrup"),this.getSesion()));
        confconsgenstock.setTotalizar(dataset.getBoolean("totalizar"));
        confconsgenstock.setClasif_ent_fila(ClasificadorEntidad.findByOidProxy(dataset.getInteger("oid_clasif_ent_fila"),this.getSesion()));
        confconsgenstock.setFiltrarProdStockPorCodigo(dataset.getBoolean("fil_prod_stk_cod"));
        confconsgenstock.setFiltrarProdStockPorDesc(dataset.getBoolean("fil_prod_stk_des"));
        confconsgenstock.setConsolidarStock(dataset.getBoolean("consolidar_stock"));
        confconsgenstock.setVerColTotFila(dataset.getBoolean("ver_col_tot_fila"));
        
        IDataSet dsDepositos = dataset.getDataSet("TConfConsGenStockDepo");
        dsDepositos.first();
        while (!dsDepositos.EOF()) {
        	ConfConsGenStockDepo confConsGenStockDepo =
        		ConfConsGenStockDepo.findByOid(dsDepositos.getInteger("oid_dep_conf_cons_stk"), this.getSesion());
        	confConsGenStockDepo.setConf_cons_stk(confconsgenstock);
        	confConsGenStockDepo.setDeposito(Deposito.findByOidProxy(dsDepositos.getInteger("oid_deposito"), this.getSesion()));
        	confConsGenStockDepo.setOrden(dsDepositos.getInteger("orden"));
        	confConsGenStockDepo.setActivo(dsDepositos.getBoolean("activo"));
        	if (!dsDepositos.getBoolean("activo"))
        		confConsGenStockDepo.delete();
        	
        	confconsgenstock.addConfDeposito(confConsGenStockDepo);
        	
        	
        	dsDepositos.next();
        }
        
        IDataSet dsEstados = dataset.getDataSet("TConfConsGenStockEst");
        dsEstados.first();
        while (!dsEstados.EOF()) {
        	ConfConsGenStockEst confConsGenStockEst =
        		ConfConsGenStockEst.findByOid(dsEstados.getInteger("oid_est_conf_cons_stk"), this.getSesion());
        	confConsGenStockEst.setConf_cons_stk(confconsgenstock);
        	confConsGenStockEst.setEstado_stock(EstadoStock.findByOidProxy(dsEstados.getInteger("oid_estado_stock"), this.getSesion()));
        	confConsGenStockEst.setOrden(dsEstados.getInteger("orden"));
        	confConsGenStockEst.setActivo(dsEstados.getBoolean("activo"));
        	if (!dsEstados.getBoolean("activo"))
        		confConsGenStockEst.delete();
        	
        	confconsgenstock.addConfEstado(confConsGenStockEst);
        	
        	
        	dsEstados.next();
        }
        
        IDataSet dsFiltros = dataset.getDataSet("TConfConsGenStockFil");
        dsFiltros.first();
        while (!dsFiltros.EOF()) {
        	ConfConsGenStockFil confConsGenStockFil =
        		ConfConsGenStockFil.findByOid(dsFiltros.getInteger("oid_fil_conf_cons"), this.getSesion());
        	confConsGenStockFil.setConf_cons_stock(confconsgenstock);
        	confConsGenStockFil.setClasificador_entidad(ClasificadorEntidad.findByOidProxy(dsFiltros.getInteger("oid_clasif_ent"), this.getSesion()));
        	confConsGenStockFil.setFiltra_por_codigo(dsFiltros.getBoolean("filtra_por_codigo"));
        	confConsGenStockFil.setFiltra_por_desc(dsFiltros.getBoolean("filtra_por_desc"));
        	confConsGenStockFil.setActivo(dsFiltros.getBoolean("activo"));
        	if (!dsFiltros.getBoolean("activo"))
        		confConsGenStockFil.delete();
        	confconsgenstock.addFiltro(confConsGenStockFil);
        	
        	
        	dsFiltros.next();
        }        
        
        
        
        addTransaccion(confconsgenstock);
        dataset.next();
    }
  }
  
}
