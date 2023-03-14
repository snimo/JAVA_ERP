package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.TiposEntidades;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposEntidadesCompro extends Operation {

  String nombreTabla = null;	
	
  public TraerTiposEntidadesCompro() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	nombreTabla = mapaDatos.getString("tableName");  
    int oid = 0;
    IDataSet dsTipoEntidad = getTipoEntidad();
    TiposEntidades tiposEntidades = new TiposEntidades();
    Iterator iterCodTipoEnt = tiposEntidades.getEntidadesComprobantes().keySet().iterator();
    while (iterCodTipoEnt.hasNext()) {
      String codigo = (String) iterCodTipoEnt.next();
      String descripcion = (String)tiposEntidades.getEntidades().get(codigo);
      ++oid;
      cargarTipoEntidad(dsTipoEntidad,
                        new Integer(oid),
                        codigo,
                        descripcion);
    }
    writeCliente(dsTipoEntidad);
  }

  private IDataSet getTipoEntidad() {
    IDataSet dataset = new TDataSet();
    dataset.create(nombreTabla);
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarTipoEntidad(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
