package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.EmpresaHabUsu;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.da.DBEmpresaHabUsu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryEmpresaHabUsu extends FactoryObjetoLogico {

  public FactoryEmpresaHabUsu() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EmpresaHabUsu empresahabusu = (EmpresaHabUsu) objLog;
    empresahabusu.setOID(db.getInteger(DBEmpresaHabUsu.OID_EMP_HAB_USU));
    empresahabusu.setUsuario(Usuario.findByOidProxy(db.getInteger(DBEmpresaHabUsu.OID_USUARIO),getSesion()));
    empresahabusu.setEmpresa(Empresa.findByOidProxy(db.getInteger(DBEmpresaHabUsu.OID_EMPRESA),getSesion()));
    empresahabusu.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBEmpresaHabUsu.OID_SUCURSAL),getSesion()));
    empresahabusu.setUsarPorDefecto(db.getBoolean(DBEmpresaHabUsu.USAR_POR_DEFECTO));
  }
}
