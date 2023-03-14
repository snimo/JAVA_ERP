package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Componente;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComponentes extends Operation {

  public TraerComponentes() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet dsComponentes = this.getDataSetComponente();
	  Iterator iterAllComponentes = 
		  Componente.getAllComponentes(this.getSesion()).iterator();
	  while (iterAllComponentes.hasNext()) {
		  Componente componente = (Componente) iterAllComponentes.next();
		  cargarRegistroComponente(dsComponentes, componente);
	  }
	  writeCliente(dsComponentes);

    
  }

  private IDataSet getDataSetComponente() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComponentes");
    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("tipo", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("nombre_nickname", Field.STRING, 50));
    dataset.fieldDef(new Field("nro_clasificador", Field.INTEGER, 0));
    dataset.fieldDef(new Field("longitud",Field.INTEGER, 0));
    dataset.fieldDef(new Field("precision",Field.INTEGER, 0));
    return dataset;
  }
  
  private void cargarRegistroComponente(IDataSet dataset,
                                        Componente compo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_compo", compo.getOIDInteger());
    dataset.fieldValue("codigo", compo.getCodigo());
    dataset.fieldValue("descripcion", compo.getDescripcion());
    dataset.fieldValue("tipo", compo.getTipo());
    dataset.fieldValue("activo", compo.isActivo());
    dataset.fieldValue("nombre_nickname", compo.getNombreNickName());
    dataset.fieldValue("nro_clasificador", compo.getNroClasificador());
    dataset.fieldValue("longitud", compo.getLongitud());
    dataset.fieldValue("precicion", compo.getPrecision());    
  }


}
