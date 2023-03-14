package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.VarEscenarioCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerVariableEscenario extends Operation { 

  public TraerVariableEscenario() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    VarEscenarioCab varEsceCab = null;
    
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       varEsceCab = VarEscenarioCab.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       varEsceCab = VarEscenarioCab.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetVarEscenario = this.getdsVarEscenario();
    cargarRegistro(datasetVarEscenario,varEsceCab);
    writeCliente(datasetVarEscenario);
  }

  private IDataSet getdsVarEscenario() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TVarEsce");
    dataset.fieldDef(new Field("oid_var_esc_cab", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_tipo_peri", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                              VarEscenarioCab varEsceCab) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_var_esc_cab", varEsceCab.getOIDInteger());
    dataset.fieldValue("codigo", varEsceCab.getCodigo());
    dataset.fieldValue("descripcion", varEsceCab.getDescripcion());
    if (varEsceCab.getTipo_periodo()!=null)
    	dataset.fieldValue("oid_tipo_peri", varEsceCab.getTipo_periodo().getOIDInteger());
    else
    	dataset.fieldValue("oid_tipo_peri", 0);
    dataset.fieldValue("activo", varEsceCab.isActivo());
  }
}

