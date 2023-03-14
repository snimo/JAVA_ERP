package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.ventas.bm.IngresoDevolucionStockCab;
import com.srn.erp.ventas.da.DBIngresoDevolucionStockCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryIngresoDevolucionStockCab extends FactoryObjetoLogico { 

  public FactoryIngresoDevolucionStockCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
	    IngresoDevolucionStockCab ingresoDevolucion = (IngresoDevolucionStockCab) objLog;
	    ingresoDevolucion.setOID(db.getInteger(DBIngresoDevolucionStockCab.OID_ING_DEV_STK));
	    ingresoDevolucion.setTalonarioOrigen(Talonario.findByOidProxy(db.getInteger(DBIngresoDevolucionStockCab.OID_TALONARIO_ORIGEN),getSesion()));
	    
	    // Por comproCab
	    ingresoDevolucion.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
	    ingresoDevolucion.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
	    ingresoDevolucion.setTcExt(db.getString(DBComproCab.TC_EXT));
	    ingresoDevolucion.setLetra(db.getString(DBComproCab.LETRA));
	    ingresoDevolucion.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
	    ingresoDevolucion.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
	    ingresoDevolucion.setNroext(db.getInteger(DBComproCab.NROEXT));
	    ingresoDevolucion.setEmision(db.getDate(DBComproCab.EMISION));
	    ingresoDevolucion.setEstado(db.getString(DBComproCab.ESTADO));
	    ingresoDevolucion.setComentario(db.getString(DBComproCab.COMENTARIO));
	    ingresoDevolucion.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
	    ingresoDevolucion.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
	    ingresoDevolucion.setActivo(db.getBoolean(DBComproCab.ACTIVO));
	    ingresoDevolucion.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
	    ingresoDevolucion.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
	    
	    

  }
}
