package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.CabConciAutomatica;
import com.srn.erp.conciTarjeta.bm.CabTarConciEnt;
import com.srn.erp.conciTarjeta.bm.DetTarConciEnt;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.da.DBDetTarConciEnt;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryDetTarConciEnt extends FactoryObjetoLogico { 

  public FactoryDetTarConciEnt() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DetTarConciEnt dettarconcient = (DetTarConciEnt) objLog;
    dettarconcient.setOID(db.getInteger(DBDetTarConciEnt.OID_TAR_INFO_DET));
    dettarconcient.setTar_info_cab(CabTarConciEnt.findByOidProxy(db.getInteger(DBDetTarConciEnt.OID_TAR_INFO_CAB),getSesion()));
    dettarconcient.setTipo_operacion(db.getString(DBDetTarConciEnt.TIPO_OPERACION));
    dettarconcient.setFec_present(db.getDate(DBDetTarConciEnt.FEC_PRESENT));
    dettarconcient.setLote(db.getInteger(DBDetTarConciEnt.LOTE));
    dettarconcient.setFec_pago(db.getDate(DBDetTarConciEnt.FEC_PAGO));
    dettarconcient.setDescripcion(db.getString(DBDetTarConciEnt.DESCRIPCION));
    dettarconcient.setEmpresa(EmpresaConciTar.findByOidProxy(db.getInteger(DBDetTarConciEnt.OID_EMPRESA),getSesion()));
    dettarconcient.setNro_comprobante(db.getInteger(DBDetTarConciEnt.NRO_COMPROBANTE));
    dettarconcient.setFec_origen(db.getDate(DBDetTarConciEnt.FEC_ORIGEN));
    dettarconcient.setPlan(db.getString(DBDetTarConciEnt.PLAN));
    dettarconcient.setNro_tarjeta(db.getInteger(DBDetTarConciEnt.NRO_TARJETA));
    dettarconcient.setCuota(db.getString(DBDetTarConciEnt.CUOTA));
    dettarconcient.setMoneda(db.getString(DBDetTarConciEnt.MONEDA));
    dettarconcient.setComercio(db.getString(DBDetTarConciEnt.COMERCIO));
    dettarconcient.setImporte(db.getMoney(DBDetTarConciEnt.IMPORTE));
    dettarconcient.setNro_cupon(db.getInteger(DBDetTarConciEnt.NRO_CUPON));
    dettarconcient.setActivo(db.getBoolean(DBDetTarConciEnt.ACTIVO));
    dettarconcient.setTipoTarjeta(db.getString(DBDetTarConciEnt.TIPO_TARJETA));
    dettarconcient.setConciliado(db.getBoolean(DBDetTarConciEnt.CONCILIADO));
    dettarconcient.setFecConciliado(db.getDate(DBDetTarConciEnt.FEC_CONCILIADO));
    dettarconcient.setTarjeta(db.getString(DBDetTarConciEnt.TARJETA));
    dettarconcient.setPreConciliado(db.getBoolean(DBDetTarConciEnt.PRECONCI));
    dettarconcient.setFecPreconci(db.getDate(DBDetTarConciEnt.FEC_PRECONCI));
    dettarconcient.setUsuPreConci(Usuario.findByOidProxy(db.getInteger(DBDetTarConciEnt.USU_PRECONCI),getSesion()));
    dettarconcient.setNroConciliacion(db.getInteger(DBDetTarConciEnt.NRO_CONCILIACION));
    dettarconcient.setMarcarPreconci(db.getBoolean(DBDetTarConciEnt.MARCAR_PRECONCI));
    dettarconcient.setUsuarioMarcaPreconci(Usuario.findByOidProxy(db.getInteger(DBDetTarConciEnt.OID_USU_MAR_PRE), this.getSesion()));
    dettarconcient.setCabConciAut(CabConciAutomatica.findByOidProxy(db.getInteger(DBDetTarConciEnt.OID_CAB_CONCI_AUT),getSesion()));
    dettarconcient.setPreconciDudoso(db.getBoolean(DBDetTarConciEnt.PRECONCI_DUDOSO));
    dettarconcient.setNomArchivo(db.getString(DBDetTarConciEnt.NOM_ARCHIVO));
    dettarconcient.setAltaManual(db.getBoolean(DBDetTarConciEnt.ALTA_MANUAL));
    
  }
}
