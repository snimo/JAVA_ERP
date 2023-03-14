package com.srn.erp.crm.bl.Factory;

import com.srn.erp.crm.bm.Campania;
import com.srn.erp.crm.bm.ClasificacionOportunidad;
import com.srn.erp.crm.bm.EstadoOportunidad;
import com.srn.erp.crm.bm.MotivoEstadoOportunidad;
import com.srn.erp.crm.bm.Oportunidad;
import com.srn.erp.crm.bm.SensacionCierreOportunidad;
import com.srn.erp.crm.da.DBOportunidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryOportunidad extends FactoryObjetoLogico { 

  public FactoryOportunidad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Oportunidad oportunidad = (Oportunidad) objLog;
    oportunidad.setOID(db.getInteger(DBOportunidad.OID_OPORTUNIDAD));
    oportunidad.setTema(db.getString(DBOportunidad.TEMA));
    oportunidad.setSujeto_potencial(Sujeto.findByOidProxy(db.getInteger(DBOportunidad.OID_SUJ_POT),getSesion()));
    oportunidad.setListaprecios(ListaPrecios.findByOidProxy(db.getInteger(DBOportunidad.OID_PRECIO_CAB),getSesion()));
    oportunidad.setTipo_resultado(db.getString(DBOportunidad.TIPO_RESULTADO));
    oportunidad.setMoneda(Moneda.findByOidProxy(db.getInteger(DBOportunidad.OID_MONEDA),getSesion()));
    oportunidad.setEstimacion_ingreso(db.getMoney(DBOportunidad.EST_ING));
    oportunidad.setEstimacion_egreso(db.getMoney(DBOportunidad.EST_EGR));
    oportunidad.setFecha_alta(db.getDate(DBOportunidad.FEC_ALTA));
    oportunidad.setUsuario_alta(Usuario.findByOidProxy(db.getInteger(DBOportunidad.OID_USU_ALTA),getSesion()));
    oportunidad.setProbabilidad(db.getInteger(DBOportunidad.PROBABILIDAD));
    oportunidad.setEst_fec_cierre(db.getDate(DBOportunidad.EST_FEC_CIERRE));
    oportunidad.setSensacion_cierre(SensacionCierreOportunidad.findByOidProxy(db.getInteger(DBOportunidad.OID_SENSA_CIERRE),getSesion()));
    oportunidad.setDescripcion(db.getString(DBOportunidad.DESCRIPCION));
    oportunidad.setUsuario_owner(Usuario.findByOidProxy(db.getInteger(DBOportunidad.OID_USU_OWNER),getSesion()));
    oportunidad.setEstado_oportunidad(EstadoOportunidad.findByOidProxy(db.getInteger(DBOportunidad.OID_ESTADO_OPOR),getSesion()));
    oportunidad.setCampania(Campania.findByOidProxy(db.getInteger(DBOportunidad.OID_CAMPANIA),getSesion()));
    oportunidad.setSujeto_generador(Sujeto.findByOidProxy(db.getInteger(DBOportunidad.OID_SUJ_GEN_OPOR),getSesion()));
    oportunidad.setVendedor_tecnico(Vendedor.findByOidProxy(db.getInteger(DBOportunidad.OID_VEND_TEC),getSesion()));
    oportunidad.setVendedor_comercial(Vendedor.findByOidProxy(db.getInteger(DBOportunidad.OID_VEND_COMER),getSesion()));
    oportunidad.setMotivo(MotivoEstadoOportunidad.findByOidProxy(db.getInteger(DBOportunidad.OID_EST_MOT_OPOR),getSesion()));
    oportunidad.setClasificacion(ClasificacionOportunidad.findByOidProxy(db.getInteger(DBOportunidad.OID_CLASIF_OPOR),getSesion()));
    oportunidad.setActivo(db.getBoolean(DBOportunidad.ACTIVO));
    oportunidad.setCodigo(db.getString(DBOportunidad.CODIGO));

  }
}
