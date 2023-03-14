package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveDispMovilExc extends Operation { 

  public SaveDispMovilExc() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TDispMovilExc"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        DispMovilExc dispmovilexc = DispMovilExc.findByOid(dataset.getInteger("oid_disp_movil"),getSesion());
        dispmovilexc.setOID(dataset.getInteger("oid_disp_movil"));
        dispmovilexc.setCodigo(dataset.getString("codigo"));
        dispmovilexc.setDescripcion(dataset.getString("descripcion"));
        dispmovilexc.setGrupo_importacion(GrupoImportacionExcluido.findByOidProxy(dataset.getInteger("oid_grupo_imp_exc"),this.getSesion()));
        dispmovilexc.setFec_hor_ult_sinc_ol(dataset.getString("fec_hor_ult_sinc_ol"));
        dispmovilexc.setForzar_sinc_all(dataset.getBoolean("forzar_sinc_all"));
        dispmovilexc.setUlt_nro_lote_inf(dataset.getInteger("ult_nro_lote_inf"));
        dispmovilexc.setActivo(dataset.getBoolean("activo"));
        dispmovilexc.setForzarSiempresSinc(dataset.getBoolean("forzar_siempre_sinc"));
        
        addTransaccion(dispmovilexc);
        dataset.next();
    }
  }
  
}
