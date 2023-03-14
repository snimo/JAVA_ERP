package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.EmpresaCIP;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.GrupoVisita;
import com.srn.erp.cip.bm.MotivoVisita;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.cip.bm.ZonaCIP;
import com.srn.erp.cip.da.DBVisita;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.TipoDocumento;
import com.srn.erp.ventas.da.DBSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryVisita extends FactoryObjetoLogico { 

  public FactoryVisita() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {

	Visita visita = (Visita) objLog;
    visita.setOID(db.getInteger(DBVisita.OID_VISITA));
    visita.setApeyNom(db.getString(DBVisita.APE_Y_NOM));
    visita.setActivo(db.getBoolean(DBVisita.ACTIVO));
    visita.setTipoDocumento(TipoDocumento.findByOidProxy(db.getInteger(DBVisita.OID_TIPO_DOCUMENTO), this.getSesion()));
    visita.setNroDocumento(db.getString(DBVisita.NRO_DOCUMENTO));
    visita.setGrupoPuertaIngreso(GrupoPuerta.findByOidProxy(db.getInteger(DBVisita.OID_GRUPO_PUE_ING), this.getSesion()));
    visita.setGrupoPuertaEgreso(GrupoPuerta.findByOidProxy(db.getInteger(DBVisita.OID_GRUPO_PUE_EGR), this.getSesion()));
    
    visita.setEmpresaCIP(EmpresaCIP.findByOidProxy(db.getInteger(DBVisita.EMPRESA_CIP), this.getSesion()));
    visita.setZonaActual(ZonaCIP.findByOidProxy(db.getInteger(DBVisita.OID_ZONA_ACTUAL), this.getSesion()));
    
    visita.setVisitaA(Legajo.findByOidProxy(db.getInteger(DBVisita.OID_VISITA_A), this.getSesion()));
    visita.setAutoriza(Legajo.findByOidProxy(db.getInteger(DBVisita.OID_AUTORIZA), this.getSesion()));
    
    visita.setSentido(db.getString(DBVisita.SENTIDO));
    visita.setFecHorUltMov(db.getDateTime(DBVisita.FEC_HOR_ULT_MOV));
    visita.setControlAntiPassBack(db.getBoolean(DBVisita.CONTROL_ANTI_PASSBACK));
    visita.setIgnorarProxAntiPassBack(db.getBoolean(DBVisita.IGNORAR_PROX_ANTIPASS));
    visita.setPermisoSemanal(PermisoSemanalCIP.findByOidProxy(db.getInteger(DBVisita.OID_PLANIF_SEM), this.getSesion()));
    visita.setGrupoVisita(GrupoVisita.findByOidProxy(db.getInteger(DBVisita.OID_GRUPO_VISITA), this.getSesion()));
    
    visita.setAplicVigencia(db.getBoolean(DBVisita.APLIC_VIG));
    visita.setFecVigenciaDesde(db.getDate(DBVisita.FEC_DESDE_VIG));
    visita.setFecVigenciaHasta(db.getDate(DBVisita.FEC_HASTA_VIG));
    visita.setCategAcceso(CategAccesoCIP.findByOidProxy(db.getInteger(DBVisita.OID_CATEG_ACC_INT), this.getSesion()));
    visita.setMotivoVisita(MotivoVisita.findByOidProxy(db.getInteger(DBVisita.OID_MOT_VISITA), this.getSesion()));
    visita.setLibAccesoAlPredio(db.getBoolean(DBVisita.LIB_ACC_AL_PREDIO));
    
    visita.addOidValorClasif(new Integer(1),db.getInteger(DBSujeto.OID_CLASIF_01));
    visita.addOidValorClasif(new Integer(2),db.getInteger(DBSujeto.OID_CLASIF_02));
    visita.addOidValorClasif(new Integer(3),db.getInteger(DBSujeto.OID_CLASIF_03));
    visita.addOidValorClasif(new Integer(4),db.getInteger(DBSujeto.OID_CLASIF_04));
    visita.addOidValorClasif(new Integer(5),db.getInteger(DBSujeto.OID_CLASIF_05));
    visita.addOidValorClasif(new Integer(6),db.getInteger(DBSujeto.OID_CLASIF_06));
    visita.addOidValorClasif(new Integer(7),db.getInteger(DBSujeto.OID_CLASIF_07));
    visita.addOidValorClasif(new Integer(8),db.getInteger(DBSujeto.OID_CLASIF_08));
    visita.addOidValorClasif(new Integer(9),db.getInteger(DBSujeto.OID_CLASIF_09));
    visita.addOidValorClasif(new Integer(10),db.getInteger(DBSujeto.OID_CLASIF_10));
    visita.addOidValorClasif(new Integer(11),db.getInteger(DBSujeto.OID_CLASIF_11));
    visita.addOidValorClasif(new Integer(12),db.getInteger(DBSujeto.OID_CLASIF_12));
    visita.addOidValorClasif(new Integer(13),db.getInteger(DBSujeto.OID_CLASIF_13));
    visita.addOidValorClasif(new Integer(14),db.getInteger(DBSujeto.OID_CLASIF_14));
    visita.addOidValorClasif(new Integer(15),db.getInteger(DBSujeto.OID_CLASIF_15));
    visita.addOidValorClasif(new Integer(16),db.getInteger(DBSujeto.OID_CLASIF_16));
    visita.addOidValorClasif(new Integer(17),db.getInteger(DBSujeto.OID_CLASIF_17));
    visita.addOidValorClasif(new Integer(18),db.getInteger(DBSujeto.OID_CLASIF_18));
    visita.addOidValorClasif(new Integer(19),db.getInteger(DBSujeto.OID_CLASIF_19));
    visita.addOidValorClasif(new Integer(20),db.getInteger(DBSujeto.OID_CLASIF_20));
    
  }
}
