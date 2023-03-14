package com.srn.erp.compras.bl.Factory;

import com.srn.erp.ctasAPagar.bm.EstadisticaComproProv;
import com.srn.erp.ctasAPagar.da.DBEstadisticaComproProv;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadisticaComproProv extends FactoryObjetoLogico { 

  public FactoryEstadisticaComproProv() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
	EstadisticaComproProv estadistica = (EstadisticaComproProv) objLog;
	estadistica.setNro_ext(db.getInteger(DBEstadisticaComproProv.NRO_EXT));
	estadistica.setOid_tc(db.getInteger(DBEstadisticaComproProv.OID_TC));
	estadistica.setTc_ext(db.getString(DBEstadisticaComproProv.TC_EXT));
	estadistica.setLetra(db.getString(DBEstadisticaComproProv.LETRA));
	estadistica.setLug_emi(db.getInteger(DBEstadisticaComproProv.LUG_EMI));
	estadistica.setOid_Proveedor(db.getInteger(DBEstadisticaComproProv.OID_PROVEEDOR));
	estadistica.setOid_cond_pago(db.getInteger(DBEstadisticaComproProv.OID_COND_PAGO));
	estadistica.setOid_Sector_Compra(db.getInteger(DBEstadisticaComproProv.OID_SECTOR_COMPRA));
	estadistica.setOidConcepto(db.getInteger(DBEstadisticaComproProv.OID_CONCEPTO));
	estadistica.setDescConcepto(db.getString(DBEstadisticaComproProv.DESC_CONCEPTO));
	estadistica.setOid_cco(db.getInteger(DBEstadisticaComproProv.OID_CCO));
	estadistica.setImporte(db.getDouble(DBEstadisticaComproProv.IMPORTE));
	estadistica.setCotizacion(db.getDouble(DBEstadisticaComproProv.COTIZACION));
	estadistica.setOid_moneda(db.getInteger(DBEstadisticaComproProv.OID_MONEDA));
	estadistica.setCod_proveedor(db.getString(DBEstadisticaComproProv.COD_PROVEEDOR));
	estadistica.setNombre_proveedor(db.getString(DBEstadisticaComproProv.NOMBRE_PROVEEDOR));
	estadistica.setSigno(db.getInteger(DBEstadisticaComproProv.SIGNO));
	estadistica.setEmision(db.getDate(DBEstadisticaComproProv.EMISION));
	estadistica.setOidTipoCtaCte(db.getInteger(DBEstadisticaComproProv.OID_TIPO_CTA_PROV));
	estadistica.setDescCuenta(db.getString(DBEstadisticaComproProv.DESC_CTA));
	estadistica.setCodCuenta(db.getString(DBEstadisticaComproProv.CODIGO_CTA));
	estadistica.setSigno(db.getInteger(DBEstadisticaComproProv.SIGNO));
  }
}
