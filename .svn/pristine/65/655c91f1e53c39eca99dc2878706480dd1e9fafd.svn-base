package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.TipoUnidadEdilicia;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.bm.Zona;
import com.srn.erp.ventas.da.DBUnidadEdilicia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryUnidadEdilicia extends FactoryObjetoLogico {

  public FactoryUnidadEdilicia() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UnidadEdilicia unidadedilicia = (UnidadEdilicia) objLog;
    unidadedilicia.setOID(db.getInteger(DBUnidadEdilicia.OID_UNI_EDI));
    unidadedilicia.setCodigo(db.getString(DBUnidadEdilicia.CODIGO));
    unidadedilicia.setCalle_y_mro(db.getString(DBUnidadEdilicia.CALLE_Y_NRO));
    unidadedilicia.setLocalidad(db.getString(DBUnidadEdilicia.LOCALIDAD));
    unidadedilicia.setCodigo_postal(db.getString(DBUnidadEdilicia.CODIGO_POSTAL));
    unidadedilicia.setTipo_unidad(TipoUnidadEdilicia.findByOidProxy(db.getInteger(DBUnidadEdilicia.OID_TIPO_UNIDAD),getSesion()));
    unidadedilicia.setTelefonos(db.getString(DBUnidadEdilicia.TELEFONOS));
    unidadedilicia.setProvincia(Provincia.findByOidProxy(db.getInteger(DBUnidadEdilicia.OID_PROVINCIA),getSesion()));
    unidadedilicia.setDom_ent(db.getBoolean(DBUnidadEdilicia.DOM_ENT));
    unidadedilicia.setContacto(db.getString(DBUnidadEdilicia.CONTACTO));
    unidadedilicia.setSujeto_alta(Sujeto.findByOidProxy(db.getInteger(DBUnidadEdilicia.OID_SUJETO_ALTA),getSesion()));
    unidadedilicia.setPais(Pais.findByOidProxy(db.getInteger(DBUnidadEdilicia.OID_PAIS),getSesion()));
    unidadedilicia.setZona(Zona.findByOidProxy(db.getInteger(DBUnidadEdilicia.OID_ZONA),getSesion()));
    unidadedilicia.setActivo(db.getBoolean(DBUnidadEdilicia.ACTIVO));
    unidadedilicia.setDirCompleta(db.getString(DBUnidadEdilicia.DIR_COMPLETA));
    unidadedilicia.setIsDomicilioCobranza(db.getBoolean(DBUnidadEdilicia.DOM_COBRANZA));
  }
}
