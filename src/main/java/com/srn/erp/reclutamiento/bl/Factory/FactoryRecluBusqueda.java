package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluConvenio;
import com.srn.erp.reclutamiento.bm.RecluEstAprobBusq;
import com.srn.erp.reclutamiento.bm.RecluMotiEstBusq;
import com.srn.erp.reclutamiento.bm.RecluMotivoBusqueda;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluPuesto;
import com.srn.erp.reclutamiento.bm.RecluSectores;
import com.srn.erp.reclutamiento.bm.RecluSelector;
import com.srn.erp.reclutamiento.bm.RecluTipoContrato;
import com.srn.erp.reclutamiento.da.DBRecluBusqueda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluBusqueda extends FactoryObjetoLogico { 

  public FactoryRecluBusqueda() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluBusqueda reclubusqueda = (RecluBusqueda) objLog;
    reclubusqueda.setOID(db.getInteger(DBRecluBusqueda.OID_BUSQUEDA_ACT));
    reclubusqueda.setPuesto(RecluPuesto.findByOidProxy(db.getInteger(DBRecluBusqueda.OID_PUESTO_BUSQUEDA),getSesion()));
    reclubusqueda.setFec_inicio_busq(db.getDate(DBRecluBusqueda.FEC_INICIO_BUSQ));
    reclubusqueda.setCant_vacantes(db.getInteger(DBRecluBusqueda.CANT_VACANTES));
    reclubusqueda.setMotivo_busq(RecluMotivoBusqueda.findByOidProxy(db.getInteger(DBRecluBusqueda.OID_MOTIVO_BUSQ),getSesion()));
    reclubusqueda.setObservaciones(db.getString(DBRecluBusqueda.OBSERVACIONES));
    reclubusqueda.setOperacion(RecluOperacion.findByOidProxy(db.getInteger(DBRecluBusqueda.OID_OPERACION),getSesion()));
    reclubusqueda.setSueldo_buto(db.getMoney(DBRecluBusqueda.SUELDO_BRUTO));
    reclubusqueda.setEstado_busqueda(db.getString(DBRecluBusqueda.ESTADO_BUSQUEDA));
    reclubusqueda.setSexo(db.getString(DBRecluBusqueda.SEXO));
    reclubusqueda.setTipo_contrato(RecluTipoContrato.findByOidProxy(db.getInteger(DBRecluBusqueda.OID_TIPO_CONTRATO),getSesion()));
    reclubusqueda.setSelector(RecluSelector.findByOidProxy(db.getInteger(DBRecluBusqueda.OID_SELECTOR),getSesion()));
    reclubusqueda.setEst_aprob_busq(RecluEstAprobBusq.findByOidProxy(db.getInteger(DBRecluBusqueda.OID_EST_APROB_BUSQ),getSesion()));
    reclubusqueda.setSector(RecluSectores.findByOidProxy(db.getInteger(DBRecluBusqueda.OID_SECTOR),getSesion()));
    reclubusqueda.setFec_est_aprob(db.getDate(DBRecluBusqueda.FEC_EST_APROB));
    reclubusqueda.setConvenio(RecluConvenio.findByOidProxy(db.getInteger(DBRecluBusqueda.OID_CONVENIO),getSesion()));
    reclubusqueda.setFec_alta(db.getDate(DBRecluBusqueda.FEC_ALTA));
    reclubusqueda.setActivo(db.getBoolean(DBRecluBusqueda.ACTIVO));
    reclubusqueda.setMotivoEstado(RecluMotiEstBusq.findByOidProxy(db.getInteger(DBRecluBusqueda.OID_MOT_EST_BUSQ),getSesion()));
    reclubusqueda.setFechaCierre(db.getDate(DBRecluBusqueda.FEC_CIERRE));

  }
}
