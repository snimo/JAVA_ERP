package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValoresClasificador extends Operation { 

  public TraerValoresClasificador() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet dsValoresClasif = getDSValoresClasif();
	  
	ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOidProxy(mapaDatos.getInteger("oid_clasificador"), this.getSesion());
	
	Iterator iterValoresClasif =
		clasifEnt.getValoresClasificador().iterator();
	while (iterValoresClasif.hasNext()) {
		ValorClasificadorEntidad valorClasif = (ValorClasificadorEntidad) iterValoresClasif.next();
		cargarValorClasificador(dsValoresClasif, clasifEnt, valorClasif);
	}
	
		
	writeCliente(dsValoresClasif);
    
  }

 private IDataSet getDSValoresClasif() { 
	IDataSet dataset = new TDataSet(); 
	dataset.create("TValoresClasificador");
	dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
	dataset.fieldDef(new Field("oid_valor_clasif", Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_clasif", Field.INTEGER, 0));
	dataset.fieldDef(new Field("codigo", Field.STRING, 50));
	dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
	return dataset;
 }
 

  private void cargarValorClasificador(IDataSet dataset, 
 		  ClasificadorEntidad aClasifEnt,
 		  ValorClasificadorEntidad aValorClasifEnt) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("sel", false);
	  dataset.fieldValue("oid_valor_clasif", aValorClasifEnt.getOIDInteger());
	  dataset.fieldValue("oid_clasif", aClasifEnt.getOIDInteger());
	  dataset.fieldValue("codigo", aValorClasifEnt.getCodigo());
	  dataset.fieldValue("descripcion", aValorClasifEnt.getDescripcion());
  }  
  
  
}
