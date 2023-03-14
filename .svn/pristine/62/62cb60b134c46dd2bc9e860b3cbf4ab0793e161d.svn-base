package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.Visita;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerVisitaTipoDocyNro extends Operation { 

  public TraerVisitaTipoDocyNro() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  
	TipoDocumento tipoDocu = TipoDocumento.findByOidProxy(mapaDatos.getInteger("oid_tipo_docu"), this.getSesion());
	String nroDocu = (String) mapaDatos.getString("nro_documento");
	IDataSet dsVisita = this.getDataSetVisitaPorDocu();
	Visita visita = Visita.getVisita(tipoDocu, nroDocu, this.getSesion());
	if (visita!=null)
		cargarRegistroVisita(dsVisita, visita);
	writeCliente(dsVisita);
	  
  }

  private IDataSet getDataSetVisitaPorDocu() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TVisitaPorDocu");
    dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_tipo_docu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_docu", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroVisita(IDataSet dataset, 
          							Visita aVisita) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_visita", aVisita.getOIDInteger()); 
    dataset.fieldValue("ape_y_nom", aVisita.getApeyNom());
    if (aVisita.getTipoDocumento()!=null)
    	dataset.fieldValue("oid_tipo_docu", aVisita.getTipoDocumento().getOIDInteger());
    else
    	dataset.fieldValue("oid_tipo_docu", "");
    dataset.fieldValue("nro_docu", aVisita.getNroDocumento()); 
    dataset.fieldValue("activo", aVisita.isActivo()); 
  }
}
