package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.TurnoGrupoEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposTurnos extends Operation { 

  public TraerTiposTurnos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  IDataSet ds = this.getDataSetTurnoGrupoEntidad();
	  HashTableDatos tipos = TurnoGrupoEntidad.getTipos();
	  Iterator iterCodTipos = tipos.keySet().iterator();
	  while (iterCodTipos.hasNext()) {
		  String codigo = (String) iterCodTipos.next();
		  String descripcion = (String) tipos.get(codigo);
		  cargarRegistro(ds, codigo, descripcion);
	  }
	  writeCliente(ds);
  }

  private IDataSet getDataSetTurnoGrupoEntidad() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCompoTurnoGrupoEntidad");
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         String codigo,
                         String descripcion) {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
  
}
