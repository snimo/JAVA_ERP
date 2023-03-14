package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.EsquemaBonifProdDet;
import com.srn.erp.ventas.bm.EsquemaBonificacion;
import com.srn.erp.ventas.bm.EsquemaBonificacionClasifProd;
import com.srn.erp.ventas.bm.EsquemaBonificacionProducto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEsquemaBonificacion extends Operation {

  public SaveEsquemaBonificacion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TEsquemaBonificacion");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        EsquemaBonificacion esquemaBonificacion = EsquemaBonificacion.findByOid(dataset.getInteger("oid_esq_bonif"),getSesion());
        esquemaBonificacion.setCodigo(dataset.getString("codigo"));
        esquemaBonificacion.setDescripcion(dataset.getString("descripcion"));
        esquemaBonificacion.setFec_vig_desde(dataset.getDate("fec_vig_desde"));
        esquemaBonificacion.setFec_vig_hasta(dataset.getDate("fec_vig_hasta"));
        esquemaBonificacion.setClasificador_entidad(ClasificadorEntidad.findByOid(dataset.getInteger("oid_clasif_ent"),getSesion()));
        esquemaBonificacion.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsClasificadorEntidad = dataset.getDataSet("TClasificadorEntidad");
        dsClasificadorEntidad.first();
        while (!dsClasificadorEntidad.EOF()) {
          procesarBonifClasifProducto(dsClasificadorEntidad,esquemaBonificacion);
          dsClasificadorEntidad.next();
        }
        
        procesarBonifProducto(dataset,esquemaBonificacion);
        
        addTransaccion(esquemaBonificacion);
        dataset.next();
    }
  }
  
  private void procesarBonifProducto(IDataSet dsEsquemaBonif,EsquemaBonificacion esquemaBonificacion) throws BaseException {
	  IDataSet dsEsquemaBonifProd = dsEsquemaBonif.getDataSet("TEsquemaBonifProd");
	  dsEsquemaBonifProd.first();
	  while (!dsEsquemaBonifProd.EOF()) {
		  EsquemaBonificacionProducto esqBonifProd = EsquemaBonificacionProducto.findByOid(dsEsquemaBonifProd.getInteger("oid_esq_bonif_prod"),getSesion());
		  esqBonifProd.setEsquema_bonificacion(esquemaBonificacion);
		  esqBonifProd.setProducto(Producto.findByOid(dsEsquemaBonifProd.getInteger("oid_producto"),getSesion()));
		  esqBonifProd.setActivo(dsEsquemaBonifProd.getBoolean("activo"));
		  esquemaBonificacion.addEsquemaBonifProducto(esqBonifProd);
		  
		  procedureEsqBonifProdDet(dsEsquemaBonifProd,esqBonifProd);
		  
		  dsEsquemaBonifProd.next();
	  }
	  
	    
  }
  
  private void procedureEsqBonifProdDet(IDataSet dsEsquemaBonifProd,EsquemaBonificacionProducto esqBonifProd) throws BaseException {
	  
	  IDataSet dsEsqBonifProdDet = dsEsquemaBonifProd.getDataSet("TEsqBonifProdDet"); 
	  dsEsqBonifProdDet.first();
	  while (!dsEsqBonifProdDet.EOF()) {
		  EsquemaBonifProdDet esqBonifProdDet = 
			  EsquemaBonifProdDet.findByOid(dsEsqBonifProdDet.getInteger("oid_esq_bon_det"),getSesion());
		  esqBonifProdDet.setEsquema_bonif_producto(esqBonifProd);
		  esqBonifProdDet.setFec_desde(dsEsqBonifProdDet.getDate("fec_desde"));
		  esqBonifProdDet.setFec_hasta(dsEsqBonifProdDet.getDate("fec_hasta"));
		  esqBonifProdDet.setPorc_bonif_1(dsEsqBonifProdDet.getDouble("porc_bonif_1"));
		  esqBonifProdDet.setPorc_bonif_2(dsEsqBonifProdDet.getDouble("porc_bonif_2"));
		  esqBonifProdDet.setPorc_bonif_3(dsEsqBonifProdDet.getDouble("porc_bonif_3"));
		  esqBonifProdDet.setPorc_bonif_4(dsEsqBonifProdDet.getDouble("porc_bonif_4"));
		  esqBonifProdDet.setPorc_bonif_5(dsEsqBonifProdDet.getDouble("porc_bonif_5"));
		  esqBonifProdDet.setEn_cascada(dsEsqBonifProdDet.getBoolean("en_cascada"));
		  esqBonifProdDet.setActivo(dsEsqBonifProdDet.getBoolean("activo"));
		  esqBonifProd.addEsquemaBonifProdDet(esqBonifProdDet);
		  dsEsqBonifProdDet.next();
	  }
	  
  }
      
  private void procesarBonifClasifProducto(IDataSet dsClasificadorEntidad,EsquemaBonificacion esquemaBonificacion) throws BaseException {
	  dsClasificadorEntidad.first();
	  while (!dsClasificadorEntidad.EOF()) {
		  IDataSet dsValorClasif = dsClasificadorEntidad.getDataSet("TValorClasificador");
		  dsValorClasif.first();
		  while (!dsValorClasif.EOF()) {
			  procesarBonifValorClasifProd(dsValorClasif,esquemaBonificacion);
			  dsValorClasif.next();
		  }
		  dsClasificadorEntidad.next();
	  }
	  
  }
  
  private void procesarBonifValorClasifProd(IDataSet dsValorClasif,EsquemaBonificacion esquemaBonificacion) throws BaseException {
	  IDataSet dsEsquemaBonifClasif = dsValorClasif.getDataSet("TEsquemaBonifClasif");
	  dsEsquemaBonifClasif.first();
	  while (!dsEsquemaBonifClasif.EOF()) {
		  EsquemaBonificacionClasifProd esquemaBonifClasifProd = 
			  EsquemaBonificacionClasifProd.findByOid(dsEsquemaBonifClasif.getInteger("oid_esq_bon_clasif"),getSesion());
		  esquemaBonifClasifProd.setEsquema_bonificacion(esquemaBonificacion);
		  esquemaBonifClasifProd.setValor_clasif_entidad(ValorClasificadorEntidad.findByOidProxy(dsEsquemaBonifClasif.getInteger("oid_val_clasif_ent"),getSesion()));
		  esquemaBonifClasifProd.setFec_desde(dsEsquemaBonifClasif.getDate("fec_desde"));
		  esquemaBonifClasifProd.setFec_hasta(dsEsquemaBonifClasif.getDate("fec_hasta"));
		  esquemaBonifClasifProd.setPorc_bonif_1(dsEsquemaBonifClasif.getDouble("porc_bonif_1"));
		  esquemaBonifClasifProd.setPorc_bonif_2(dsEsquemaBonifClasif.getDouble("porc_bonif_2"));
		  esquemaBonifClasifProd.setPorc_bonif_3(dsEsquemaBonifClasif.getDouble("porc_bonif_3"));
		  esquemaBonifClasifProd.setPorc_bonif_4(dsEsquemaBonifClasif.getDouble("porc_bonif_4"));
		  esquemaBonifClasifProd.setPorc_bonif_5(dsEsquemaBonifClasif.getDouble("porc_bonif_5"));
		  esquemaBonifClasifProd.setEn_cascada(dsEsquemaBonifClasif.getBoolean("en_cascada"));
		  esquemaBonifClasifProd.setActivo(dsEsquemaBonifClasif.getBoolean("activo"));
		  esquemaBonificacion.addEsquemaBonifClasifProd(esquemaBonifClasifProd);
		  dsEsquemaBonifClasif.next();
	  }
	  
	  
  }
  
}


