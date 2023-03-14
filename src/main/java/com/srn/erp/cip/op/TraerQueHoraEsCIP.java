package com.srn.erp.cip.op;

import java.text.SimpleDateFormat;

import com.srn.erp.cip.bm.UtilCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerQueHoraEsCIP extends Operation { 

  public TraerQueHoraEsCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  IDataSet ds = this.getDataSetHora();
	  cargarRegistroHora(ds);
	  writeCliente(ds);
  }

  private IDataSet getDataSetHora() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("THoraCIP");
    dataset.fieldDef(new Field("hora", Field.STRING, 50)); 
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("hora_minutos", Field.STRING, 5));
    return dataset;
  }

  private void cargarRegistroHora(
		  		IDataSet dataset) throws BaseException {
	  
	java.util.Date fecHorActual = 
		UtilCIP.getFechaHoraActual(this.getSesion());
    dataset.append(); 
    
    
    SimpleDateFormat sdfHoraMin = new SimpleDateFormat("HH:mm");
    SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
    dataset.fieldValue("hora", " Hora: "+sdfHora.format(fecHorActual));
    dataset.fieldValue("fecha", fecHorActual);
    dataset.fieldValue("hora_minutos", sdfHoraMin.format(fecHorActual));
    
  }
}
