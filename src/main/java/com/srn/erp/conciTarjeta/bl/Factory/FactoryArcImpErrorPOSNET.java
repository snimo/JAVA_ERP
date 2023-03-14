package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.ArcImpErrorPOSNET;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.TerminalConciTar;
import com.srn.erp.conciTarjeta.da.DBArcImpErrorPOSNET;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryArcImpErrorPOSNET extends FactoryObjetoLogico { 

  public FactoryArcImpErrorPOSNET() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ArcImpErrorPOSNET arcimperrorposnet = (ArcImpErrorPOSNET) objLog;
    arcimperrorposnet.setOID(db.getInteger(DBArcImpErrorPOSNET.OID_ERROR_IMP));
    arcimperrorposnet.setTipo_arch(db.getString(DBArcImpErrorPOSNET.TIPO_ARCH));
    arcimperrorposnet.setFecha(db.getDate(DBArcImpErrorPOSNET.FECHA));
    arcimperrorposnet.setHora(db.getString(DBArcImpErrorPOSNET.HORA));
    arcimperrorposnet.setCarpeta(db.getString(DBArcImpErrorPOSNET.CARPETA));
    arcimperrorposnet.setNombre_archivo(db.getString(DBArcImpErrorPOSNET.NOMBRE_ARCHIVO));
    arcimperrorposnet.setTerminal(TerminalConciTar.findByOidProxy(db.getInteger(DBArcImpErrorPOSNET.OID_TERMINAL),getSesion()));
    arcimperrorposnet.setEmpresa(EmpresaConciTar.findByOidProxy(db.getInteger(DBArcImpErrorPOSNET.OID_EMPRESA),getSesion()));
    arcimperrorposnet.setProblema(db.getString(DBArcImpErrorPOSNET.PROBLEMA));
    arcimperrorposnet.setActivo(db.getBoolean(DBArcImpErrorPOSNET.ACTIVO));

  }
}
