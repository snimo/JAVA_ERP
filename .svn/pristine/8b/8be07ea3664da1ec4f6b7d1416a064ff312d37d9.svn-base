package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.contabilidad.bm.ComproSubReparto;
import com.srn.erp.contabilidad.bm.ComproSubRepartoDet;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.FaseSubReparto;
import com.srn.erp.contabilidad.da.DBComproSubRepartoDet;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproSubRepartoDet extends FactoryObjetoLogico { 

  public FactoryComproSubRepartoDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproSubRepartoDet comprosubrepartodet = (ComproSubRepartoDet) objLog;
    comprosubrepartodet.setOID(db.getInteger(DBComproSubRepartoDet.OID_SUB_REP_DET));
    comprosubrepartodet.setCompro_subreparto(ComproSubReparto.findByOidProxy(db.getInteger(DBComproSubRepartoDet.OID_COMPRO_SUB),getSesion()));
    comprosubrepartodet.setCuenta_imputable(CuentaImputable.findByOidProxy(db.getInteger(DBComproSubRepartoDet.OID_AI),getSesion()));
    comprosubrepartodet.setSigno(db.getInteger(DBComproSubRepartoDet.SIGNO));
    comprosubrepartodet.setImporteLocAju(db.getDouble(DBComproSubRepartoDet.IMPORTE_LOC_AJU));
    comprosubrepartodet.setImporteLocHist(db.getDouble(DBComproSubRepartoDet.IMPORTE_LOC_HIST));
    comprosubrepartodet.setImpoMonExt1(db.getDouble(DBComproSubRepartoDet.IMPORTE_MON_EXT_1));
    comprosubrepartodet.setImpoMonExt2(db.getDouble(DBComproSubRepartoDet.IMPORTE_MON_EXT_2));
    
    comprosubrepartodet.setActivo(db.getBoolean(DBComproSubRepartoDet.ACTIVO));
    comprosubrepartodet.setFaseSubReparto(FaseSubReparto.findByOidProxy(db.getInteger(DBComproSubRepartoDet.OID_FASE),getSesion()));
    comprosubrepartodet.setMonedaOri(Moneda.findByOidProxy(db.getInteger(DBComproSubRepartoDet.OID_MONEDA_ORI),getSesion()));
    comprosubrepartodet.setImporteOri(db.getDouble(DBComproSubRepartoDet.IMPORTE_ORI));
    comprosubrepartodet.setValorCotizMonori(db.getCotizacion(DBComproSubRepartoDet.COTIZ_MON_ORI));
    comprosubrepartodet.setValorCotizMonExt1(db.getCotizacion(DBComproSubRepartoDet.COTIZ_MON_EXT_1));
    comprosubrepartodet.setValorCotizMonExt2(db.getCotizacion(DBComproSubRepartoDet.COTIZ_MON_EXT_2));
    
    comprosubrepartodet.setComproContaDet(ComproContaDet.findByOidProxy(db.getInteger(DBComproSubRepartoDet.OID_CONTA_DET),getSesion()));
    comprosubrepartodet.setProporcion(db.getDouble(DBComproSubRepartoDet.PROPORCION));
    comprosubrepartodet.setComponente(Componente.findByOidProxy(db.getInteger(DBComproSubRepartoDet.OID_COMPO),getSesion()));
    if (comprosubrepartodet.getComponente()!=null)
    	comprosubrepartodet.setValorCompo(comprosubrepartodet.getComponente().getValorCompo(db.getInteger(DBComproSubRepartoDet.OID_VAL_COMPO)));
    
  }
}
