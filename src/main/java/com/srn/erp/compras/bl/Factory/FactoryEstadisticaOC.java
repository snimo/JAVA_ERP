package com.srn.erp.compras.bl.Factory;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.EstadisticaOC;
import com.srn.erp.compras.da.DBEstadisticaOC;
import com.srn.erp.general.bm.ClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadisticaOC extends FactoryObjetoLogico { 

  public FactoryEstadisticaOC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {

	    EstadisticaOC estadisticaOC = (EstadisticaOC) objLog;
	    estadisticaOC.setEmision(db.getDate(DBEstadisticaOC.EMISION));
	    estadisticaOC.setNro_ext(db.getInteger(DBEstadisticaOC.NRO_EXT));
	    estadisticaOC.setOid_tc(db.getInteger(DBEstadisticaOC.OID_TC));
	    estadisticaOC.setTc_ext(db.getString(DBEstadisticaOC.TC_EXT));
	    estadisticaOC.setLetra(db.getString(DBEstadisticaOC.LETRA));
	    estadisticaOC.setLug_emi(db.getInteger(DBEstadisticaOC.LUG_EMI));
	    estadisticaOC.setOid_Proveedor(db.getInteger(DBEstadisticaOC.OID_PROVEEDOR));
	    estadisticaOC.setOid_cond_pago(db.getInteger(DBEstadisticaOC.OID_COND_PAGO));
	    estadisticaOC.setOid_Sector_Compra(db.getInteger(DBEstadisticaOC.OID_SECTOR_COMPRA));
	    estadisticaOC.setOid_cco_det(db.getInteger(DBEstadisticaOC.OID_CCO_DET));
	    estadisticaOC.setOid_cco(db.getInteger(DBEstadisticaOC.OID_CCO));
	    estadisticaOC.setOid_producto(db.getInteger(DBEstadisticaOC.OID_PRODUCTO));
	    estadisticaOC.setOid_um(db.getInteger(DBEstadisticaOC.OID_UM));
	    estadisticaOC.setCant(db.getInteger(DBEstadisticaOC.CANT));
	    estadisticaOC.setPrecio(db.getDouble(DBEstadisticaOC.PRECIO));
	    estadisticaOC.setCotizacion(db.getDouble(DBEstadisticaOC.COTIZACION));
	    estadisticaOC.setOid_moneda(db.getInteger(DBEstadisticaOC.OID_MONEDA));
	    estadisticaOC.setCod_producto(db.getString(DBEstadisticaOC.COD_PRODUCTO));
	    estadisticaOC.setDesc_producto(db.getString(DBEstadisticaOC.DESC_PRODUCTO));
	    estadisticaOC.setCod_proveedor(db.getString(DBEstadisticaOC.COD_PROVEEDOR));
	    estadisticaOC.setNombre_proveedor(db.getString(DBEstadisticaOC.RAZON_SOCIAL));
	    estadisticaOC.setSigno(db.getInteger(DBEstadisticaOC.SIGNO));
	    
	    List listaClasif = (List) db.getParamFactory();
	    
	    // Obtener los Valores de clasificaor
	    Iterator iter = listaClasif.iterator();
	    while (iter.hasNext()) {
	    	ClasificadorEntidad clasif = (ClasificadorEntidad) iter.next();
	    	estadisticaOC.addOidValorClasif(clasif.getOIDInteger(),db.getInteger("oid_clasif_"+ clasif.getNroClasifFomateado()));
	    }

  }
}
