package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValCodigoValorCompoPresu extends Operation { 

  public ValCodigoValorCompoPresu() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
  	
  	CompoPresupuestario compoPresu = 
  		CompoPresupuestario.findByOid(mapaDatos.getInteger("oid_compo_presu"),this.getSesion());
  	
  	String codigo = mapaDatos.getString("codigo");
  	ValorCompoPresu valCompoPresu = compoPresu.getValorByCodigo(codigo);
  	if (valCompoPresu == null)
  		throw new ExceptionValidation(null,"Código "+codigo+" inexistente.");
  	
  	if (valCompoPresu.isActivo().booleanValue()==false)
  		throw new ExceptionValidation(null,"El componente con código "+codigo+" se encuentra inhabilitado.");

    IDataSet ds = getDSValidadorCompo();
    
    ds.append();
    ds.fieldValue("oid_val_compo_presu",valCompoPresu.getOIDInteger());
    ds.fieldValue("codigo",valCompoPresu.getCodigo());
    ds.fieldValue("descripcion",valCompoPresu.getDescripcion());
    
    writeCliente(ds);
  }

  private IDataSet getDSValidadorCompo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValCompoPresu");
    dataset.fieldDef(new Field("oid_val_compo_presu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }

}
