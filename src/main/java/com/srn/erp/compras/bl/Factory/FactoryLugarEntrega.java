package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.LugarEntrega;
import com.srn.erp.compras.da.DBLugarEntrega;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLugarEntrega extends FactoryObjetoLogico { 

  public FactoryLugarEntrega() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LugarEntrega lugarentrega = (LugarEntrega) objLog;
    lugarentrega.setOID(db.getInteger(DBLugarEntrega.OID_LUG_ENTREGA));
    lugarentrega.setCodigo(db.getString(DBLugarEntrega.CODIGO));
    lugarentrega.setDescripcion(db.getString(DBLugarEntrega.DESCRIPCION));
    lugarentrega.setActivo(db.getBoolean(DBLugarEntrega.ACTIVO));
    lugarentrega.setDireccion(db.getString(DBLugarEntrega.DIRECCION));
    lugarentrega.setLocalidad(db.getString(DBLugarEntrega.LOCALIDAD));
    lugarentrega.setProvincia(Provincia.findByOidProxy(db.getInteger(DBLugarEntrega.OID_PROVINCIA),getSesion()));
    lugarentrega.setPais(Pais.findByOidProxy(db.getInteger(DBLugarEntrega.OID_PAIS),getSesion()));
    lugarentrega.setCodigoPostal(db.getString(DBLugarEntrega.CODIGO_POSTAL));
    lugarentrega.setTelefonos(db.getString(DBLugarEntrega.TELEFONOS));
  }
  
}
