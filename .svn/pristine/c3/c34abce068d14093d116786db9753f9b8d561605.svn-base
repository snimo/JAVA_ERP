package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.AgrupadorTarjConci;
import com.srn.erp.conciTarjeta.bm.CabModeloLiq;
import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;
import com.srn.erp.conciTarjeta.da.DBTarjetaConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTarjetaConciTar extends FactoryObjetoLogico { 

  public FactoryTarjetaConciTar() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TarjetaConciTar tarjetaconcitar = (TarjetaConciTar) objLog;
    tarjetaconcitar.setOID(db.getInteger(DBTarjetaConciTar.OID_TAR_CONCI));
    tarjetaconcitar.setCodigo(db.getString(DBTarjetaConciTar.CODIGO));
    tarjetaconcitar.setDescripcion(db.getString(DBTarjetaConciTar.DESCRIPCION));
    tarjetaconcitar.setIdentif_tarj(db.getString(DBTarjetaConciTar.IDENTIF_TARJ));
    tarjetaconcitar.setActivo(db.getBoolean(DBTarjetaConciTar.ACTIVO));
    tarjetaconcitar.setCodigoPosNet(db.getString(DBTarjetaConciTar.CODIGO_POSNET)); 
    tarjetaconcitar.setAgrupador(AgrupadorTarjConci.findByOid(db.getInteger(DBTarjetaConciTar.OID_AGRUPADOR), this.getSesion()));
    tarjetaconcitar.setToleranciaDiasFecConci(db.getInteger(DBTarjetaConciTar.TOT_DIAS_FEC_CONCI));
    tarjetaconcitar.setTolDiasConciOK(db.getInteger(DBTarjetaConciTar.TOT_DIAS_CONCI_OK));
    tarjetaconcitar.setCtaTarjetaACobrar(db.getString(DBTarjetaConciTar.ACOB_CTA_TARJ));
    tarjetaconcitar.setCtaTarjetaACobrarC1(db.getString(DBTarjetaConciTar.ACOB_CTA_TARJ_C1));
    tarjetaconcitar.setCtaTarjetaACobrarC2(db.getString(DBTarjetaConciTar.ACOB_CTA_TARJ_C2));
    tarjetaconcitar.setIgnorarMovPOSNET(db.getBoolean(DBTarjetaConciTar.IGNORAR_MOV_POSNET));
    tarjetaconcitar.setLiquidacion(db.getString(DBTarjetaConciTar.LIQUIDACION));
    tarjetaconcitar.setCabModeloLiq(CabModeloLiq.findByOidProxy(db.getInteger(DBTarjetaConciTar.OID_MODELO_LIQ), this.getSesion()));
    
  }
}
