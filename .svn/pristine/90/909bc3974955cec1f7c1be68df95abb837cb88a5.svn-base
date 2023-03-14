package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.AplicacionComproProv;
import com.srn.erp.ctasAPagar.da.DBAplicacionComproProv;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicacionComproProv extends FactoryObjetoLogico {

  public FactoryAplicacionComproProv() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicacionComproProv aplicacionComproProv = (AplicacionComproProv) objLog;
    aplicacionComproProv.setOID(db.getInteger(DBAplicacionComproProv.OID_CCO));
    
    // Por comproCab
    aplicacionComproProv.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    aplicacionComproProv.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    aplicacionComproProv.setTcExt(db.getString(DBComproCab.TC_EXT));
    aplicacionComproProv.setLetra(db.getString(DBComproCab.LETRA));
    aplicacionComproProv.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    aplicacionComproProv.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    aplicacionComproProv.setNroext(db.getInteger(DBComproCab.NROEXT));
    aplicacionComproProv.setEmision(db.getDate(DBComproCab.EMISION));
    aplicacionComproProv.setImputac(db.getDate(DBComproCab.IMPUTAC));
    aplicacionComproProv.setEstado(db.getString(DBComproCab.ESTADO));
    aplicacionComproProv.setComentario(db.getString(DBComproCab.COMENTARIO));
    aplicacionComproProv.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    aplicacionComproProv.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    aplicacionComproProv.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    aplicacionComproProv.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    aplicacionComproProv.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    
    aplicacionComproProv.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBAplicacionComproProv.PROVEEDOR),getSesion()));
    aplicacionComproProv.setAllowDesaplicar(db.getBoolean(DBAplicacionComproProv.ALLOW_DESAPLICAR));
    
  }
}
