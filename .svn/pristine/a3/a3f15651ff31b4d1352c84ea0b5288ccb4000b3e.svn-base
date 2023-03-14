package com.srn.erp.ventas.bl.Factory;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.ventas.bm.EstadisticaFacturas;
import com.srn.erp.ventas.da.DBEstadisticaFacturas;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadisticaFacturas extends FactoryObjetoLogico { 

  public FactoryEstadisticaFacturas() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
  	
  	
  	
    EstadisticaFacturas estadisticafacturas = (EstadisticaFacturas) objLog;
    estadisticafacturas.setEmision(db.getDate(DBEstadisticaFacturas.EMISION));
    estadisticafacturas.setNro_ext(db.getInteger(DBEstadisticaFacturas.NRO_EXT));
    estadisticafacturas.setOid_tc(db.getInteger(DBEstadisticaFacturas.OID_TC));
    estadisticafacturas.setTc_ext(db.getString(DBEstadisticaFacturas.TC_EXT));
    estadisticafacturas.setLetra(db.getString(DBEstadisticaFacturas.LETRA));
    estadisticafacturas.setLug_emi(db.getInteger(DBEstadisticaFacturas.LUG_EMI));
    estadisticafacturas.setOid_sujeto(db.getInteger(DBEstadisticaFacturas.OID_SUJETO));
    estadisticafacturas.setOid_cond_pago(db.getInteger(DBEstadisticaFacturas.OID_COND_PAGO));
    estadisticafacturas.setOid_vendedor(db.getInteger(DBEstadisticaFacturas.OID_VENDEDOR));
    estadisticafacturas.setOid_cco_det(db.getInteger(DBEstadisticaFacturas.OID_CCO_DET));
    estadisticafacturas.setOid_cco(db.getInteger(DBEstadisticaFacturas.OID_CCO));
    estadisticafacturas.setOid_producto(db.getInteger(DBEstadisticaFacturas.OID_PRODUCTO));
    estadisticafacturas.setOid_um(db.getInteger(DBEstadisticaFacturas.OID_UM));
    estadisticafacturas.setCant(db.getInteger(DBEstadisticaFacturas.CANT));
    estadisticafacturas.setPrecio(db.getDouble(DBEstadisticaFacturas.PRECIO));
    estadisticafacturas.setCotizacion(db.getDouble(DBEstadisticaFacturas.COTIZACION));
    estadisticafacturas.setOid_moneda(db.getInteger(DBEstadisticaFacturas.OID_MONEDA));
    estadisticafacturas.setCod_producto(db.getString(DBEstadisticaFacturas.COD_PRODUCTO));
    estadisticafacturas.setDesc_producto(db.getString(DBEstadisticaFacturas.DESC_PRODUCTO));
    estadisticafacturas.setCod_cliente(db.getString(DBEstadisticaFacturas.COD_CLIENTE));
    estadisticafacturas.setNombre_cliente(db.getString(DBEstadisticaFacturas.NOMBRE_CLIENTE));
    estadisticafacturas.setSigno(db.getInteger(DBEstadisticaFacturas.SIGNO));
    
    List listaClasif = (List) db.getParamFactory();
    
    // Obtener los Valores de clasificaor
    Iterator iter = listaClasif.iterator();
    while (iter.hasNext()) {
    	ClasificadorEntidad clasif = (ClasificadorEntidad) iter.next();
    	estadisticafacturas.addOidValorClasif(clasif.getOIDInteger(),db.getInteger("oid_clasif_"+ clasif.getNroClasifFomateado()));
    }
    
    // Cargar los clasificadores de productos
    
    
    

  }
}
