package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerIniGenCodProdStock extends Operation { 

  public TraerIniGenCodProdStock() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet dsClasif = this.getDSClasificadores();
	IDataSet dsValoresClasif = getDSValoresClasif();
	  
	Iterator iterClasif =
		Producto.getClasificadoresEntidadActivos(this.getSesion()).iterator();
	while (iterClasif.hasNext()) {
		ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasif.next();
		
		if (Producto.getClasifProductoGeneral(this.getSesion()).getOID()==clasifEnt.getOID())
			continue;
		
		cargarClasificador(dsClasif, clasifEnt);
		
		Iterator iterValoresClasif =
			clasifEnt.getValoresClasificador().iterator();
		while (iterValoresClasif.hasNext()) {
			ValorClasificadorEntidad valorClasif = (ValorClasificadorEntidad) iterValoresClasif.next();
			cargarValorClasificador(dsValoresClasif, clasifEnt, valorClasif);
		}
		
	}
	
    writeCliente(dsClasif);
    writeCliente(dsValoresClasif);
    
  }

 private IDataSet getDSClasificadores() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TClasificadores");
    dataset.fieldDef(new Field("oid_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_clasif", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_clasif", Field.STRING, 255));
    return dataset;
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
 

  private void cargarClasificador(IDataSet dataset, 
                         		  ClasificadorEntidad aClasifEnt) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_clasif", aClasifEnt.getOIDInteger());
    dataset.fieldValue("cod_clasif", aClasifEnt.getCodigo());
    dataset.fieldValue("desc_clasif",aClasifEnt.getDescripcion());
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
