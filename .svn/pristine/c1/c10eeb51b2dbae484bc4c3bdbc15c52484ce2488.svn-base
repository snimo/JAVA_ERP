package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.bm.UsuarioHabilitadoRequisicion;
import com.srn.erp.compras.da.DBUsuarioHabilitadoRequisicion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryUsuarioHabilitadoRequisicion extends FactoryObjetoLogico { 

  public FactoryUsuarioHabilitadoRequisicion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UsuarioHabilitadoRequisicion usuariohabilitadorequisicion = (UsuarioHabilitadoRequisicion) objLog;
    usuariohabilitadorequisicion.setOID(db.getInteger(DBUsuarioHabilitadoRequisicion.OID_USU_HAB_REQ));
    usuariohabilitadorequisicion.setSector_compra(SectorCompra.findByOidProxy(db.getInteger(DBUsuarioHabilitadoRequisicion.OID_SECTOR_COMPRA),getSesion()));
    usuariohabilitadorequisicion.setUsuario(Usuario.findByOidProxy(db.getInteger(DBUsuarioHabilitadoRequisicion.OID_USUARIO),getSesion()));

  }
}
