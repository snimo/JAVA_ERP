package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.CabAsiTarjACobrar;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.da.DBCabAsiTarjACobrar;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCabAsiTarjACobrar extends FactoryObjetoLogico { 

  public FactoryCabAsiTarjACobrar() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CabAsiTarjACobrar cabasitarjacobrar = (CabAsiTarjACobrar) objLog;
    cabasitarjacobrar.setOID(db.getInteger(DBCabAsiTarjACobrar.OID_CAB_ASI_ACOB));
    cabasitarjacobrar.setFec_asiento(db.getDate(DBCabAsiTarjACobrar.FEC_ASIENTO));
    cabasitarjacobrar.setComentario(db.getString(DBCabAsiTarjACobrar.COMENTARIO));
    cabasitarjacobrar.setNro_liquidacion(db.getInteger(DBCabAsiTarjACobrar.NRO_LIQUIDACION));
    cabasitarjacobrar.setArch_interfaz_gen(db.getBoolean(DBCabAsiTarjACobrar.ARCH_INTERFAZ_GEN));
    cabasitarjacobrar.setFec_arch_interfaz(db.getDate(DBCabAsiTarjACobrar.FEC_ARCH_INTERFAZ));
    cabasitarjacobrar.setActivo(db.getBoolean(DBCabAsiTarjACobrar.ACTIVO));
    cabasitarjacobrar.setHora_arch_interfaz(db.getString(DBCabAsiTarjACobrar.HORA_ARCH_INTERFAZ));
    cabasitarjacobrar.setConta_sist_ext(db.getBoolean(DBCabAsiTarjACobrar.CONTA_SIST_EXT));
    cabasitarjacobrar.setFec_conta_sist_ext(db.getDate(DBCabAsiTarjACobrar.FEC_CONTA_SIST_EXT));
    cabasitarjacobrar.setHor_conta_sist_ext(db.getString(DBCabAsiTarjACobrar.HOR_CONTA_SIST_EXT));
    cabasitarjacobrar.setEmpresa(EmpresaConciTar.findByOidProxy(db.getInteger(DBCabAsiTarjACobrar.OID_EMPRESA), this.getSesion()));
  }
}
