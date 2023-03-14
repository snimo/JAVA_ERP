package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMaqPuertasVisita extends Operation { 

  public SaveMaqPuertasVisita() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMaqPuertasVisita"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MaqPuertasVisita maqpuertasvisita = MaqPuertasVisita.findByOid(dataset.getInteger("oid_maq_pue_vis"),getSesion());
        maqpuertasvisita.setOID(dataset.getInteger("oid_maq_pue_vis"));
        maqpuertasvisita.setMaquina(dataset.getString("maquina"));
        maqpuertasvisita.setPuerta_entrada(Puerta.findByOidProxy(dataset.getInteger("oid_puerta_ent"),this.getSesion()));
        maqpuertasvisita.setPuerta_salida(Puerta.findByOidProxy(dataset.getInteger("oid_puerta_sal"),this.getSesion()));
        maqpuertasvisita.setActivo(dataset.getBoolean("activo"));
        maqpuertasvisita.setGrupoPuerta(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_grupo_puerta"),this.getSesion()));
        addTransaccion(maqpuertasvisita);
        dataset.next();
    }
  }
  
}
