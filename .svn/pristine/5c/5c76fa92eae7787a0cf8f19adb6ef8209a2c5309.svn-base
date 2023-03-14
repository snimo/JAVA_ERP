package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.da.DBInformeRecepcion;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryInformeRecepcion extends FactoryObjetoLogico { 

  public FactoryInformeRecepcion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    InformeRecepcion informerecepcion = (InformeRecepcion) objLog;
    informerecepcion.setOID(db.getInteger(DBInformeRecepcion.OID_INF_REC));
    
    // Por comproCab
    informerecepcion.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    informerecepcion.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    informerecepcion.setTcExt(db.getString(DBComproCab.TC_EXT));
    informerecepcion.setLetra(db.getString(DBComproCab.LETRA));
    informerecepcion.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    informerecepcion.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    informerecepcion.setNroext(db.getInteger(DBComproCab.NROEXT));
    informerecepcion.setEmision(db.getDate(DBComproCab.EMISION));
    informerecepcion.setEstado(db.getString(DBComproCab.ESTADO));
    informerecepcion.setComentario(db.getString(DBComproCab.COMENTARIO));
    informerecepcion.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    informerecepcion.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    informerecepcion.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
    informerecepcion.setImputac(db.getDate(DBComproCab.IMPUTAC));
    
    // Por el Remito
    informerecepcion.setRemito_prov(db.getString(DBInformeRecepcion.REMITO_PROV));
    informerecepcion.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBInformeRecepcion.OID_PROVEEDOR),getSesion()));
    informerecepcion.setComproProveedor(ComproProveedor.findByOidProxy(db.getInteger(DBInformeRecepcion.OID_CCO_FACT_PROV),getSesion()));
    informerecepcion.setReferencia(db.getString(DBInformeRecepcion.REFERENCIA));
    informerecepcion.setTipo(db.getString(DBInformeRecepcion.TIPO));
    
  }
}
