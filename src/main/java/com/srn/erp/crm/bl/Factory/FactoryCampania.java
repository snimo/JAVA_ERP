package com.srn.erp.crm.bl.Factory;

import com.srn.erp.crm.bm.Campania;
import com.srn.erp.crm.bm.EstadoCampania;
import com.srn.erp.crm.bm.TipoCampania;
import com.srn.erp.crm.da.DBCampania;
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryCampania extends FactoryObjetoLogico { 

  public FactoryCampania() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Campania campania = (Campania) objLog;
   campania.setOID(db.getInteger(DBCampania.OID_CAMPANIA));
    campania.setCodigo(db.getString(DBCampania.CODIGO));
    campania.setNombre(db.getString(DBCampania.NOMBRE));
    campania.setEstado(EstadoCampania.findByOidProxy(db.getInteger(DBCampania.OID_EST_CAMP),getSesion()));
    campania.setLista_precios(ListaPrecios.findByOidProxy(db.getInteger(DBCampania.OID_PRECIO_CAB),getSesion()));
    campania.setCant_resp_esp(db.getInteger(DBCampania.CANT_RESP_ESP));
    campania.setFecha_desde(db.getDate(DBCampania.FEC_DESDE));
    campania.setFecha_hasta(db.getDate(DBCampania.FEC_HASTA));
    campania.setDescripcion(db.getString(DBCampania.DESCRIPCION));
    campania.setComentario(db.getString(DBCampania.COMENTARIO));
    campania.setUsuario_alta(Usuario.findByOidProxy(db.getInteger(DBCampania.OID_USU_ALTA),getSesion()));
    campania.setFec_usu_alta(db.getDate(DBCampania.FEC_ALTA));
    campania.setActivo(db.getBoolean(DBCampania.ACTIVO));
    campania.setTipoCampania(TipoCampania.findByOidProxy(db.getInteger(DBCampania.OID_TIPO_CAMP),getSesion()));
  }
}
