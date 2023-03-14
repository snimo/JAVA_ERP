package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.Vendedor;
import com.srn.erp.ventas.da.DBVendedor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryVendedor extends FactoryObjetoLogico {

  public FactoryVendedor() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Vendedor vendedor = (Vendedor) objLog;
    vendedor.setOID(db.getInteger(DBVendedor.OID_VENDEDOR));
    vendedor.setCodigo(db.getString(DBVendedor.CODIGO));
    vendedor.setApellido(db.getString(DBVendedor.APELLIDO));
    vendedor.setNombre(db.getString(DBVendedor.NOMBRE));
    vendedor.setActivo(db.getBoolean(DBVendedor.ACTIVO));
    vendedor.setMail(db.getString(DBVendedor.MAIL));
    vendedor.setTelefono(db.getString(DBVendedor.TELEFONO));
  }
}
