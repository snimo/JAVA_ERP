package com.srn.erp.cashflow.op;


import java.util.Iterator;

import com.srn.erp.cashflow.bm.GrupoConceptoCF;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoConceptoCFPorCompor extends Operation { 

  public TraerGrupoConceptoCFPorCompor() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  
	IDataSet ds = this.getDataGrupoConc();
	String comportamiento = (String) mapaDatos.getString("comportamiento");
	
	Iterator iterGrupoConc = 
		GrupoConceptoCF.getGruposConcepto(comportamiento,this.getSesion()).iterator();
	while (iterGrupoConc.hasNext()) {
		GrupoConceptoCF grupoConcepto = (GrupoConceptoCF) iterGrupoConc.next();
		cargarRegistro(ds, grupoConcepto);
	}
	
	writeCliente(ds);
	  
  }

  private IDataSet getDataGrupoConc() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoConc");
    dataset.fieldDef(new Field("oid_grupo_conc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         GrupoConceptoCF grupoConceptoCF) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_conc", grupoConceptoCF.getOIDInteger());
    dataset.fieldValue("codigo", grupoConceptoCF.getCodigo());
    dataset.fieldValue("descripcion", grupoConceptoCF.getDescripcion());
  }
}
