package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.DefinicionRepositorioReal;
import com.srn.erp.presupuesto.bm.ValorCompoReal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValoresCompoRealesParaFiltros extends Operation { 

	String nombreTable = null;
	
  public TraerValoresCompoRealesParaFiltros() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

  	nombreTable = mapaDatos.getString("nombre_tabla");
  	
  	DefinicionRepositorioReal defRepoReal =
  		DefinicionRepositorioReal.findByOid(mapaDatos.getInteger("oid_repo_det"),this.getSesion());
  	
  	
  	CompoPresupuestario compoPresu = defRepoReal.getCompo_presupuestario(); 
  	
  	IDataSet dsValCompoReal = this.getDataSetValorCompoReal();
  	
  	Iterator iterValReales = 
  		ValorCompoReal.getValoresRealesByCompoPresu(compoPresu,this.getSesion()).iterator();
  	while (iterValReales.hasNext()) {
  		ValorCompoReal valorCompoReal = 
  			(ValorCompoReal) iterValReales.next();
  		cargarRegistroValorCompoReal(dsValCompoReal,valorCompoReal);
  			
  	}
  	
  	writeCliente(dsValCompoReal);
  	
  }

  private IDataSet getDataSetValorCompoReal() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create(nombreTable);
    dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255)); 
    return dataset;
  }

  private void cargarRegistroValorCompoReal(IDataSet dataset, 
                         ValorCompoReal valorCompoReal) throws BaseException {
    dataset.append();
    dataset.fieldValue("sel", new Boolean(false));
    dataset.fieldValue("oid", valorCompoReal.getOIDInteger());
    dataset.fieldValue("codigo", valorCompoReal.getCodigo());
    dataset.fieldValue("descripcion", valorCompoReal.getDescripcion());
    
  }
}
