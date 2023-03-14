package com.srn.erp.bancos.bl.Factory;

import com.srn.erp.bancos.bm.BoletaDeposito;
import com.srn.erp.bancos.bm.GastoBoletaDeposito;
import com.srn.erp.bancos.da.DBGastoBoletaDeposito;
import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGastoBoletaDeposito extends FactoryObjetoLogico { 

  public FactoryGastoBoletaDeposito() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GastoBoletaDeposito gastoboletadeposito = (GastoBoletaDeposito) objLog;
    gastoboletadeposito.setOID(db.getInteger(DBGastoBoletaDeposito.OID));
    gastoboletadeposito.setBoleta_deposito(BoletaDeposito.findByOidProxy(db.getInteger(DBGastoBoletaDeposito.OID_BOLETA_DEP),getSesion()));
    gastoboletadeposito.setCuenta_imputable(CuentaImputable.findByOidProxy(db.getInteger(DBGastoBoletaDeposito.OID_AI),getSesion()));
    gastoboletadeposito.setDebe(db.getMoney(DBGastoBoletaDeposito.DEBE));
    gastoboletadeposito.setHaber(db.getMoney(DBGastoBoletaDeposito.HABER));
    gastoboletadeposito.setComentario(db.getString(DBGastoBoletaDeposito.COMENTARIO));

  }
}
