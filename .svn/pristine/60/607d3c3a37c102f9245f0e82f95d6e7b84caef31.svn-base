package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerObsCodifEvalRH extends Operation { 

  public TraerObsCodifEvalRH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ObsCodifEvalRH obscodifevalrh = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       obscodifevalrh = ObsCodifEvalRH.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       obscodifevalrh = ObsCodifEvalRH.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetObsCodifEvalRH = getDataSetObsCodifEvalRH();
    if (obscodifevalrh != null) { 
        cargarRegistroObsCodifEvalRH(datasetObsCodifEvalRH,obscodifevalrh); 
    }
    writeCliente(datasetObsCodifEvalRH);
  }

  private IDataSet getDataSetObsCodifEvalRH() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TObsCodifEvalRH");
    dataset.fieldDef(new Field("oid_obs_codif", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 4000)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroObsCodifEvalRH(IDataSet dataset, 
                         ObsCodifEvalRH aObsCodifEvalRH) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_obs_codif", aObsCodifEvalRH.getOID());
    dataset.fieldValue("codigo", aObsCodifEvalRH.getCodigo());
    dataset.fieldValue("descripcion", aObsCodifEvalRH.getDescripcion());
    dataset.fieldValue("activo", aObsCodifEvalRH.isActivo());
  }
}
