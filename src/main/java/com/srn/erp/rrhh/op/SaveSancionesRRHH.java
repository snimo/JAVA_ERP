package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveSancionesRRHH extends Operation { 

  public SaveSancionesRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TSancionesRRHH"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        SancionesRRHH sancionesrrhh = SancionesRRHH.findByOid(dataset.getInteger("oid_mot_sancion"),getSesion());
        sancionesrrhh.setOID(dataset.getInteger("oid_mot_sancion"));
        sancionesrrhh.setCodigo(dataset.getString("codigo"));
        sancionesrrhh.setDescripcion(dataset.getString("descripcion"));
        sancionesrrhh.setActivo(dataset.getBoolean("activo"));
        sancionesrrhh.setExcluirEnPlanifRotas(dataset.getBoolean("exc_planif_rotas"));
        
        addTransaccion(sancionesrrhh);
        dataset.next();
    }
  }
  
}
