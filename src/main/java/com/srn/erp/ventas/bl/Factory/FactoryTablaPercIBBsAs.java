package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.TablaPercIBBsAs;
import com.srn.erp.ventas.da.DBTablaPercIBBsAs;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTablaPercIBBsAs extends FactoryObjetoLogico { 

  public FactoryTablaPercIBBsAs() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TablaPercIBBsAs tablapercibbsas = (TablaPercIBBsAs) objLog;
    tablapercibbsas.setOID(db.getInteger(DBTablaPercIBBsAs.OID_PERC_IB));
    tablapercibbsas.setFec_public(db.getDate(DBTablaPercIBBsAs.FEC_PUBLIC));
    tablapercibbsas.setFec_vig_desde(db.getDate(DBTablaPercIBBsAs.FEC_VIG_DESDE));
    tablapercibbsas.setFec_vig_hasta(db.getDate(DBTablaPercIBBsAs.FEC_VIG_HASTA));
    tablapercibbsas.setCuit(db.getString(DBTablaPercIBBsAs.CUIT));
    tablapercibbsas.setTipo(db.getString(DBTablaPercIBBsAs.TIPO));
    tablapercibbsas.setMarca_ab_sujeto(db.getString(DBTablaPercIBBsAs.MARCA_AB_SUJETO));
    tablapercibbsas.setMarca_cambio_ali(db.getString(DBTablaPercIBBsAs.MARCA_CAMBIO_ALI));
    tablapercibbsas.setAli_percepcion(db.getPorcentaje(DBTablaPercIBBsAs.ALI_PERCEPCION));
    tablapercibbsas.setAli_retencion(db.getPorcentaje(DBTablaPercIBBsAs.ALI_RETENCION));
    tablapercibbsas.setNro_gr_ret(db.getInteger(DBTablaPercIBBsAs.NRO_GR_RET));
    tablapercibbsas.setNro_gr_per(db.getInteger(DBTablaPercIBBsAs.NRO_GR_PER));

  }
}
