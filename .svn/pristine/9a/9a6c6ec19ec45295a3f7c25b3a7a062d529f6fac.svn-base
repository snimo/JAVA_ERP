package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.Proyecto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpProyActClie extends Operation {

  public TraerHelpProyActClie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    
	IDataSet dsProyecto = this.getDataSetProyectos();  
	  
	Sujeto sujeto = Sujeto.findByOid(mapaDatos.getInteger("oid_sujeto"), this.getSesion());
	
	Iterator iterProyectos =
		sujeto.getProyectosActivos().iterator();
	while (iterProyectos.hasNext()) {
		Proyecto proyecto = (Proyecto) iterProyectos.next();
		cargarRegistro(dsProyecto, proyecto);
	}
	
	iterProyectos =
		Proyecto.getProyectosSinSujeto(true, this.getSesion()).iterator();
	while (iterProyectos.hasNext()) {
		Proyecto proyecto = (Proyecto) iterProyectos.next();
		cargarRegistro(dsProyecto, proyecto);
	}
	
	
	writeCliente(dsProyecto);
	
  }

  private IDataSet getDataSetProyectos() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpProyectos");
    dataset.fieldDef(new Field("oid_proyecto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_proyecto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_proyecto", Field.STRING, 100));
    dataset.fieldDef(new Field("cerrado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_sujeto", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                              Proyecto proyecto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_proyecto", proyecto.getOIDInteger());
    dataset.fieldValue("cod_proyecto", proyecto.getCodigo());
    dataset.fieldValue("desc_proyecto", proyecto.getDescripcion());
    dataset.fieldValue("cerrado", proyecto.isCerrado());
    dataset.fieldValue("activo", proyecto.isActivo());
    if (proyecto.getSujeto()!=null) {
    	dataset.fieldValue("oid_sujeto", proyecto.getSujeto().getOIDInteger());
    	dataset.fieldValue("cod_sujeto", proyecto.getSujeto().getCodigo());
    	dataset.fieldValue("desc_sujeto", proyecto.getSujeto().getRazon_social());
    } else {
    	dataset.fieldValue("oid_sujeto", new Integer(0));
    	dataset.fieldValue("cod_sujeto", "");
    	dataset.fieldValue("desc_sujeto", "");
    }
  }
}
