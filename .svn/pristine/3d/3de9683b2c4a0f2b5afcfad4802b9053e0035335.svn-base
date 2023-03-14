package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Proyecto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarProyectoCliente extends Operation {

  public ValidarProyectoCliente() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  Proyecto proyecto = 
		  (Proyecto) Proyecto.findByCodigo(mapaDatos.getString("codigo"), this.getSesion());
	  if (proyecto == null)
		  throw new ExceptionValidation(null,"Código de Proyecto Inexistente");
	  
	  Sujeto sujeto = 
		  Sujeto.findByOid(mapaDatos.getInteger("oid_sujeto"), this.getSesion());
	  
	  if (proyecto.getSujeto()!=null)
		  if (proyecto.getSujeto().getOID() != sujeto.getOID())
			  throw new ExceptionValidation(null,"El proyecto seleccionado no pertenece al cliente seleccionado");
	  
	  IDataSet ds = this.getDataSetValProyecto();
	  cargarRegistroProyecto(ds, proyecto);
	  writeCliente(ds);
	
	
  }

  private IDataSet getDataSetValProyecto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValProyecto");
    dataset.fieldDef(new Field("oid_proyecto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_proyecto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_proyecto", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroProyecto(IDataSet dataset,
                         			  Proyecto proyecto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_proyecto", proyecto.getOIDInteger());
    dataset.fieldValue("codigo", proyecto.getCodigo());
    dataset.fieldValue("descripcion", proyecto.getDescripcion());
  }
}
