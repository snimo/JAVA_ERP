package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.GrupoTarjeta;
import com.srn.erp.cip.bm.MotivoBajaTarjeta;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.cip.da.DBTarjetaCIP;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTarjetaCIP extends FactoryObjetoLogico { 

  public FactoryTarjetaCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TarjetaCIP tarjetacip = (TarjetaCIP) objLog;
    tarjetacip.setOID(db.getInteger(DBTarjetaCIP.OID_TARJETA));
    tarjetacip.setTipo_tarjeta(db.getString(DBTarjetaCIP.TIPO_TARJETA));
    tarjetacip.setNro_tarjeta(db.getString(DBTarjetaCIP.NRO_TARJETA));
    tarjetacip.setGrupo_tarjeta(GrupoTarjeta.findByOidProxy(db.getInteger(DBTarjetaCIP.OID_GRUPO_TAR),getSesion()));
    tarjetacip.setTiene_vig(db.getBoolean(DBTarjetaCIP.TIENE_VIG));
    tarjetacip.setVig_desde(db.getDate(DBTarjetaCIP.VIG_DESDE));
    tarjetacip.setVig_hasta(db.getDate(DBTarjetaCIP.VIG_HASTA));
    tarjetacip.setHora_desde(db.getString(DBTarjetaCIP.HORA_DESDE));
    tarjetacip.setHora_hasta(db.getString(DBTarjetaCIP.HORA_HASTA));
    tarjetacip.setEstado_tarjeta(db.getString(DBTarjetaCIP.ESTADO_TARJETA));
    tarjetacip.setActivo(db.getBoolean(DBTarjetaCIP.ACTIVO));
    tarjetacip.setMotivo_baja_tarjeta(MotivoBajaTarjeta.findByOidProxy(db.getInteger(DBTarjetaCIP.OID_MOT_BAJ_TAR),getSesion()));
    tarjetacip.setLegajo(Legajo.findByOidProxy(db.getInteger(DBTarjetaCIP.OID_LEGAJO),getSesion()));
    tarjetacip.setVisita(Visita.findByOidProxy(db.getInteger(DBTarjetaCIP.OID_VISITA),getSesion()));
    tarjetacip.setCliente(Sujeto.findByOidProxy(db.getInteger(DBTarjetaCIP.OID_CLIENTE),getSesion()));
    tarjetacip.setFec_asig(db.getDate(DBTarjetaCIP.FEC_ASIG));
    tarjetacip.setHora_asig(db.getString(DBTarjetaCIP.HORA_ASIG));
    tarjetacip.setIsParaVisita(db.getBoolean(DBTarjetaCIP.VISITA));
    tarjetacip.setGrupoPueAccVisita(GrupoPuerta.findByOidProxy(db.getInteger(DBTarjetaCIP.OID_GRU_P_ING_VI), this.getSesion()));
    tarjetacip.setGrupoPueEgrVisita(GrupoPuerta.findByOidProxy(db.getInteger(DBTarjetaCIP.OID_GRU_P_EGR_VI), this.getSesion()));
    tarjetacip.setCategAccesoVisita(CategAccesoCIP.findByOidProxy(db.getInteger(DBTarjetaCIP.OID_CATEG_ACC_VI), this.getSesion()));
    tarjetacip.setToleranciaIngVisMin(db.getInteger(DBTarjetaCIP.TOLE_ING_VIS_MIN));
    tarjetacip.setTipoVisita(db.getString(DBTarjetaCIP.TIPO_VISITA));
    tarjetacip.setPermisoSemanal(PermisoSemanalCIP.findByOidProxy(db.getInteger(DBTarjetaCIP.OID_PLANIF_SEM_VIS), this.getSesion()));
    tarjetacip.setControlarAntiPassBack(db.getBoolean(DBTarjetaCIP.ANTI_PASSBACK));
  }
}
