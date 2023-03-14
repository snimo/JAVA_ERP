package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.CompoEscenario;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.Escenario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;
import com.srn.erp.presupuesto.bm.ValorEscenario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEscenario extends Operation { 

  public SaveEscenario() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dsEscenario = mapaDatos.getDataSet("TEscenario"); 
    procesarRegistros(dsEscenario); 
  } 

  private void procesarRegistros(IDataSet dsEscenario) throws BaseException { 
  	dsEscenario.first(); 
      while (!dsEscenario.EOF()) { 
        Escenario escenario = Escenario.findByOid(dsEscenario.getInteger("oid_escenario"),getSesion());
        escenario.setCodigo(dsEscenario.getString("codigo"));
        escenario.setDescripcion(dsEscenario.getString("descripcion"));
        escenario.setActivo(dsEscenario.getBoolean("activo"));
        
        // Grabar los componentes del Escenario
        IDataSet dsCompoEscenario = dsEscenario.getDataSet("TCompoEscenario");
        dsCompoEscenario.first();
        while (!dsCompoEscenario.EOF()) {
        	CompoEscenario compoEscenario = CompoEscenario.findByOid(dsCompoEscenario.getInteger("oid_compo_esce"),getSesion());
        	compoEscenario.setEscenario(escenario);
        	compoEscenario.setNivel(dsCompoEscenario.getInteger("nivel"));
        	compoEscenario.setCompoPresupuestario(CompoPresupuestario.findByOid(dsCompoEscenario.getInteger("oid_compo_presu"),getSesion()));
        	compoEscenario.setActivo(dsCompoEscenario.getBoolean("activo"));
        	escenario.addDetalleCompoEscenario(compoEscenario);
        	dsCompoEscenario.next();
        }
        
        // Grabar los Valores de Escenarios
        IDataSet dsValoresEscenario = dsEscenario.getDataSet("TValoresEscenario");
        dsValoresEscenario.first();
        while (!dsValoresEscenario.EOF()) {
        	ValorEscenario valorEscenario = ValorEscenario.findByOid(dsValoresEscenario.getInteger("oid_val_escenario"),getSesion());
        	valorEscenario.setEscenario(escenario);
        	valorEscenario.setDescripcion(dsValoresEscenario.getString("descripcion"));
        	valorEscenario.setCompo_presu(CompoPresupuestario.findByOid(dsValoresEscenario.getInteger("oid_compo_presu"),getSesion()));
        	valorEscenario.setValor_compo(ValorCompoPresu.findByOid(dsValoresEscenario.getInteger("oid_valor_compo"),getSesion()));
        	valorEscenario.setNro_relacion(dsValoresEscenario.getString("nro_relacion"));
        	valorEscenario.setNro_relacion_padre(dsValoresEscenario.getString("nro_relacion_padre"));
        	valorEscenario.setUltimoNivel(dsValoresEscenario.getBoolean("ult_compo"));
        	valorEscenario.setActivo(dsValoresEscenario.getBoolean("activo"));
        	escenario.addValorEscenario(valorEscenario);
        	dsValoresEscenario.next();
        }
        
        addTransaccion(escenario);
        dsEscenario.next();
    }
  }
  
}
