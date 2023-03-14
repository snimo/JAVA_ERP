package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.Campania;
import com.srn.erp.crm.bm.ClasificacionOportunidad;
import com.srn.erp.crm.bm.EstadoOportunidad;
import com.srn.erp.crm.bm.MotivoEstadoOportunidad;
import com.srn.erp.crm.bm.Oportunidad;
import com.srn.erp.crm.bm.SensacionCierreOportunidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveOportunidad extends Operation { 

  public SaveOportunidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TOportunidad"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Oportunidad oportunidad = Oportunidad.findByOid(dataset.getInteger("oid_oportunidad"),getSesion());
        oportunidad.setOID(dataset.getInteger("oid_oportunidad"));
        oportunidad.setTema(dataset.getString("tema"));
        oportunidad.setSujeto_potencial(Sujeto.findByOid(dataset.getInteger("oid_suj_pot"),getSesion()));
        oportunidad.setListaprecios(ListaPrecios.findByOid(dataset.getInteger("oid_precio_cab"),getSesion()));
        oportunidad.setTipo_resultado(dataset.getString("tipo_resultado"));
        oportunidad.setMoneda(Moneda.findByOid(dataset.getInteger("oid_moneda"),getSesion()));
        oportunidad.setEstimacion_ingreso(dataset.getMoney("est_ing"));
        oportunidad.setEstimacion_egreso(dataset.getMoney("est_egr"));
        oportunidad.setProbabilidad(dataset.getInteger("probabilidad"));
        oportunidad.setEst_fec_cierre(dataset.getDate("est_fec_cierre"));
        oportunidad.setSensacion_cierre(SensacionCierreOportunidad.findByOidProxy(dataset.getInteger("oid_sensa_cierre"),getSesion()));
        oportunidad.setDescripcion(dataset.getString("descripcion"));
        oportunidad.setUsuario_owner(Usuario.findByOidProxy(dataset.getInteger("oid_usu_owner"),getSesion()));
        oportunidad.setEstado_oportunidad(EstadoOportunidad.findByOidProxy(dataset.getInteger("oid_estado_opor"),getSesion()));
        oportunidad.setCampania(Campania.findByOidProxy(dataset.getInteger("oid_campania"),getSesion()));
        oportunidad.setSujeto_generador(Sujeto.findByOidProxy(dataset.getInteger("oid_suj_gen_opor"),getSesion()));
        oportunidad.setVendedor_tecnico(Vendedor.findByOidProxy(dataset.getInteger("oid_vend_tec"),getSesion()));
        oportunidad.setVendedor_comercial(Vendedor.findByOidProxy(dataset.getInteger("oid_vend_comer"),getSesion()));
        oportunidad.setMotivo(MotivoEstadoOportunidad.findByOidProxy(dataset.getInteger("oid_est_mot_opor"),getSesion()));
        oportunidad.setClasificacion(ClasificacionOportunidad.findByOidProxy(dataset.getInteger("oid_clasif_opor"),getSesion()));
        oportunidad.setActivo(dataset.getBoolean("activo"));
        addTransaccion(oportunidad);
        dataset.next();
    }
  }
  
}
