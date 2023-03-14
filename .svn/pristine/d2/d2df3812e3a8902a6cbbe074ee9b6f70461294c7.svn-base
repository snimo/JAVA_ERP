package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.*;

import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerConceptosSistemaClubes extends Operation { 

  public TraerConceptosSistemaClubes() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  IDataSet ds = this.getDataSet();
	  
	    int secu = 0;
		HashTableDatos conceptos = GrupoConceptoTurno.getConceptosSisteClubes(this.getSesion());
		Iterator iterCodConc = conceptos.keySet().iterator();
		while (iterCodConc.hasNext()) {
			String codigo = (String) iterCodConc.next();
			String descripcion = (String) conceptos.get(codigo.trim());
			cargarRegistro(ds, ++secu, codigo, descripcion);
		}
	  
	  
	  writeCliente(ds);
  }

  private IDataSet getDataSet() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TConceptosSistClub");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         Integer oid,
                         String codigo,
                         String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
