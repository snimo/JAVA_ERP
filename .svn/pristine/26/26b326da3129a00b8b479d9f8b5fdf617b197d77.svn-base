package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.AccesoInternoPuerta;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.ReglasPermisosInt;
import com.srn.erp.cip.da.DBAccesoInternoPuerta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAccesoInternoPuerta extends FactoryObjetoLogico { 

  public FactoryAccesoInternoPuerta() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AccesoInternoPuerta accesointernopuerta = (AccesoInternoPuerta) objLog;
    accesointernopuerta.setOID(db.getInteger(DBAccesoInternoPuerta.OID_ACC_INT_PUE));
    accesointernopuerta.setSecu(db.getInteger(DBAccesoInternoPuerta.SECU));
    accesointernopuerta.setRegla(ReglasPermisosInt.findByOidProxy(db.getInteger(DBAccesoInternoPuerta.OID_REGLA_PERMISO),getSesion()));
    accesointernopuerta.setPuerta(Puerta.findByOidProxy(db.getInteger(DBAccesoInternoPuerta.OID_PUERTA),getSesion()));
    accesointernopuerta.setPrecond_entrada(db.getString(DBAccesoInternoPuerta.PRECOND_ENTRADA));
    accesointernopuerta.setTipo_compo_entra(db.getString(DBAccesoInternoPuerta.TIPO_COMPO_ENTRA));
    accesointernopuerta.setPrecond_salida(db.getString(DBAccesoInternoPuerta.PRECOND_SALIDA));
    accesointernopuerta.setTipo_compo_sali(db.getString(DBAccesoInternoPuerta.TIPO_COMPO_SALI));
    accesointernopuerta.setActivo(db.getBoolean(DBAccesoInternoPuerta.ACTIVO));
    accesointernopuerta.setMensajeEntrada(db.getString(DBAccesoInternoPuerta.MENSAJE_ENTRADA));
    accesointernopuerta.setMensajeSalida(db.getString(DBAccesoInternoPuerta.MENSAJE_SALIDA));
    accesointernopuerta.setTipoCtrlFhEnt(db.getString(DBAccesoInternoPuerta.TIPO_CTRL_FH_ENT));
    accesointernopuerta.setTipoCtrlFhSal(db.getString(DBAccesoInternoPuerta.TIPO_CTRL_FH_SAL));
    accesointernopuerta.setMinEntAntFhEnt(db.getInteger(DBAccesoInternoPuerta.MIN_ENT_ANT_FH_ENT));
    accesointernopuerta.setMinEntDesFhEnt(db.getInteger(DBAccesoInternoPuerta.MIN_ENT_DES_FH_ENT));
    accesointernopuerta.setMinEntAntFhSal(db.getInteger(DBAccesoInternoPuerta.MIN_ENT_ANT_FH_SAL));
    accesointernopuerta.setMinEntDesFhSal(db.getInteger(DBAccesoInternoPuerta.MIN_ENT_DES_FH_SAL));
    accesointernopuerta.setSalSexo(db.getString(DBAccesoInternoPuerta.SAL_SEXO));
    accesointernopuerta.setEntSexo(db.getString(DBAccesoInternoPuerta.ENT_SEXO));
  }
}
