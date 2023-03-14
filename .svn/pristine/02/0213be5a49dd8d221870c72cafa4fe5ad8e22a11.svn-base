package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValClasifLegEval extends Operation { 

  public TraerValClasifLegEval() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet dsValClasif = this.getDataSetValClasifLeg();  
	  
	Iterator iterClasificadores = Legajo.getClasificadoresEntidadActivos(this.getSesion()).iterator();
	while (iterClasificadores.hasNext()) {
		ClasificadorEntidad clasificador = (ClasificadorEntidad) iterClasificadores.next();
		Iterator iterValClasif = clasificador.getValoresClasificador().iterator();
		while (iterValClasif.hasNext()) {
			ValorClasificadorEntidad valorClasificadorEntidad = (ValorClasificadorEntidad) iterValClasif.next();
			if (!valorClasificadorEntidad.isActivo()) continue;
			cargarRegistroValClasifLeg(dsValClasif, valorClasificadorEntidad);
		}
	}
	
	writeCliente(dsValClasif);	  
    
  }

  private IDataSet getDataSetValClasifLeg() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValoresClasificadoresLegajo");
    dataset.fieldDef(new Field("oid_val_clasif", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_clasificador", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_val_clasif", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_val_clasif", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroValClasifLeg(IDataSet dataset, 
                          				  ValorClasificadorEntidad valor) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_val_clasif", valor.getOIDInteger());
    dataset.fieldValue("oid_clasificador", valor.getClasificador_entidad().getOIDInteger());
    dataset.fieldValue("cod_val_clasif", valor.getCodigo());
    dataset.fieldValue("desc_val_clasif", valor.getDescripcion());
  }
  

	  
}
