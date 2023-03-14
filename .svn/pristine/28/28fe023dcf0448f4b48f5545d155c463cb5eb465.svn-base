package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.AcuerdoLPDetalleDto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposAcuerdosDetDtos extends Operation {

  public TraerTiposAcuerdosDetDtos() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsTiposDtos = getDataSetTiposDtos();
    traerTiposDtos(dsTiposDtos);
    writeCliente(dsTiposDtos);
  }

  private void traerTiposDtos(IDataSet dataSet) throws BaseException {
	  int oid = 0;
	  Iterator iterCodigos = AcuerdoLPDetalleDto.getTiposDtos().keySet().iterator();
	  while (iterCodigos.hasNext()) {
		  String codigo = (String) iterCodigos.next();
		  String descripcion = (String) AcuerdoLPDetalleDto.getTiposDtos().get(codigo);
		  cargarRegistroTiposDtos(dataSet,new Integer(++oid),codigo,descripcion);
	  }
  }

  private IDataSet getDataSetTiposDtos() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposDtos");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroTiposDtos(IDataSet dataset,
                                       Integer oid,
                                       String codigo,
                                       String descripcion) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }

}
