package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.ventas.bm.DevolucionVtasCab;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.da.DBDevolucionVtasCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryDevolucionVtasCab extends FactoryObjetoLogico { 

  public FactoryDevolucionVtasCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DevolucionVtasCab devolucionvtascab = (DevolucionVtasCab) objLog;
    devolucionvtascab.setOID(db.getInteger(DBDevolucionVtasCab.OID_DEV_CAB));
    
    // Por comproCab
    devolucionvtascab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    devolucionvtascab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    devolucionvtascab.setTcExt(db.getString(DBComproCab.TC_EXT));
    devolucionvtascab.setLetra(db.getString(DBComproCab.LETRA));
    devolucionvtascab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    devolucionvtascab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    devolucionvtascab.setNroext(db.getInteger(DBComproCab.NROEXT));
    devolucionvtascab.setEmision(db.getDate(DBComproCab.EMISION));
    devolucionvtascab.setEstado(db.getString(DBComproCab.ESTADO));
    devolucionvtascab.setComentario(db.getString(DBComproCab.COMENTARIO));
    devolucionvtascab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    devolucionvtascab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    devolucionvtascab.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    devolucionvtascab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    devolucionvtascab.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    
    devolucionvtascab.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBDevolucionVtasCab.OID_SUJETO),getSesion()));
    devolucionvtascab.setTipoDevolucion(db.getString(DBDevolucionVtasCab.TIPO_DEVOLUCION));
    devolucionvtascab.setFacturaCab(FacturaCab.findByOidProxy(db.getInteger(DBDevolucionVtasCab.OID_CCO_FACT),getSesion()));
    devolucionvtascab.setPedidoCab(PedidoCab.findByOidProxy(db.getInteger(DBDevolucionVtasCab.OID_CCO_PED),getSesion()));
    devolucionvtascab.setRemitoCab(RemitoCab.findByOidProxy(db.getInteger(DBDevolucionVtasCab.OID_CCO_RTO),getSesion()));
    devolucionvtascab.setTipoOperacion(db.getString(DBDevolucionVtasCab.TIPO_OPER));
  }
}
