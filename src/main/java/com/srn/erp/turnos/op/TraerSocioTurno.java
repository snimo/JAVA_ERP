package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.DecodificarNroSocioTarjeta;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSocioTurno extends Operation { 

  public TraerSocioTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    
    IDataSet dsSocio = this.getDataSetSocioTurno();
    
    Sujeto sujeto = Sujeto.findByCodigo(mapaDatos.getString("nro"), this.getSesion());
    
    if (sujeto == null) {
    	String nroSocio = DecodificarNroSocioTarjeta.getDecodificarNroSocioTarjeta(this.getSesion(), mapaDatos.getString("nro"));
    	sujeto = Sujeto.findByCodigo(nroSocio, this.getSesion());
    }
    
    if (sujeto != null) 
        cargarRegistroSocioTurno(dsSocio, sujeto);
    
    writeCliente(dsSocio);
  }

  private IDataSet getDataSetSocioTurno() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TSocioTurno");
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroSocioTurno(IDataSet dataset, 
                         Sujeto sujeto) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_sujeto", sujeto.getOIDInteger());
    dataset.fieldValue("codigo", sujeto.getCodigo());
    dataset.fieldValue("descripcion", sujeto.getDescripcion());
    dataset.fieldValue("activo", sujeto.isActivo());
  }
}
