package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerSancionesRRHH extends Operation { 

  public TraerSancionesRRHH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    SancionesRRHH sancionesrrhh = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       sancionesrrhh = SancionesRRHH.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       sancionesrrhh = SancionesRRHH.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetSancionesRRHH = getDataSetSancionesRRHH();
    if (sancionesrrhh != null) { 
        cargarRegistroSancionesRRHH(datasetSancionesRRHH, 
                         sancionesrrhh.getOIDInteger(),
                         sancionesrrhh.getCodigo(),
                         sancionesrrhh.getDescripcion(),
                         sancionesrrhh.isActivo(),
                         sancionesrrhh.isExcluirEnPlanifRotas()
                         );
    }
    writeCliente(datasetSancionesRRHH);
  }

  private IDataSet getDataSetSancionesRRHH() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TSancionesRRHH");
    dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("exc_planif_rotas", Field.BOOLEAN, 0));
    
    return dataset;
  }

  private void cargarRegistroSancionesRRHH(IDataSet dataset, 
                         Integer oid_mot_sancion,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         Boolean excPlanifRotas) {
    dataset.append(); 
    dataset.fieldValue("oid_mot_sancion", oid_mot_sancion);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("exc_planif_rotas",excPlanifRotas);
  }
}
