package com.srn.erp.ventas.bl.Factory;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.EstadisticaPedidos;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.da.DBEstadisticaPedidos;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadisticaPedidos extends FactoryObjetoLogico { 

  public FactoryEstadisticaPedidos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
  	
  	
  	
    EstadisticaPedidos estadisticapedidos = (EstadisticaPedidos) objLog;
    estadisticapedidos.setEmision(db.getDate(DBEstadisticaPedidos.EMISION));
    estadisticapedidos.setNro_ext(db.getInteger(DBEstadisticaPedidos.NRO_EXT));
    estadisticapedidos.setOid_tc(db.getInteger(DBEstadisticaPedidos.OID_TC));
    estadisticapedidos.setTc_ext(db.getString(DBEstadisticaPedidos.TC_EXT));
    estadisticapedidos.setLetra(db.getString(DBEstadisticaPedidos.LETRA));
    estadisticapedidos.setLug_emi(db.getInteger(DBEstadisticaPedidos.LUG_EMI));
    estadisticapedidos.setOid_sujeto(db.getInteger(DBEstadisticaPedidos.OID_SUJETO));
    estadisticapedidos.setOid_cond_pago(db.getInteger(DBEstadisticaPedidos.OID_COND_PAGO));
    estadisticapedidos.setOid_vendedor(db.getInteger(DBEstadisticaPedidos.OID_VENDEDOR));
    estadisticapedidos.setOid_cco_det(db.getInteger(DBEstadisticaPedidos.OID_CCO_DET));
    estadisticapedidos.setOid_cco(db.getInteger(DBEstadisticaPedidos.OID_CCO));
    estadisticapedidos.setOid_producto(db.getInteger(DBEstadisticaPedidos.OID_PRODUCTO));
    estadisticapedidos.setOid_um(db.getInteger(DBEstadisticaPedidos.OID_UM));
    estadisticapedidos.setCant(db.getInteger(DBEstadisticaPedidos.CANT));
    estadisticapedidos.setPrecio(db.getDouble(DBEstadisticaPedidos.PRECIO));
    estadisticapedidos.setCotizacion(db.getDouble(DBEstadisticaPedidos.COTIZACION));
    estadisticapedidos.setOid_moneda(db.getInteger(DBEstadisticaPedidos.OID_MONEDA));
    estadisticapedidos.setCod_producto(db.getString(DBEstadisticaPedidos.COD_PRODUCTO));
    estadisticapedidos.setDesc_producto(db.getString(DBEstadisticaPedidos.DESC_PRODUCTO));
    estadisticapedidos.setCod_cliente(db.getString(DBEstadisticaPedidos.COD_CLIENTE));
    estadisticapedidos.setNombre_cliente(db.getString(DBEstadisticaPedidos.NOMBRE_CLIENTE));
    estadisticapedidos.setSigno(db.getInteger(DBEstadisticaPedidos.SIGNO));
    
    List listaClasif = (List) db.getParamFactory();
    
    // Obtener los Valores de clasificaor
    Iterator iter = listaClasif.iterator();
    while (iter.hasNext()) {
    	ClasificadorEntidad clasif = (ClasificadorEntidad) iter.next();
    	estadisticapedidos.addOidValorClasif(clasif.getOIDInteger(),db.getInteger("oid_clasif_"+ clasif.getNroClasifFomateado()));
    }
    
    // Cargar los clasificadores de productos
    
    
    

  }
}
