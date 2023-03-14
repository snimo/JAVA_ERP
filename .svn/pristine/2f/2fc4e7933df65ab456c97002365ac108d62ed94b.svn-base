package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.general.bm.TipoComprobante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposComproMovArqueo extends Operation {

  public TraerTiposComproMovArqueo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	Integer signo = mapaDatos.getInteger("signo");
	IDataSet ds = getDataSetTCMovArqueo();
	
	Iterator iterTiposCompro = 
		TipoComprobante.getTiposComproConMovArqueoSigno(this.getSesion(), signo).iterator();
	while (iterTiposCompro.hasNext()) {
		TipoComprobante tc = (TipoComprobante) iterTiposCompro.next();
		cargarRegistroTCMovArqueo(ds, tc);
	}
	
	writeCliente(ds);
	  
  }

  private IDataSet getDataSetTCMovArqueo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoComproMovArqueo");
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroTCMovArqueo(IDataSet dataset,
                         TipoComprobante tc) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tc", tc.getOIDInteger());
    dataset.fieldValue("codigo", tc.getCodigo());
    dataset.fieldValue("descripcion", tc.getDescripcion());
  }
}
