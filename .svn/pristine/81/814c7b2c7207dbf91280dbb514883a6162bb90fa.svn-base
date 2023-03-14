package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;
import com.srn.erp.reclutamiento.bm.RecluFuente;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.da.DBRecluPostulante;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluPostulante extends FactoryObjetoLogico { 

  public FactoryRecluPostulante() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluPostulante reclupostulante = (RecluPostulante) objLog;
    reclupostulante.setOID(db.getInteger(DBRecluPostulante.OID_POSTULANTE));
    reclupostulante.setApe_y_nom(db.getString(DBRecluPostulante.APE_Y_NOM));
    reclupostulante.setTipo_documento(TipoDocumento.findByOidProxy(db.getInteger(DBRecluPostulante.OID_TIPO_DOCU),getSesion()));
    reclupostulante.setNro_docu(db.getString(DBRecluPostulante.NRO_DOCU));
    reclupostulante.setFec_nacimiento(db.getDate(DBRecluPostulante.FEC_NACIMIENTO));
    reclupostulante.setDireccion(db.getString(DBRecluPostulante.DIRECCION));
    reclupostulante.setLocalidad(db.getString(DBRecluPostulante.LOCALIDAD));
    reclupostulante.setCod_postal(db.getString(DBRecluPostulante.COD_POSTAL));
    reclupostulante.setTelefono_fijo(db.getString(DBRecluPostulante.TELEFONO_FIJO));
    reclupostulante.setTelefono_celular(db.getString(DBRecluPostulante.TELEFONO_CELULAR));
    reclupostulante.setReferido_por(db.getString(DBRecluPostulante.REFERIDO_POR));
    reclupostulante.setSexo(db.getString(DBRecluPostulante.SEXO));
    reclupostulante.setActivo(db.getBoolean(DBRecluPostulante.ACTIVO));
    reclupostulante.setNroReferido(db.getInteger(DBRecluPostulante.NRO_REFERIDO));
    reclupostulante.setIsReferido(db.getBoolean(DBRecluPostulante.ES_REFERIDO));
    reclupostulante.setFuente(RecluFuente.findByOidProxy(db.getInteger(DBRecluPostulante.OID_FUENTE),getSesion()));
    reclupostulante.setEstadoPostulante(RecluEstadoPostulante.findByOidProxy(db.getInteger(DBRecluPostulante.OID_ESTADO_POSTU),getSesion()));
    reclupostulante.setFecEstadoPostulante(db.getDate(DBRecluPostulante.FEC_EST_POSTU));
  }
}
