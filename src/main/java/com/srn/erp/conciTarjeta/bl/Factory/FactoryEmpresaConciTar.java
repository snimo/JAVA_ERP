package com.srn.erp.conciTarjeta.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.da.DBEmpresaConciTar;

public class FactoryEmpresaConciTar extends FactoryObjetoLogico { 

  public FactoryEmpresaConciTar() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
	  
    EmpresaConciTar empresaconcitar = (EmpresaConciTar) objLog;
    empresaconcitar.setOID(db.getInteger(DBEmpresaConciTar.OID_EMPRESA));
    empresaconcitar.setRazon_social(db.getString(DBEmpresaConciTar.RAZON_SOCIAL));
    empresaconcitar.setCuit(db.getString(DBEmpresaConciTar.CUIT));
    empresaconcitar.setActivo(db.getBoolean(DBEmpresaConciTar.ACTIVO));
    empresaconcitar.setCodComercio(db.getString(DBEmpresaConciTar.COD_COMERCIO));
    empresaconcitar.setUltNroconci(db.getInteger(DBEmpresaConciTar.ULT_NRO_CONCI));
    empresaconcitar.setCodEmpArchImpTarj(db.getString(DBEmpresaConciTar.COD_EMP_ARCH_TARJ));
    empresaconcitar.setTipoAsiCob(db.getString(DBEmpresaConciTar.TIPO_ASI_COB));
    empresaconcitar.setTipoAsiLiq(db.getString(DBEmpresaConciTar.TIPO_ASI_LIQUI));
    empresaconcitar.setCodEmpInterfaz(db.getString(DBEmpresaConciTar.COD_EMP_INTERFAZ));
    empresaconcitar.setTipoDocuAsiCobranza(db.getString(DBEmpresaConciTar.TIPO_DOCU_ASI_COB));
    empresaconcitar.setTipoDocuAsiLiquidacion(db.getString(DBEmpresaConciTar.TIPO_DOCU_ASI_LIQ));
    empresaconcitar.setUniContaAsiCobranza(db.getString(DBEmpresaConciTar.UNI_CONTA_ASI_COB));
    empresaconcitar.setUnidadContaAsiLiq(db.getString(DBEmpresaConciTar.UNI_CONTA_ASI_LIQ));
    
  }
}

