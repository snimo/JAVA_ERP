package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import com.srn.erp.mensajero.bm.GrupoMaquina;
import com.srn.erp.mensajero.bm.GrupoUsuMens;
import com.srn.erp.mensajero.bm.Ring;

import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveZonaCIP extends Operation { 

  public SaveZonaCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TZonaCIP"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ZonaCIP zonacip = ZonaCIP.findByOid(dataset.getInteger("oid_zona"),getSesion());
        zonacip.setOID(dataset.getInteger("oid_zona"));
        zonacip.setCodigo(dataset.getString("codigo"));
        zonacip.setActivo(dataset.getBoolean("activo"));
        zonacip.setColor(dataset.getString("color"));
        zonacip.setDescripcion(dataset.getString("descripcion"));
        zonacip.setOid_tipo_zona(TipoZona.findByOidProxy(dataset.getInteger("oid_tipo_zona"),this.getSesion()));
        zonacip.setCapacidad_max(dataset.getInteger("capacidad_max"));
        zonacip.setAlarma_de_cap(dataset.getInteger("alarma_de_cap"));
        zonacip.setBloquear_exc_cap(dataset.getBoolean("bloquear_exc_cap"));
        zonacip.setEstado_zona(dataset.getString("estado_zona"));
        zonacip.setUbicacion(dataset.getString("ubicacion"));
        zonacip.setGrupo_usu_alar(GrupoUsuMens.findByOidProxy(dataset.getInteger("oid_grupo_usu_alar"),this.getSesion()));
        zonacip.setGrupo_maq_alar(GrupoMaquina.findByOidProxy(dataset.getInteger("oid_grupo_maq_alar"),this.getSesion()));
        zonacip.setMens_alar_cap_max(dataset.getString("mens_alar_cap_max"));
        zonacip.setRing_max_cap(Ring.findByOidProxy(dataset.getInteger("oid_ring_max_cap"),this.getSesion()));
        zonacip.setEsExterna(dataset.getBoolean("es_externa"));
        zonacip.setControlaAntiEnt(dataset.getBoolean("controla_anti_ent"));
        zonacip.setControlaAntiSal(dataset.getBoolean("controla_anti_sal"));
        addTransaccion(zonacip);
        dataset.next();
    }
  }
  
}
