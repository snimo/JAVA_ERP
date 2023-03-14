package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.MovimientoCtaBancaria;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposMovCtasBanco extends Operation {

  public TraerTiposMovCtasBanco() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	 IDataSet ds = this.getDataSetTiposMov(); 
	 Iterator iterTiposMov =
		 MovimientoCtaBancaria.getTiposMovimientos().keySet().iterator();
	 while (iterTiposMov.hasNext()) {
		 String tipoMov = (String) iterTiposMov.next();
		 String descTipoMov = (String) MovimientoCtaBancaria.getDescTipoMov(tipoMov);
		 cargarRegistroTipoMov(ds, tipoMov, descTipoMov);
	 }
		 
    writeCliente(ds);
  }

  private IDataSet getDataSetTiposMov() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposMovCtaBco");
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroTipoMov(IDataSet dataset,
                         String codigo,
                         String descripcion) throws BaseException {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
