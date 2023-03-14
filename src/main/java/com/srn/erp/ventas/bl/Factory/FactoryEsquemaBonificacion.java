package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.ventas.bm.EsquemaBonificacion;
import com.srn.erp.ventas.da.DBEsquemaBonificacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEsquemaBonificacion extends FactoryObjetoLogico { 

  public FactoryEsquemaBonificacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EsquemaBonificacion esquemabonificacion = (EsquemaBonificacion) objLog;
    esquemabonificacion.setOID(db.getInteger(DBEsquemaBonificacion.OID_ESQ_BONIF));
    esquemabonificacion.setCodigo(db.getString(DBEsquemaBonificacion.CODIGO));
    esquemabonificacion.setDescripcion(db.getString(DBEsquemaBonificacion.DESCRIPCION));
    esquemabonificacion.setFec_vig_desde(db.getDate(DBEsquemaBonificacion.FEC_VIG_DESDE));
    esquemabonificacion.setClasificador_entidad(ClasificadorEntidad.findByOidProxy(db.getInteger(DBEsquemaBonificacion.OID_CLASIF_ENT),getSesion()));
    esquemabonificacion.setFec_vig_hasta(db.getDate(DBEsquemaBonificacion.FEC_VIG_HASTA));
    esquemabonificacion.setActivo(db.getBoolean(DBEsquemaBonificacion.ACTIVO));
  }
}
