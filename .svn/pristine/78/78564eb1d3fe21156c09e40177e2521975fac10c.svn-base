package com.srn.erp.costos.bl.Factory;

import com.srn.erp.costos.bm.ProcesoCostoProductos;
import com.srn.erp.costos.da.DBProcesoCostoProductos;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryProcesoCostoProductos extends FactoryObjetoLogico { 

  public FactoryProcesoCostoProductos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ProcesoCostoProductos procesocostoproductos = (ProcesoCostoProductos) objLog;
    procesocostoproductos.setOID(db.getInteger(DBProcesoCostoProductos.OID_PROCESO_COSTO));
    procesocostoproductos.setCodigo(db.getString(DBProcesoCostoProductos.CODIGO));
    procesocostoproductos.setFec_ejecucion(db.getDate(DBProcesoCostoProductos.FEC_EJECUCION));
    procesocostoproductos.setDescripcion(db.getString(DBProcesoCostoProductos.DESCRIPCION));
    procesocostoproductos.setHora_ejecucion(db.getString(DBProcesoCostoProductos.HORA_EJECUCION));
    procesocostoproductos.setUsuario(Usuario.findByOidProxy(db.getInteger(DBProcesoCostoProductos.OID_USUARIO),getSesion()));
    procesocostoproductos.setFecha_costo(db.getDate(DBProcesoCostoProductos.FEC_COSTO));
    procesocostoproductos.setFec_desde(db.getDate(DBProcesoCostoProductos.FEC_DESDE));
    procesocostoproductos.setActivo(db.getBoolean(DBProcesoCostoProductos.ACTIVO));
    procesocostoproductos.setFec_hasta(db.getDate(DBProcesoCostoProductos.FEC_HASTA));

  }
}
