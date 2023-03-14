package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.AgrupadorAntEmp;
import com.srn.erp.rrhh.da.DBAgrupadorAntEmp;

public class FactoryAgrupadorAntEmp extends FactoryObjetoLogico { 

  public FactoryAgrupadorAntEmp() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AgrupadorAntEmp agrupadorantemp = (AgrupadorAntEmp) objLog;
    agrupadorantemp.setOID(db.getInteger(DBAgrupadorAntEmp.OID_AGRUPADOR));
    agrupadorantemp.setCod_ant_emp(db.getString(DBAgrupadorAntEmp.COD_ANT_EMP));
    agrupadorantemp.setValorClasifEmp(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBAgrupadorAntEmp.OID_VAL_CLASIF_EMP), this.getSesion()));
    
    

  }
}
