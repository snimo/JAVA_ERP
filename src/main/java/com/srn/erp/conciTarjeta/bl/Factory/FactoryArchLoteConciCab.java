package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciCab;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.da.DBArchLoteConciCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryArchLoteConciCab extends FactoryObjetoLogico { 

  public FactoryArchLoteConciCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ArchLoteConciCab archloteconcicab = (ArchLoteConciCab) objLog;
    archloteconcicab.setOID(db.getInteger(DBArchLoteConciCab.OID_ARCH_LOT_CAB));
    archloteconcicab.setEstado(db.getInteger(DBArchLoteConciCab.ESTADO));
    archloteconcicab.setProveedor_host(db.getString(DBArchLoteConciCab.PROVEEDOR_HOST));
    archloteconcicab.setNro_host(db.getString(DBArchLoteConciCab.NRO_HOST));
    archloteconcicab.setNom_host(db.getString(DBArchLoteConciCab.NOM_HOST));
    archloteconcicab.setNro_lote(db.getInteger(DBArchLoteConciCab.NRO_LOTE));
    archloteconcicab.setCant_transac(db.getInteger(DBArchLoteConciCab.CANT_TRANSAC));
    archloteconcicab.setNro_terminal(db.getString(DBArchLoteConciCab.NRO_TERMINAL));
    archloteconcicab.setAnio(db.getInteger(DBArchLoteConciCab.ANIO));
    archloteconcicab.setActivo(db.getInteger(DBArchLoteConciCab.ACTIVO));
    archloteconcicab.setMes(db.getInteger(DBArchLoteConciCab.MES));
    archloteconcicab.setArchivo(db.getString(DBArchLoteConciCab.ARCHIVO));
    archloteconcicab.setFec_creacion(db.getDate(DBArchLoteConciCab.FEC_CREACION));
    archloteconcicab.setDia(db.getInteger(DBArchLoteConciCab.DIA));
    archloteconcicab.setFec_importacion(db.getDate(DBArchLoteConciCab.FEC_IMPORTACION));
    archloteconcicab.setHora_importacion(db.getString(DBArchLoteConciCab.HORA_IMPORTACION));
    archloteconcicab.setFec_cierre(db.getDate(DBArchLoteConciCab.FEC_CIERRE));
    archloteconcicab.setEmpresaConciTar(EmpresaConciTar.findByOidProxy(db.getInteger(DBArchLoteConciCab.OID_EMPRESA), this.getSesion()));  

  }
}
