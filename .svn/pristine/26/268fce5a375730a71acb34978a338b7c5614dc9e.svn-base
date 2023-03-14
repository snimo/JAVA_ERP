package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.CabTarConciEnt;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.da.DBCabTarConciEnt;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryCabTarConciEnt extends FactoryObjetoLogico { 

  public FactoryCabTarConciEnt() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CabTarConciEnt cabtarconcient = (CabTarConciEnt) objLog;
    cabtarconcient.setOID(db.getInteger(DBCabTarConciEnt.OID_TAR_INFO_CAB));
    cabtarconcient.setFec_imp(db.getDate(DBCabTarConciEnt.FEC_IMP));
    cabtarconcient.setHora_imp(db.getString(DBCabTarConciEnt.HORA_IMP));
    cabtarconcient.setNom_archivo(db.getString(DBCabTarConciEnt.NOM_ARCHIVO));
    cabtarconcient.setEmpresa(EmpresaConciTar.findByOidProxy(db.getInteger(DBCabTarConciEnt.OID_EMPRESA),getSesion()));
    cabtarconcient.setActivo(db.getBoolean(DBCabTarConciEnt.ACTIVO));
    cabtarconcient.setTipoArchivo(db.getString(DBCabTarConciEnt.TIPO_ARCHIVO));
    cabtarconcient.setCarpetaArchivo(db.getString(DBCabTarConciEnt.CARPETA_ARCHIVO));
    cabtarconcient.setFecNomArchivo(db.getDate(DBCabTarConciEnt.FEC_NOM_ARCH));
    cabtarconcient.setUsuarioAlta(Usuario.findByOidProxy(db.getInteger(DBCabTarConciEnt.OID_USU_ALTA),getSesion()));
  }
}
