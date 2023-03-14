package com.srn.erp.presupuesto.op;


import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.TipoPeriodo;
import com.srn.erp.presupuesto.bm.VarEscenarioCab;
import com.srn.erp.presupuesto.bm.VarEscenarioDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveDefVarEscenario extends Operation { 

  public SaveDefVarEscenario() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TVarEscenarioCab"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        VarEscenarioCab varescenariocab = VarEscenarioCab.findByOid(dataset.getInteger("oid_var_esc_cab"),getSesion());
        varescenariocab.setCodigo(dataset.getString("codigo"));
        varescenariocab.setDescripcion(dataset.getString("descripcion"));
        varescenariocab.setTipo_periodo(TipoPeriodo.findByOidProxy(dataset.getInteger("oid_tipo_peri"),this.getSesion()));
        varescenariocab.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsVarEscenarioDet = dataset.getDataSet("TVarEscenarioDet");
        dsVarEscenarioDet.first();
        while (!dsVarEscenarioDet.EOF()) {
        	VarEscenarioDet varEscenarioDet = VarEscenarioDet.findByOid(dsVarEscenarioDet.getInteger("oid_var_esc_det"),getSesion());
        	varEscenarioDet.setVar_escenario_cab(varescenariocab);
        	varEscenarioDet.setSecu(dsVarEscenarioDet.getInteger("secu"));
        	varEscenarioDet.setCompo_presu(CompoPresupuestario.findByOidProxy(dsVarEscenarioDet.getInteger("oid_compo_presu"),this.getSesion()));
        	varEscenarioDet.setActivo(dsVarEscenarioDet.getBoolean("activo"));
        	dsVarEscenarioDet.next();
        	varescenariocab.addVariableEscenarioDet(varEscenarioDet); 
        }
        
        
        addTransaccion(varescenariocab);
        dataset.next();
    }
  }
  
}
