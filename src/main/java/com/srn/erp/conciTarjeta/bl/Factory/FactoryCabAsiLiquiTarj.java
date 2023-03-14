package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.CabAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.CabModeloLiq;
import com.srn.erp.conciTarjeta.bm.CtaBancoLiqTarj;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.TipoArchConciTar;
import com.srn.erp.conciTarjeta.da.DBCabAsiLiquiTarj;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCabAsiLiquiTarj extends FactoryObjetoLogico { 

  public FactoryCabAsiLiquiTarj() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CabAsiLiquiTarj cabasiliquitarj = (CabAsiLiquiTarj) objLog;
    cabasiliquitarj.setOID(db.getInteger(DBCabAsiLiquiTarj.OID_CAB_ASI_LIQ));
    cabasiliquitarj.setFec_asiento(db.getDate(DBCabAsiLiquiTarj.FEC_ASIENTO));
    cabasiliquitarj.setComentario(db.getString(DBCabAsiLiquiTarj.COMENTARIO));
    cabasiliquitarj.setNro_liquidacion(db.getInteger(DBCabAsiLiquiTarj.NRO_LIQUIDACION));
    cabasiliquitarj.setArch_interfaz_gen(db.getBoolean(DBCabAsiLiquiTarj.ARCH_INTERFAZ_GEN));
    cabasiliquitarj.setFec_arch_interfaz(db.getDate(DBCabAsiLiquiTarj.FEC_ARCH_INTERFAZ));
    cabasiliquitarj.setHora_arch_interfaz(db.getString(DBCabAsiLiquiTarj.HORA_ARCH_INTERFAZ));
    cabasiliquitarj.setConta_sist_ext(db.getBoolean(DBCabAsiLiquiTarj.CONTA_SIST_EXT));
    cabasiliquitarj.setFec_conta_sist_ext(db.getDate(DBCabAsiLiquiTarj.FEC_CONTA_SIST_EXT));
    cabasiliquitarj.setHor_conta_sist_ext(db.getString(DBCabAsiLiquiTarj.HOR_CONTA_SIST_EXT));
    cabasiliquitarj.setTipo_archivo(TipoArchConciTar.findByOidProxy(db.getInteger(DBCabAsiLiquiTarj.OID_TIPO_ARCHIVO),getSesion()));
    cabasiliquitarj.setActivo(db.getBoolean(DBCabAsiLiquiTarj.ACTIVO));
    cabasiliquitarj.setCtaBancoLiqTarj(CtaBancoLiqTarj.findByOidProxy(db.getInteger(DBCabAsiLiquiTarj.OID_CTA_BANCO),getSesion()));
    cabasiliquitarj.setCabModeloLiq(CabModeloLiq.findByOidProxy(db.getInteger(DBCabAsiLiquiTarj.OID_MODELO_LIQ),getSesion()));
    cabasiliquitarj.setEmpresa(EmpresaConciTar.findByOidProxy(db.getInteger(DBCabAsiLiquiTarj.OID_EMPRESA),getSesion()));
  }
}
